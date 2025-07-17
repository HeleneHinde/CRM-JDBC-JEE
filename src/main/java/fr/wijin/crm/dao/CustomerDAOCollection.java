package fr.wijin.crm.dao;

import java.util.ArrayList;
import java.util.List;

import fr.wijin.crm.model.Customer;

public class CustomerDAOCollection implements ICustomerDAO {

    private final List<Customer> customers = new ArrayList<>();

    private static CustomerDAOCollection instance;

    CustomerDAOCollection() {

    }

    public synchronized static CustomerDAOCollection getInstance() {
        if (instance == null) {
            instance = new CustomerDAOCollection();
        }
        return instance;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        if (customer == null) {
            throw new IllegalArgumentException("Customer cannot be null");
        }

        boolean isPresent = customers.stream()
                .anyMatch(c -> c.getLastname().equals(customer.getLastname())
                        && c.getFirstname().equals(customer.getFirstname()));

        if (isPresent) {
            throw new IllegalArgumentException("Customer with name " + customer.getFirstname() + " "
                    + customer.getLastname() + " already exists.");
        } else {
            customers.add(customer);
        }
        return customer;
    }

    @Override
    public Customer getCustomerById(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }

        return customers.stream()
                .filter(customer -> customer.getId().equals(id))
                .findFirst()
                .orElse(null);
    }

    @Override
    public Customer updateCustomer(Customer customer) {
        Customer existingCustomer = getCustomerById(customer.getId());
        if (existingCustomer == null) {
            throw new IllegalArgumentException("Customer with ID " + customer.getId() + " does not exist.");
        }
        existingCustomer.setFirstname(customer.getFirstname());
        existingCustomer.setLastname(customer.getLastname());
        existingCustomer.setMail(customer.getMail());
        existingCustomer.setPhone(customer.getPhone());
        existingCustomer.setCompany(customer.getCompany());
        return existingCustomer;
    }

    @Override
    public void deleteCustomer(Integer id) {
        if (id == null) {
            throw new IllegalArgumentException("ID cannot be null");
        }
        boolean removed = customers.removeIf(c -> c.getId().equals(id));
        if (!removed) {
            throw new IllegalArgumentException("Customer with ID " + id + " does not exist.");
        }
    }

    @Override
    public List<Customer> getAllCustomers() {
        return new ArrayList<>(customers);
    }

}
