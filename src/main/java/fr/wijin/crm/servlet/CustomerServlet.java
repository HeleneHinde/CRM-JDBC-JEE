package fr.wijin.crm.servlet;

import java.io.IOException;
import fr.wijin.crm.dao.DAOFactory;
import fr.wijin.crm.dao.ICustomerDAO;
import fr.wijin.crm.model.Customer;
import fr.wijin.crm.service.CustomerForm;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

@WebServlet("/createCustomer")
public class CustomerServlet extends AppServlet {

	private static final long serialVersionUID = 7423961403387736524L;
	private ICustomerDAO customerDAO = DAOFactory.getCustomerDAO();

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
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

		String message = "Client créé avec succès !";
		Customer customer = new Customer();
		/*
		 * Création du bean Client et initialisation avec les données récupérées
		 */

		customer.setLastname(lastname);
		customer.setFirstname(firstname);
		customer.setCompany(company);
		customer.setPhone(phone);
		customer.setMobile(mobile);
		customer.setMail(mail);
		customer.setNotes(notes);
		customer.setActive(true);

		HttpSession session = request.getSession();
		session.setAttribute("customer", customer);
		/*
		 * Initialisation du message à afficher : si un des champs obligatoires du
		 * formulaire n'est pas renseigné, alors on affiche un message d'erreur, sinon
		 * on affiche un message de succès
		 */
		String lien = null;
		if (!CustomerForm.estPresent(lastname) || !CustomerForm.estPresent(company) || !CustomerForm.estPresent(phone)
				|| !CustomerForm.estPresent(mail)) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires";
			lien = "/createCustomer";
			request.setAttribute("customer", customer);
			request.setAttribute("message", message);
			request.setAttribute("lien", lien);
			this.redirectToJSP(request, response, "/WEB-INF/createCustomer.jsp");
			return;

		} else {
			customerDAO.createCustomer(customer);
		}

		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute("customer", customer);
		request.setAttribute("message", message);
		request.setAttribute("lien", lien);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.redirectToJSP(request, response, "/WEB-INF/viewCustomer.jsp");
	}

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		HttpSession session = request.getSession();

		Customer customer = (Customer) session.getAttribute("customer");
		if (customer != null) {
			request.setAttribute("customer", customer);
		}

		/* Redirection vers la page de création de client */
		this.redirectToJSP(request, response, "/WEB-INF/createCustomer.jsp");
	}

}
