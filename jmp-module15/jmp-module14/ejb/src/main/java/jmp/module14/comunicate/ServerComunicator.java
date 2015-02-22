package jmp.module14.comunicate;

import jmp.module14.message.Message;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.channels.spi.SelectorProvider;
import java.util.Iterator;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;

public class ServerComunicator extends Thread {

	public static final int NUMBER_OF_THREADS = 3;
	private InetSocketAddress socketAddress;
	private Selector selector;
	private ExecutorService threadPool;
	private LinkedBlockingQueue<ByteBuffer> bufferPool;
	private boolean running;
	private static BlockingQueue<Message> messageQueue = new ArrayBlockingQueue<Message>(50);;

	public ServerComunicator(String host, int port) {
		super();
		socketAddress = new InetSocketAddress(host, port);
		try {
			selector = SelectorProvider.provider().openSelector();
		} catch (Exception e) {
			e.printStackTrace();
		}
		this.threadPool = Executors.newFixedThreadPool(NUMBER_OF_THREADS);
		this.bufferPool = new LinkedBlockingQueue<ByteBuffer>();
		for (int i = 0; i < NUMBER_OF_THREADS; i++) {
			this.bufferPool.add(ByteBuffer.allocate(4096));
		}
	}
	
	public static BlockingQueue<Message> getMessageQueue() {
		return messageQueue;
	}

	public synchronized void startRunning() {
		this.running = true;
		this.start();
	}

	public synchronized void stopRunning() {
		this.running = false;
		this.selector.wakeup();
	}

	protected synchronized boolean isRunning() {
		return this.running;
	}

	public void run() {
		ServerSocketChannel serverChannel = null;
		try {
			serverChannel = ServerSocketChannel.open();
			serverChannel.configureBlocking(false);
			serverChannel.socket().bind(socketAddress);
			serverChannel.register(this.selector, SelectionKey.OP_ACCEPT);
		} catch (Exception e) {
			e.printStackTrace();
		}

		while (this.isRunning()) {
			try {
				this.selector.select(5000);
				Iterator<SelectionKey> selectedKeys = this.selector.selectedKeys().iterator();
				while (selectedKeys.hasNext()) {
					final SelectionKey key = selectedKeys.next();
					selectedKeys.remove();

					if (!key.isValid()) {
						continue;
					}

					if (key.isConnectable()) {
						key.interestOps(key.interestOps()
								^ SelectionKey.OP_CONNECT);
						this.doConnect(key);
					}
					if (key.isAcceptable()) {
						key.interestOps(key.interestOps()
								^ SelectionKey.OP_ACCEPT);
						this.doAccept(key);
					}

					if (key.isReadable()) {
						key.interestOps(key.interestOps()
								^ SelectionKey.OP_READ);

						this.threadPool.submit(new Runnable(){
							@Override
							public void run() {
								try {
									doRead(key);
								} catch (Exception e) {
									try {
										cancelChannel(key.channel());
									} catch (IOException e1) {
										e1.printStackTrace();
									}
								}
							}
						});
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}

		try {
			serverChannel.close();
		} catch (IOException e1) {
		}

	}

	private void doConnect(SelectionKey key) {
		SocketChannel socketChannel = (SocketChannel) key.channel();

		try {
			socketChannel.finishConnect();
		} catch (IOException e) {
			key.cancel();
			return;
		}

		this.selector.wakeup();

	}

	protected void doAccept(SelectionKey key) throws Exception {
		ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key
				.channel();
		SocketChannel socketChannel = serverSocketChannel.accept();
		socketChannel.configureBlocking(false);
		socketChannel.register(this.selector, SelectionKey.OP_READ);
		key.interestOps(key.interestOps() | SelectionKey.OP_ACCEPT);
	}

	protected void doRead(SelectionKey key) throws Exception {
		SocketChannel socketChannel = (SocketChannel) key.channel();
		ByteBuffer rBuffer = this.bufferPool.take();
		rBuffer.clear();
		int numRead;
		try {
			numRead = socketChannel.read(rBuffer);
		} catch (Exception e) {
			numRead = -1;
		}

		if (numRead <= 0) {
			key.channel().close();
			key.cancel();
			return;
		}

		byte[] objectBytes = rBuffer.array();

		if (objectBytes != null) {
			ObjectInputStream stream = new ObjectInputStream(new ByteArrayInputStream(rBuffer.array()));
			Message message = (Message)stream.readObject();
			messageQueue.put(message);
		}

		this.bufferPool.add(rBuffer);
		this.selector.wakeup();

	}
	
	public void cancelChannel(SelectableChannel channel) throws IOException {
		if (channel != null) {
			channel.close();
			return;
		}
	}

	public int getPort() {
		return socketAddress.getPort();
	}

}
