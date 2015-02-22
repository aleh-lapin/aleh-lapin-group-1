package jmp.module14.controller;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmp.module14.data.OrderService;
import jmp.module14.message.Message;
import jmp.module14.model.Ticket;

@WebServlet(name="OrderServlet", displayName="Order Servlet", urlPatterns = {"/order"}, loadOnStartup=1)
public class OrderServlet extends HttpServlet {

	private static final long serialVersionUID = 8865327438947369881L;
	@Inject
	private OrderService orderService;

	public OrderServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String ticketId = request.getParameter("ticketId");
		Ticket ticket = orderService.getTicket(ticketId);
		request.setAttribute("ticket", ticket);
		request.getRequestDispatcher("/order.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
		ContextListener.addHttpServletResponse(response);
	}

	private void process(final HttpServletRequest request, final HttpServletResponse response) throws ServletException, IOException  {
		final String ticketId = (String)request.getParameter("ticketId");
		final Long count = Long.parseLong(request.getParameter("count"));
		List<Message> messages = new ArrayList<Message>();

		Double ballance = 0.0D;
		Collection<Ticket> tickets = Collections.emptyList();

		orderService.order(ticketId, count);

		ballance = orderService.getMember().getBallance();
		tickets = orderService.getTickets();
		request.setAttribute("ballance", ballance);
		request.setAttribute("tickets", tickets);

		try {
			Thread.sleep(1000);
			synchronized (ContextListener.getMessages()) {
				while(ContextListener.getMessages().size() > 0) {
					messages.add(ContextListener.getMessages().poll());
				}
			}
			request.setAttribute("messages", messages);
			getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		} 


	}
}
