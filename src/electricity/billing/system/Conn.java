package electricity.billing.system;

import java.sql.*;

public class Conn {

    Connection c;
    Statement s;

    Conn() {
        try {
            // Load the MySQL JDBC Driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Establish the connection
            c = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/ebs",
                "root",
                "pramod2805"
            );

            // Create statement
            s = c.createStatement();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
