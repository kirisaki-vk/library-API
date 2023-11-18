package vk.kirisaki.libraryAPI;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {
        Connection mainConnection;
        String username = System.getenv("PG_USERNAME");
        String password = System.getenv("PG_PASSWORD");
        String databaseUrl = System.getenv("PG_DATABASE_URL");

        try {
            mainConnection = DriverManager.getConnection(
                    String.format("jdbc:postgresql://%s", databaseUrl),
                    username,
                    password
            );

            System.out.println(
                    mainConnection
                            .createStatement()
                            .executeQuery("SELECT * FROM book;")
                            .next()
            );
        } catch (SQLException e) {
            System.out.println(
                    "Sorry, an error occurred during connection\n"
                    + e.getMessage()
            );
        }

    }
}