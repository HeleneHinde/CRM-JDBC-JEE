package fr.wijin.crm.listener;

import java.sql.SQLException;

import fr.wijin.crm.dao.DAOFactory;
import fr.wijin.crm.dao.database.DatabaseConnection;
import jakarta.servlet.ServletContextEvent;
import jakarta.servlet.ServletContextListener;
import jakarta.servlet.annotation.WebListener;

@WebListener
public class InitAppListener implements ServletContextListener {

    @Override
    public void contextInitialized(ServletContextEvent sce) {
        sce.getServletContext().setAttribute("customerDAO", DAOFactory.getCustomerDAO());
        ServletContextListener.super.contextInitialized(sce);
    }

    @Override
    public void contextDestroyed(ServletContextEvent sce) {
        try {
            DatabaseConnection.closeDataSource();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    
}
