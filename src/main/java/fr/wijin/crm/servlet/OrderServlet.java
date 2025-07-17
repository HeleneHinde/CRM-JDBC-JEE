package fr.wijin.crm.servlet;

import java.io.IOException;
import java.util.Random;

import fr.wijin.crm.dao.DAOFactory;
import fr.wijin.crm.dao.ICustomerDAO;
import fr.wijin.crm.dao.IOrderDAO;
import fr.wijin.crm.model.Customer;
import fr.wijin.crm.model.Order;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createOrder")
public class OrderServlet extends AppServlet {

	private static final long serialVersionUID = 7232896601780995455L;
	public ICustomerDAO customerDAO = DAOFactory.getCustomerDAO();
	public IOrderDAO orderDAO = DAOFactory.getOrderDAO();

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
		int customerId = Integer.parseInt(request.getParameter("customerId"));
		String label = request.getParameter("label");	
		Double adrEt = Double.valueOf(request.getParameter("adrEt"));
		Double numberOfDays = Double.valueOf(request.getParameter("numberOfDays"));
		Double tva = Double.valueOf(request.getParameter("tva"));
		String status = getInitParameter("status");
		String type = getInitParameter("type");
		String notes = request.getParameter("notes");

		Customer customer = customerDAO.getCustomerById(customerId);

		// Créer la commande avec les données récupérées
		Order order = new Order();
		order.setId(new Random().nextInt(10000)); //TODO: Use a better ID generation strategy
		order.setCustomer(customer);
		order.setLabel(label);
		order.setAdrEt(adrEt);
		order.setNumberOfDays(numberOfDays);
		order.setTva(tva);
		order.setStatus(status);
		order.setType(type);
		order.setNotes(notes);

		// Enregistrer la commande dans la base de données
		orderDAO.createOrder(order);

		this.redirectToJSP(request, response, "/viewOrder.jsp");
	}

}
