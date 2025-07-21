package fr.wijin.crm.filter;

import java.io.IOException;

import fr.wijin.crm.dao.ICustomerDAO;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebFilter;
import jakarta.servlet.http.HttpFilter;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebFilter("/*")
public class AppRequestFilter extends  HttpFilter{

    private static final long serialVersionUID = 1332L;
    private ICustomerDAO customerDAO;

    @Override
    public void init() throws ServletException {
        this.customerDAO = (ICustomerDAO) this.getServletContext().getAttribute("customerDAO");

    }
    
    @Override
    public void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain chain) throws IOException, ServletException {
        var session = request.getSession();
        if (session.getAttribute("customers") == null) {

            session.setAttribute("customers", this.customerDAO.getAllCustomers());
        } 

        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        // Cleanup resources if needed
        super.destroy();
    }
    
}
