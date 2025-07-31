package fr.wijin.crm.servlet;

import java.io.IOException;

import fr.wijin.crm.dao.database.JPAUtil;
import jakarta.persistence.EntityManager;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/initjpa")
public class InitJPAServlet extends HttpServlet {
    
     @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) 
            throws ServletException, IOException {
        
        response.setContentType("text/html; charset=UTF-8");
        
        StringBuilder html = new StringBuilder();
        html.append("<h1>Test JPA Simple</h1>");
        
        if (JPAUtil.isInitialized()) {
            html.append("<p style='color: green;'>✅ JPA initialisé</p>");
            
            EntityManager em = JPAUtil.getEntityManager();
            try {
                // Test simple
                Object result = em.createNativeQuery("SELECT current_database()").getSingleResult();
                html.append("<p>Base de données : ").append(result).append("</p>");
                
                // Compter les enregistrements dans Customer
                Long customerCount = em.createQuery("SELECT COUNT(c) FROM Customer c", Long.class).getSingleResult();
                html.append("<p>Customers : ").append(customerCount).append("</p>");
                
            } catch (Exception e) {
                html.append("<p style='color: red;'>❌ Erreur : ").append(e.getMessage()).append("</p>");
            } finally {
                em.close();
            }
            
        } else {
            html.append("<p style='color: red;'>❌ JPA non initialisé</p>");
        }
        
        response.getWriter().write(html.toString());
    }
}