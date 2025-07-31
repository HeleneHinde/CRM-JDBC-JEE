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
        } catch (Exception e) {
            System.err.println("❌ Erreur lors de l'initialisation JPA : " + e.getMessage());
            e.printStackTrace();
            throw new RuntimeException("Impossible d'initialiser JPA", e);
        }
    }
    
    /**
     * Retourne un nouvel EntityManager
     * N'oubliez pas de le fermer après utilisation !
     */
    public static EntityManager getEntityManager() {
        if (entityManagerFactory == null) {
            throw new RuntimeException("EntityManagerFactory non initialisé");
        }
        return entityManagerFactory.createEntityManager();
    }
    
    /**
     * Ferme l'EntityManagerFactory
     * À appeler lors de l'arrêt de l'application
     */
    public static void close() {
        if (entityManagerFactory != null && entityManagerFactory.isOpen()) {
            entityManagerFactory.close();
            System.out.println("✅ EntityManagerFactory fermé");
        }
    }
    
    /**
     * Vérifie si JPA est correctement initialisé
     */
    public static boolean isInitialized() {
        return entityManagerFactory != null && entityManagerFactory.isOpen();
    }
}