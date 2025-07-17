package fr.wijin.crm.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import fr.wijin.crm.dao.database.DatabaseConnection;
import fr.wijin.crm.model.Customer;

public class CustomerDAOjdbcImpl implements ICustomerDAO {

    private final String CREATE_CUSTOMER = "INSERT INTO customers (lastname, firstname,company, mail, phone) VALUES (?, ?, ?, ?, ?)";

    private static CustomerDAOjdbcImpl instance;

    CustomerDAOjdbcImpl() {

    }

    public synchronized static CustomerDAOjdbcImpl getInstance() {
        if (instance == null) {
            instance = new CustomerDAOjdbcImpl();
        }
        return instance;
    }


    @Override
    public Customer createCustomer(Customer customer) {
        try (Connection cnx = DatabaseConnection.getConnection()) {
            PreparedStatement pstmt = cnx.prepareStatement(CREATE_CUSTOMER, PreparedStatement.RETURN_GENERATED_KEYS);

            pstmt.setString(1, customer.getLastname());
            pstmt.setString(2, customer.getFirstname());
            pstmt.setString(3, customer.getCompany());
            pstmt.setString(4, customer.getMail());
            pstmt.setString(5, customer.getPhone());

            int rowsAffected = pstmt.executeUpdate();
            
            if (rowsAffected > 0) {
                try (ResultSet rs = pstmt.getGeneratedKeys()) {
                    if (rs.next()) {
                        customer.setId(rs.getInt(1));
                    }
                }
            }

        } catch (Exception e) {

            throw new RuntimeException("Error creating customer", e);
        }

        return customer;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getCustomerById'");
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'updateCustomer'");
    }

    @Override
    public void deleteCustomer(Integer id) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'deleteCustomer'");
    }

    @Override
    public List<Customer> getAllCustomers() {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'getAllCustomers'");
    }

}
