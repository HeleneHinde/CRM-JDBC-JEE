package fr.wijin.crm.servlet;

import java.io.IOException;

import fr.wijin.crm.model.User;
import fr.wijin.crm.service.FormService;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/createUser")
public class UserServlet extends AppServlet {

	private static final long serialVersionUID = 3327502512201809201L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.redirectToJSP(request, response, "/createUser.jsp");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de la
		 * requête GET
		 */
		String username = request.getParameter("username");
		String password = request.getParameter("password");
		String mail = request.getParameter("mail");
		String grants = request.getParameter("grants");

		String message = "Utilisateur créé avec succès !";
		User user = new User();

		/*
		 * Initialisation du message à afficher : si un des champs obligatoires du
		 * formulaire n'est pas renseigné, alors on affiche un message d'erreur, sinon
		 * on affiche un message de succès
		 */
		if (!FormService.estPresent(username) || !FormService.estPresent(password) || !FormService.estPresent(mail)) {
			message = "Erreur - Vous n'avez pas rempli tous les champs obligatoires. <br> <a href=\"/crm/createUser\">Cliquez ici</a> pour accéder au formulaire de création d'un utilisateur.";
		} else {

			/*
			 * Création du bean Utilisateur et initialisation avec les données récupérées
			 */
		
			user.setUsername(username);
			user.setPassword(password);
			user.setMail(mail);
			user.setGrants(grants);
		}

		/* Ajout du bean et du message à l'objet requête */
		request.setAttribute("user", user);
		request.setAttribute("message", message);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.redirectToJSP(request, response, "/viewUser.jsp");

	}

}
