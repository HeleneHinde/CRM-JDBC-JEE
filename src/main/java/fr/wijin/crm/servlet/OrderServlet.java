package fr.wijin.crm.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class OrderServlet extends AppServlet {

	private static final long serialVersionUID = 7232896601780995455L;

	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		// Récupération des données saisies
		// TODO

		/*
		 * Initialisation du message à afficher : si un des champs obligatoires du
		 * formulaire n'est pas renseigné, alors on affiche un message d'erreur, sinon
		 * on affiche un message de succès
		 */
		// TODO

		// Création des beans Customer et Order et initialisation avec les données
		// récupérées
		// TODO

		// Ajout du bean Order et du message à l'objet requête
		// TODO

		// Transmission à la page JSP en charge de l'affichage des données
		// TODO
	}

}
