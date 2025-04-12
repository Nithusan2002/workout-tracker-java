package src;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseConnector {

    private static final String URL =
        "jdbc:sqlserver://nithusan-server.database.windows.net:1433;" +
        "database=workoutdb;" +
        "encrypt=true;" +
        "trustServerCertificate=false;" +
        "hostNameInCertificate=*.database.windows.net;" +
        "loginTimeout=30;";

    private static final String USER = "CloudSA11989c0a@nithusan-server";
    private static final String PASSWORD = "Furuset30122002@"; // <-- Sett inn ditt ekte passord her

    public static Connection connect() {
        try {
            // 🔑 Last inn JDBC-driveren eksplisitt
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");

            return DriverManager.getConnection(URL, USER, PASSWORD);

        } catch (ClassNotFoundException e) {
            System.out.println("❌ JDBC-driveren ble ikke funnet.");
            e.printStackTrace();
            return null;

        } catch (SQLException e) {
            System.out.println("❌ Klarte ikke å koble til Azure SQL Database:");
            e.printStackTrace();
            return null;
        }
    }
}
