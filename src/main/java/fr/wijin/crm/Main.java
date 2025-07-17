package fr.wijin.crm;

import fr.wijin.crm.dao.database.DatabaseConnection;

public class Main {
    public static void main(String[] args) {
        DatabaseConnection.testConnection();
    }
}
