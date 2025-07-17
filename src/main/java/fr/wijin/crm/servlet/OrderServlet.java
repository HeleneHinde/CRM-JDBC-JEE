package fr.wijin.crm.servlet;

import java.io.IOException;
import java.util.Random;

import fr.wijin.crm.dao.DAOFactory;
import fr.wijin.crm.dao.ICustomerDAO;
import fr.wijin.crm.dao.IOrderDAO;
import fr.wijin.crm.model.Customer;
import fr.wijin.crm.model.Order;
import fr.wijin.crm.service.FormService;
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

		// Charger la liste des customers pour le select
		loadCustomersForSelect(request);

		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de la
		 * requête POST
		 */
		int customerId = FormService.toInteger(request.getParameter("customer"));
		String label = request.getParameter("label");
		Double adrEt = FormService.toDouble(request.getParameter("adrEt"));
		Double numberOfDays = FormService.toDouble(request.getParameter("numberOfDays"));
		Double tva = FormService.toDouble(request.getParameter("tva"));
		String status = request.getParameter("status");
		String type = request.getParameter("type");
		String notes = request.getParameter("notes");

		String message = "Félicitation pour cette commande !";
		// create order
		Order order = new Order();

		if (!FormService.estPresent(label) || adrEt == null
				|| numberOfDays == null || tva == null
				|| !FormService.estPresent(status) || !FormService.estPresent(type)) {

			message = "Le formulaire est mal renseigné."
					+ " <a href=\"createOrder.jsp\">Réessayer</a>";
		} else {

			Customer customer = new Customer();
			try {
				customer = customerDAO.getCustomerById(customerId);
				order.setCustomer(customer);
			} catch (IllegalArgumentException e) {
				request.setAttribute("error", e.getMessage());
				this.redirectToJSP(request, response, "/createOrder.jsp");
				return;
			}
			order.setId(new Random().nextInt(10000)); // TODO: Use a better ID generation strategy
			order.setLabel(label);
			order.setAdrEt(adrEt);
			order.setNumberOfDays(numberOfDays);
			order.setTva(tva);
			order.setStatus(status);
			order.setType(type);
			order.setNotes(notes);

			// Enregistrer la commande dans la base de données
			orderDAO.createOrder(order);
		}

		// Ajout du bean Order et du message à l'objet requête
		request.setAttribute("order", order);
		request.setAttribute("message", message);

		this.redirectToJSP(request, response, "/viewOrder.jsp");
	}

}
