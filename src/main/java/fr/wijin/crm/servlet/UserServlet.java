package fr.wijin.crm.servlet;

import java.io.IOException;

import fr.wijin.crm.form.UserForm;
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
		this.redirectToJSP(request, response, "/WEB-INF/createUser.jsp");
	}

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	

		UserForm userForm = new UserForm(request);

		/* Transmission à la page JSP en charge de l'affichage des données */
		this.redirectToJSP(request, response, "/WEB-INF/viewUser.jsp");

	}

}
