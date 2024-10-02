import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class DatabaseConnector {

    public static Connection connectToDatabase() {
        try {
            // Load the properties file
            Properties properties = new Properties();
            properties.load(new FileInputStream(new File("database.properties")));

            // Load the PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            // Establish a connection to the database
            Connection connection = DriverManager.getConnection(
                    properties.getProperty("db.url"),
                    properties.getProperty("db.user"),
                    properties.getProperty("db.password")
            );

            return connection;
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC driver not found.");
            return null;
        } catch (IOException e) {
            System.out.println("Error loading properties file: " + e.getMessage());
            return null;
        } catch (SQLException e) {
            System.out.println("Error connecting to database: " + e.getMessage());
            return null;
        }
    }

    public static void main(String[] args) {
        Connection connection = connectToDatabase();

        if (connection != null) {
            System.out.println("Connected to database successfully.");
        } else {
            System.out.println("Failed to connect to database.");
        }
    }
}