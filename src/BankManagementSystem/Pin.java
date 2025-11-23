package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Pin extends JFrame implements ActionListener {

    String pin;
    JPasswordField pinField1, pinField2;
    JButton change, back;

    Pin(String pin) {
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550, 830, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel l3 = new JLabel(i3);
        l3.setBounds(0, 0, 1550, 830);
        add(l3);

        JLabel label = new JLabel("CHANGE YOUR PIN");
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System", Font.BOLD, 18));
        label.setBounds(450, 180, 400, 30);
        l3.add(label);

        JLabel l1 = new JLabel("New PIN:");
        l1.setForeground(Color.WHITE);
        l1.setBounds(450, 250, 150, 30);
        l3.add(l1);

        pinField1 = new JPasswordField();
        pinField1.setBounds(600, 250, 150, 30);
        pinField1.setBackground(new Color(65, 125, 128));
        pinField1.setForeground(Color.WHITE);
        l3.add(pinField1);

        JLabel l2 = new JLabel("Re-enter New PIN:");
        l2.setForeground(Color.WHITE);
        l2.setBounds(450, 300, 150, 30);
        l3.add(l2);

        pinField2 = new JPasswordField();
        pinField2.setBounds(600, 300, 150, 30);
        pinField2.setBackground(new Color(65, 125, 128));
        pinField2.setForeground(Color.WHITE);
        l3.add(pinField2);

        change = new JButton("Change");
        change.setBounds(700, 362, 150, 35);
        change.setBackground(new Color(65, 125, 128));
        change.setForeground(Color.WHITE);
        change.addActionListener(this);
        l3.add(change);

        back = new JButton("Back");
        back.setBounds(700, 406, 150, 35);
        back.setBackground(new Color(65, 125, 128));
        back.setForeground(Color.WHITE);
        back.addActionListener(this);
        l3.add(back);

        setLayout(null);
        setSize(1550, 1080);
        setLocation(0, 0);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == change) {

            String p1 = new String(pinField1.getPassword());
            String p2 = new String(pinField2.getPassword());

            if (!p1.equals(p2)) {
                JOptionPane.showMessageDialog(null, "PIN does not match");
                return;
            }

            if (p1.equals("")) {
                JOptionPane.showMessageDialog(null, "PIN cannot be empty");
                return;
            }

            try {
                Conn c = new Conn();

                c.s.executeUpdate("UPDATE login SET pin_number='" + p1 + "' WHERE pin_number='" + pin + "'");
                c.s.executeUpdate("UPDATE bank SET pin='" + p1 + "' WHERE pin='" + pin + "'");

                JOptionPane.showMessageDialog(null, "PIN Updated Successfully");

                setVisible(false);
                new main_Class(p1);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == back) {
            setVisible(false);
            new main_Class(pin);
        }
    }

    public static void main(String[] args) {
        new Pin("");
    }
}
