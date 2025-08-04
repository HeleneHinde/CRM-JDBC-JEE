package fr.wijin.crm.dao.jpa;

import java.util.List;

import fr.wijin.crm.dao.ICustomerDAO;
import fr.wijin.crm.dao.database.JPAUtil;
import fr.wijin.crm.model.Customer;
import jakarta.persistence.EntityManager;

public class CustomerDAOJPA implements ICustomerDAO {

    private static CustomerDAOJPA instance;
    private final EntityManager em;
    private boolean shouldCloseEM = true;

    CustomerDAOJPA() {
        em = JPAUtil.getEntityManager();
        shouldCloseEM = true;
    }

    public CustomerDAOJPA(EntityManager em) {
        this.em = em;
        shouldCloseEM = false;
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
            if (shouldCloseEM) {
                em.close();
            }
        }
    }

    @Override
    public Customer getCustomerById(Integer id) {

        try {
            return em.find(Customer.class, id);
        } finally {
            if (shouldCloseEM) {
                em.close();
            }
        }
    }

    @Override
    public List<Customer> getAllCustomers() {

        try {
            return em.createQuery("SELECT c FROM Customer c ORDER BY c.lastname", Customer.class)
                    .getResultList();
        } finally {
            if (shouldCloseEM) {
                em.close();
            }
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
            if (shouldCloseEM) {
                em.close();
            }
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
            if (shouldCloseEM) {
                em.close();
            }
        }
    }
}