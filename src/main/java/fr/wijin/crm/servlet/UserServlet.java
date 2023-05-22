package fr.wijin.crm.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class UserServlet extends HttpServlet {

	private static final long serialVersionUID = 3327502512201809201L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		/*
		 * Récupération des données saisies, envoyées en tant que paramètres de la
		 * requête GET
		 */
		// TODO

		/*
		 * Initialisation du message à afficher : si un des champs obligatoires du
		 * formulaire n'est pas renseigné, alors on affiche un message d'erreur, sinon
		 * on affiche un message de succès
		 */
		// TODO

		/*
		 * Création du bean Client et initialisation avec les données récupérées
		 */
		// TODO

		/* Ajout du bean et du message à l'objet requête */
		// TODO

		/* Transmission à la page JSP en charge de l'affichage des données */
		// TODO
	}

}
