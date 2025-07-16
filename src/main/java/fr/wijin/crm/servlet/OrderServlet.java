package fr.wijin.crm.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderServlet extends AppServlet {

	private static final long serialVersionUID = 7232896601780995455L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		this.redirectToJSP(request, response, "/createOrder.jsp");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de la
		 * requête POST
		 */
		String orderId = request.getParameter("orderId");
		String customerId = request.getParameter("customerId");
		String label = request.getParameter("label");	
		int adrEt = Integer.parseInt(request.getParameter("adrEt"));
		int numberOfDays = Integer.parseInt(request.getParameter("numberOfDays"));
		int tva = Integer.parseInt(request.getParameter("tva"));
		String status = getInitParameter("status");
		String type = getInitParameter("type");
		String notes = request.getParameter("notes");

		



		this.redirectToJSP(request, response, "/viewOrder.jsp");
	}

}
