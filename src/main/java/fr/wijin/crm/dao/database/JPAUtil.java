package fr.wijin.crm.dao.database;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class JPAUtil {
    
    private static EntityManagerFactory entityManagerFactory;
    
    static {
        try {
            System.out.println("🚀 Initialisation de JPA...");
            entityManagerFactory = Persistence.createEntityManagerFactory("crmPersistenceUnit");
            System.out.println("✅ EntityManagerFactory créé avec succès !");
            
            // Test de connexion immédiat
            testConnection();
            
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de l'initialisation JPA : " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Impossible d'initialiser JPA", e);
        }
    }
    
    public static EntityManager getEntityManager() {
        return entityManagerFactory.createEntityManager();
    }
    
    private static void testConnection() {
        try (EntityManager em = getEntityManager()) {
            // Force l'initialisation de la connexion et la création des tables
            em.getTransaction().begin();
            em.createNativeQuery("SELECT 1").getSingleResult();
            em.getTransaction().commit();
            System.out.println("✅ Test de connexion JPA réussi !");
        } catch (Exception e) {
            System.err.println("❌ Test de connexion JPA échoué : " + e.getMessage());
            throw e;
        }
    }
    
    public static void closeEntityManagerFactory() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
            System.out.println("EntityManagerFactory fermé");
        }
    }
    
    // Méthode pour forcer l'initialisation
    public static void initialize() {
        System.out.println("JPAUtil initialisé");
    }
}