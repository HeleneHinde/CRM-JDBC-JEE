package fr.wijin.crm.servlet;

import java.io.IOException;

import fr.wijin.crm.dao.DAOFactory;
import fr.wijin.crm.dao.ICustomerDAO;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createOrder")
public class OrderServlet extends AppServlet {

	private static final long serialVersionUID = 7232896601780995455L;
	public ICustomerDAO customerDAO = DAOFactory.getCustomerDAO();

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Charger la liste des customers pour le select
		loadCustomersForSelect(request);

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
