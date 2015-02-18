package jmp.module14.controller;

import java.io.IOException;
import java.util.Collection;
import java.util.Collections;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import jmp.module14.data.OrderService;
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
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		String ticketId = (String)request.getParameter("ticketId");
		Long count = Long.parseLong(request.getParameter("count"));
		Double ballance = 0.0D;
		Collection<Ticket> tickets = Collections.emptyList();
		
		orderService.order(ticketId, count);
		
		ballance = orderService.getMember().getBallance();
		tickets = orderService.getTickets();
		request.setAttribute("ballance", ballance);
		request.setAttribute("tickets", tickets);
		
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}
}
