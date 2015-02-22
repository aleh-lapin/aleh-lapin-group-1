package jmp.module14.controller;

import java.io.PrintWriter;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

import javax.servlet.AsyncContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.http.HttpServletResponse;

import jmp.module14.comunicate.ServerComunicator;
import jmp.module14.message.Message;

public class ContextListener implements ServletContextListener {

	private static final BlockingQueue<HttpServletResponse> queue = new LinkedBlockingQueue<HttpServletResponse>();
	private static final BlockingQueue<Message> messages = new LinkedBlockingQueue<Message>();

	private ServerComunicator serverComunicator;

	private Thread threadObsrever;

	public static void addHttpServletResponse(HttpServletResponse response) {
		queue.add(response);
	}

	public static BlockingQueue<Message> getMessages() {
		return messages;
	}

	@Override
	public void contextDestroyed(ServletContextEvent arg0) {
		serverComunicator.stopRunning();
		threadObsrever.interrupt();
	}

	@Override
	public void contextInitialized(ServletContextEvent arg0) {
		//arg0.getServletContext().addListener(PostRequestListener.class);
		serverComunicator = new ServerComunicator("localhost", 1025);
		serverComunicator.startRunning();
		threadObsrever = new Thread(new Runnable() {

			@Override
			public void run() {
				while (true) {
					try {
						synchronized(ServerComunicator.getMessageQueue()){
							while(ServerComunicator.getMessageQueue().size() > 0) {
								Message message = ServerComunicator.getMessageQueue().poll();
								messages.put(message);
							}
						}
					} catch (Exception e) {
						throw new RuntimeException(e.getMessage(), e);
					}
				}


			}
		});
		threadObsrever.start();

	}

}
