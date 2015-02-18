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

@WebServlet("/manager")
public class ManagementServlet extends HttpServlet {

	private static final long serialVersionUID = 8865327438947369881L;
	@Inject
	private OrderService orderService;
	
	public ManagementServlet() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		process(request, response);
	}
	
	private void process(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException  {
		Double ballance = 0.0D;
		Collection<Ticket> tickets = Collections.emptyList();
		ballance = orderService.getMember().getBallance();
		tickets = orderService.getTickets();
		request.setAttribute("ballance", ballance);
		request.setAttribute("tickets", tickets);
		getServletContext().getRequestDispatcher("/index.jsp").forward(request, response);
	}

}
