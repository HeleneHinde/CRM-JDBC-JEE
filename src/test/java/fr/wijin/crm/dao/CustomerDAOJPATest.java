package fr.wijin.crm.dao;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.fail;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import fr.wijin.crm.dao.jpa.CustomerDAOJPA;
import fr.wijin.crm.model.Customer;
import jakarta.persistence.EntityManager;
import jakarta.persistence.Persistence;

public class CustomerDAOJPATest {

    private CustomerDAOJPA customerDAO;
    private EntityManager em;

    @BeforeEach
    public void setUp() {

        em = Persistence.createEntityManagerFactory("crmTestPersistenceUnit").createEntityManager();
        customerDAO = new CustomerDAOJPA(em);
    }

    @Test
    public void testCreateCustomer() {
        // Given
        Customer customer = new Customer();
        customer.setLastname("Doe");
        customer.setFirstname("John");
        customer.setMail("john.doe@test.com");
        customer.setPhone("0123456789");
        customer.setActive(true);

        // When
        Customer created = customerDAO.createCustomer(customer);

        // Then
        assertNotNull(created, "Customer créé ne doit pas être null");
        assertNotNull(created.getId(), "ID doit être généré");
        assertEquals("Doe", created.getLastname(), "Nom doit être identique");
        assertEquals("John", created.getFirstname(), "Prénom doit être identique");
    }

    @Test
    public void testGetAllCustomers() {
        // Given - Créer quelques customers
        Customer customer1 = new Customer();
        customer1.setLastname("Doe");
        customer1.setFirstname("John");
        customer1.setMail("john@test.com");
        customer1.setPhone("0123456789");
        customer1.setActive(true);
        customerDAO.createCustomer(customer1);

        Customer customer2 = new Customer();
        customer2.setLastname("Smith");
        customer2.setFirstname("Jane");
        customer2.setMail("jane@test.com");
        customer2.setPhone("0987654321");
        customer2.setActive(true);
        customerDAO.createCustomer(customer2);

        // When
        List<Customer> customers = customerDAO.getAllCustomers();

        // Then
        assertNotNull(customers, "Liste ne doit pas être null");
        assertEquals(2, customers.size(), "Doit avoir 2 customers");
    }

    @Test
    public void testGetCustomerById() {
        // Given
        Customer customer = new Customer();
        customer.setLastname("Test");
        customer.setFirstname("User");
        customer.setMail("test@test.com");
        customer.setPhone("0123456789");
        customer.setActive(true);
        Customer created = customerDAO.createCustomer(customer);

        // When
        try {
            em.getTransaction().begin();
            Customer found = customerDAO.getCustomerById(created.getId());

            // Then
            assertNotNull(found, "Customer trouvé ne doit pas être null");
            assertEquals(created.getId(), found.getId(), "ID doit être identique");
            assertEquals("Test", found.getLastname(), "Nom doit être identique");
        } catch (Exception e) {
            em.getTransaction().rollback();
            fail();
        } finally {
            em.getTransaction().commit();
        }

    }
}