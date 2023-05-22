package fr.wijin.crm.servlet;

import java.io.IOException;

import fr.wijin.crm.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomerServlet extends HttpServlet {

	private static final long serialVersionUID = 7423961403387736524L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de la
		 * requête GET
		 */
		String lastname = request.getParameter("lastname");
		String firstname = request.getParameter("firstname");
		String company = request.getParameter("company");
		String phone = request.getParameter("phone");
		String mobile = request.getParameter("mobile");
		String mail = request.getParameter("mail");
		String notes = request.getParameter("notes");

		String message;
		/*
		 * Initialisation du message à afficher : si un des champs obligatoires du
		 * formulaire n'est pas renseigné, alors on affiche un message d'erreur, sinon
		 * on affiche un message de succès
		 */
		if (lastname.trim().isEmpty() || company.trim().isEmpty() || phone.trim().isEmpty() || mail.trim().isEmpty()) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"createCustomer.jsp\">Cliquez ici</a> pour accéder au formulaire de création d'un client.";
		} else {
			message = "Client créé avec succès !";
		}
		/*
		 * Création du bean Client et initialisation avec les données récupérées
		 */
		Customer customer = new Customer();
		customer.setLastname(lastname);
		customer.setFirstname(firstname);
		customer.setCompany(company);
		customer.setPhone(phone);
		customer.setMobile(mobile);
		customer.setMail(mail);
		customer.setNotes(notes);
		customer.setActive(true);

		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute("customer", customer);
		request.setAttribute("message", message);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.getServletContext().getRequestDispatcher("/viewCustomer.jsp").forward(request, response);
	}

}
