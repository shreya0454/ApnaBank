package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.sql.*;

public class mini extends JFrame {

    mini(String pin) {

        setTitle("Mini Statement");

        setLayout(null);

        JLabel label = new JLabel("Mini Statement");
        label.setFont(new Font("System", Font.BOLD, 18));
        label.setBounds(150, 20, 200, 30);
        add(label);

        JTextArea textArea = new JTextArea();
        textArea.setEditable(false);
        textArea.setBounds(20, 70, 350, 300);
        add(textArea);

        try {
            Conn c = new Conn();
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin='" + pin + "' ORDER BY date DESC LIMIT 10");

            StringBuilder sb = new StringBuilder();

            while (rs.next()) {
                sb.append(rs.getString("date"))
                        .append("    ")
                        .append(rs.getString("type"))
                        .append("    ")
                        .append("Rs. ")
                        .append(rs.getString("amount"))
                        .append("\n");
            }

            textArea.setText(sb.toString());

        } catch (Exception e) {
            e.printStackTrace();
        }

        setSize(400, 450);
        setLocation(500, 200);
        setVisible(true);
    }

    public static void main(String[] args) {
        new mini("");
    }
}
