package jmp.module14.comunicate;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.net.InetSocketAddress;
import java.net.SocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

import jmp.module14.message.Message;

public class ClientComunicator {

	private int port;
	private String hostName;


	public ClientComunicator(int port, String hostName) {
		super();
		this.port = port;
		this.hostName = hostName;
	}

	public void sendMessage(Message message) {
		SocketAddress address = new InetSocketAddress(hostName, port);
		SocketChannel client = null;
		try {
			client = SocketChannel.open(address);

			ByteArrayOutputStream nestedStream = new ByteArrayOutputStream();
			ObjectOutput objectOutputStream = new ObjectOutputStream(nestedStream);
			objectOutputStream.writeObject(message);
			ByteBuffer buffer = ByteBuffer.wrap(nestedStream.toByteArray());
			client.configureBlocking(false);
			client.write(buffer);
			client.finishConnect();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (client != null){
				try {
					client.close();
				} catch (IOException e) {}
			}
		}
	}

}
