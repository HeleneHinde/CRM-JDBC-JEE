package fr.wijin.crm.dao.database;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;

public class DatabaseConnection {

    private static final String URL = "jdbc:postgresql://localhost:5432/mabase";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "poec2025";
    private static final String SCHEMA = "crm_jee";

    private static BasicDataSource dataSource;

    // Initialisation du pool de connexions
    static {
        dataSource = new BasicDataSource();
        dataSource.setUrl(URL);
        dataSource.setUsername(USERNAME);
        dataSource.setPassword(PASSWORD);
        dataSource.setDriverClassName("org.postgresql.Driver");

        // Configuration du pool
        dataSource.setInitialSize(5);
        dataSource.setMaxTotal(20);
        dataSource.setMaxIdle(10);
        dataSource.setMinIdle(2);
        dataSource.setMaxWaitMillis(30000);

        // Validation des connexions
        dataSource.setValidationQuery("SELECT 1");
        dataSource.setTestOnBorrow(true);
        dataSource.setTestWhileIdle(true);

        System.out.println("✅ Pool de connexions initialisé");
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = dataSource.getConnection();

        // Définir le schéma pour cette connexion
        try (Statement stmt = conn.createStatement()) {
            stmt.execute("SET search_path TO " + SCHEMA);
        }

        return conn;
    }

    public static void closeDataSource() throws SQLException {
        if (dataSource != null) {
            dataSource.close();
            System.out.println("Pool de connexions fermé");
        }
    }

    // Statistiques du pool
    public static void printPoolStats() {
        System.out.println("=== Statistiques du pool ===");
        System.out.println("Connexions actives: " + dataSource.getNumActive());
        System.out.println("Connexions inactives: " + dataSource.getNumIdle());
        System.out.println("Maximum autorisé: " + dataSource.getMaxTotal());
    }

    // Méthode pour tester la connexion
    public static void testConnection() {
        Connection conn = null;
        try {
            conn = dataSource.getConnection();

            // Définir le schéma pour cette connexion
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("SET search_path TO " + SCHEMA);

                System.out.println("✅ Connexion à PostgreSQL réussie !");
                System.out.println("Base de données : " + conn.getCatalog());

                var rs = stmt.executeQuery("SELECT current_schema()");
                if (rs.next()) {
                    System.out.println("Schéma actuel : " + rs.getString(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur de connexion : " + e.getMessage());
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    System.err.println("Erreur lors de la fermeture de la connexion : " + e.getMessage());
                }
            }
        }
    }
}