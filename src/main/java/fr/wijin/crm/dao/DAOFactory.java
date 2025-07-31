package fr.wijin.crm.dao;

import fr.wijin.crm.dao.jpa.CustomerDAOJPA;

public class DAOFactory {

    public static ICustomerDAO getCustomerDAO() {
        // return CustomerDAOCollection.getInstance();
        return CustomerDAOJPA.getInstance();
    }

    public static IOrderDAO getOrderDAO() {
        return OrderDAOCollection.getInstance();
    }

}
