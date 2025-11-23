package bank.management.system;

import java.sql.*;

public class Conn {
    public Connection c;
    public Statement s;

    public Conn() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            c = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/bank_new",
                    "root",
                    "Root@123"
            );
            s = c.createStatement();
        } catch (Exception e) {
            System.out.println("Database Connection Error: " + e);
        }
    }
}
