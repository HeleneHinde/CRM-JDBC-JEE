package fr.wijin.crm.servlet;

import java.io.IOException;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public void redirectToJSP(HttpServletRequest request, HttpServletResponse response, String jspPath) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
    }
    
}
