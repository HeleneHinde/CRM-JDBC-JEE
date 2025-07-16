package fr.wijin.crm.dao;

public class DAOFactory {

    public static ICustomerDAO getCustomerDAO() {
        return CustomerDAOCollection.getInstance();
    }

}
