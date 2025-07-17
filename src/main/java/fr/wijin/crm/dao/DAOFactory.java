package fr.wijin.crm.dao;

public class DAOFactory {

    public static ICustomerDAO getCustomerDAO() {
        return CustomerDAOCollection.getInstance();
    }

    public static IOrderDAO getOrderDAO() {
        return OrderDAOCollection.getInstance();
    }

}
