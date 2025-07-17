package fr.wijin.crm.dao.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DatabaseConnection {
    
    // Configuration de connexion pour votre conteneur "mabase"
    private static final String URL = "jdbc:postgresql://localhost:5432/mabase";
    private static final String USERNAME = "user";
    private static final String PASSWORD = "poec2025";
    private static final String SCHEMA = "crm_jee";
    
    public static Connection getConnection() throws SQLException {
        try {
            // Chargement du driver PostgreSQL
            Class.forName("org.postgresql.Driver");
            Connection conn = DriverManager.getConnection(URL, USERNAME, PASSWORD);
            
            // Définir le schéma pour cette connexion
            try (Statement stmt = conn.createStatement()) {
                stmt.execute("SET search_path TO " + SCHEMA);
            }
            
            return conn;
            
        } catch (ClassNotFoundException e) {
            throw new SQLException("Driver PostgreSQL non trouvé", e);
        }
    }
    
    // Méthode pour tester la connexion
    public static void testConnection() {
        try (Connection conn = getConnection()) {
            System.out.println("✅ Connexion à PostgreSQL réussie !");
            System.out.println("Base de données : " + conn.getCatalog());
            
            // Vérifier le schéma actuel
            try (Statement stmt = conn.createStatement();
                 var rs = stmt.executeQuery("SELECT current_schema()")) {
                if (rs.next()) {
                    System.out.println("Schéma actuel : " + rs.getString(1));
                }
            }
        } catch (SQLException e) {
            System.err.println("❌ Erreur de connexion : " + e.getMessage());
        }
    }
}