package fr.wijin.crm.dao;

import java.util.List;

import fr.wijin.crm.model.Customer;

public interface ICustomerDAO {
    /**
     * Method to create a new customer in the database.
     *
     * @param customer The customer object to be created.
     * @return The created customer object with its ID populated.
     */
    public Customer createCustomer(Customer customer);

    /**
     * Method to retrieve a customer by its ID.
     *
     * @param id The ID of the customer to retrieve.
     * @return The customer object if found, null otherwise.
     */
    public Customer getCustomerById(Integer id);

    /**
     * Method to update an existing customer in the database.
     *
     * @param customer The customer object with updated information.
     * @return The updated customer object.
     */
    public Customer updateCustomer(Customer customer);

    /**
     * Method to delete a customer from the database by its ID.
     *
     * @param id The ID of the customer to delete.
     */
    public void deleteCustomer(Integer id);

    public List<Customer> getAllCustomers();

}
