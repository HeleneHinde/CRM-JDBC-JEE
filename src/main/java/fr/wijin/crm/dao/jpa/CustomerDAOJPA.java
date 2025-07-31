package fr.wijin.crm.dao.jpa;

import java.util.List;

import fr.wijin.crm.dao.ICustomerDAO;
import fr.wijin.crm.dao.database.JPAUtil;
import fr.wijin.crm.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CustomerDAOJPA implements ICustomerDAO {

    private static CustomerDAOJPA instance;
    private EntityManager em = Persistence.createEntityManagerFactory("crmPersistenceUnit").createEntityManager();

    private CustomerDAOJPA() {
        // Constructeur privé pour le singleton
    }

    public static synchronized CustomerDAOJPA getInstance() {
        if (instance == null) {
            instance = new CustomerDAOJPA();
        }
        return instance;
    }

    @Override
    public Customer createCustomer(Customer customer) {
        
        try {
            em.getTransaction().begin();
            em.persist(customer);
            em.getTransaction().commit();
            return customer;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur création customer", e);
        } finally {
            em.close();
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {

        try {
            return em.find(Customer.class, id);
        } finally {
            em.close();
        }
    }

    @Override
    public List<Customer> getAllCustomers() {

        try {
            return em.createQuery("SELECT c FROM Customer c ORDER BY c.lastname", Customer.class)
                     .getResultList();
        } finally {
            em.close();
        }
    }

    @Override
    public Customer updateCustomer(Customer customer) {

        try {
            em.getTransaction().begin();
            Customer updated = em.merge(customer);
            em.getTransaction().commit();
            return updated;
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur mise à jour customer", e);
        } finally {
            em.close();
        }
    }

    @Override
    public void deleteCustomer(Integer id) {

        try {
            em.getTransaction().begin();
            Customer customer = em.find(Customer.class, id);
            if (customer != null) {
                em.remove(customer);
            }
            em.getTransaction().commit();
        } catch (Exception e) {
            if (em.getTransaction().isActive()) {
                em.getTransaction().rollback();
            }
            throw new RuntimeException("Erreur suppression customer", e);
        } finally {
            em.close();
        }
    }
}