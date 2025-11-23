package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class PIN_change extends JFrame implements ActionListener {

    JButton change, back;
    JPasswordField txtcon, txtpin;
    String pin_no;

    PIN_change(String pin) {
        pin_no = pin;

        setTitle("Change PIN");
        setSize(900, 900);
        setLayout(null);
        setLocationRelativeTo(null);
        setUndecorated(true);

        // Background Image
        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
        Image i2 = i1.getImage().getScaledInstance(900, 900, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(0, 0, 900, 900);
        add(image);

        // Title Label
        JLabel txt = new JLabel("Change your PIN");
        txt.setForeground(Color.white);
        txt.setFont(new Font("System", Font.BOLD, 16));
        txt.setBounds(270, 290, 500, 35);
        image.add(txt);

        // New PIN Label & Field
        JLabel lblpin = new JLabel("Enter New PIN:");
        lblpin.setForeground(Color.white);
        lblpin.setFont(new Font("System", Font.BOLD, 14));
        lblpin.setBounds(170, 340, 200, 35);
        image.add(lblpin);

        txtpin = new JPasswordField();
        txtpin.setFont(new Font("System", Font.BOLD, 14));
        txtpin.setBounds(340, 348, 150, 22);
        image.add(txtpin);

        // Confirm PIN Label & Field
        JLabel lblcon = new JLabel("Re-Enter New PIN:");
        lblcon.setForeground(Color.white);
        lblcon.setFont(new Font("System", Font.BOLD, 14));
        lblcon.setBounds(170, 390, 500, 35);
        image.add(lblcon);

        txtcon = new JPasswordField();
        txtcon.setFont(new Font("System", Font.BOLD, 14));
        txtcon.setBounds(340, 390, 150, 22);
        image.add(txtcon);

        // Buttons
        change = new JButton("Change");
        change.setBounds(355, 485, 150, 27);
        change.addActionListener(this);
        image.add(change);

        back = new JButton("Back");
        back.setBounds(355, 520, 150, 27);
        back.addActionListener(this);
        image.add(back);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == change) {
            try {
                String pin = new String(txtpin.getPassword());
                String repin = new String(txtcon.getPassword());

                if (pin.equals("")) {
                    JOptionPane.showMessageDialog(null, "Enter PIN");
                    return;
                }

                if (!pin.equals(repin)) {
                    JOptionPane.showMessageDialog(null, "Entered PIN does not match");
                    return;
                }

                Conn cnc = new Conn();

                // Update queries - make sure your tables have column 'PIN'
                String query1 = "UPDATE bank SET PIN = '" + pin + "' WHERE PIN = '" + pin_no + "'";
                String query2 = "UPDATE login SET PIN = '" + pin + "' WHERE PIN = '" + pin_no + "'";
                String query3 = "UPDATE signup3 SET PIN = '" + pin + "' WHERE PIN = '" + pin_no + "'";

                cnc.s.executeUpdate(query1);
                cnc.s.executeUpdate(query2);
                cnc.s.executeUpdate(query3);

                JOptionPane.showMessageDialog(null, "PIN Changed Successfully");

                setVisible(false);
                new Transactions(pin).setVisible(true);

            } catch (Exception e) {
                e.printStackTrace();
            }

        } else if (ae.getSource() == back) {
            setVisible(false);
            new Transactions(pin_no).setVisible(true);
        }
    }

    public static void main(String[] args) {
        new PIN_change("");
    }
}
