package fr.wijin.crm.servlet;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import fr.wijin.crm.dao.DAOFactory;
import fr.wijin.crm.model.Customer;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class AppServlet extends HttpServlet {
    
    private static final long serialVersionUID = 1L;

    public void redirectToJSP(HttpServletRequest request, HttpServletResponse response, String jspPath) throws ServletException, IOException {
        this.getServletContext().getRequestDispatcher(jspPath).forward(request, response);
    }
    
    /**
     * Récupère la liste des customers pour les selects
     * @param request La requête HTTP
     */
    protected void loadCustomersForSelect(HttpServletRequest request) {
        try {
            List<Customer> customers = DAOFactory.getCustomerDAO().getAllCustomers();
            request.setAttribute("customers", customers);
        } catch (Exception e) {
            // En cas d'erreur, on met une liste vide
            request.setAttribute("customers", new ArrayList<Customer>());
        }
    }
}
