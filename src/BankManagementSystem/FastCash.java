package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.ResultSet;
import java.util.Date;

public class FastCash extends JFrame implements ActionListener {

    JButton b1,b2,b3,b4,b5,b6,b7;
    String pin;

    public FastCash(String pin){
        this.pin = pin;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/atm2.png"));
        Image i2 = i1.getImage().getScaledInstance(1550,830,Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel bg = new JLabel(i3);
        bg.setBounds(0,0,1550,830);
        add(bg);

        JLabel label = new JLabel("SELECT WITHDRAWAL AMOUNT");
        label.setBounds(445,180,700,35);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("System",Font.BOLD,23));
        bg.add(label);

        b1 = new JButton("Rs. 100");
        b2 = new JButton("Rs. 500");
        b3 = new JButton("Rs. 1000");
        b4 = new JButton("Rs. 2000");
        b5 = new JButton("Rs. 5000");
        b6 = new JButton("Rs. 10000");
        b7 = new JButton("BACK");

        JButton[] buttons = {b1,b2,b3,b4,b5,b6,b7};
        int[][] pos = {
                {410,274},{700,274},
                {410,318},{700,318},
                {410,362},{700,362},
                {700,406}
        };

        for(int i=0;i<buttons.length;i++){
            buttons[i].setBounds(pos[i][0], pos[i][1], 150, 35);
            buttons[i].setForeground(Color.WHITE);
            buttons[i].setBackground(new Color(65,125,128));
            buttons[i].addActionListener(this);
            bg.add(buttons[i]);
        }

        setLayout(null);
        setSize(1550,1080);
        setLocation(0,0);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == b7) {
            setVisible(false);
            new main_Class(pin);
            return;
        }

        String amount = ((JButton)e.getSource()).getText().substring(4);
        Conn c = new Conn();
        Date date = new Date();

        try {
            ResultSet rs = c.s.executeQuery("SELECT * FROM bank WHERE pin = '" + pin + "'");
            int balance = 0;

            while (rs.next()) {
                if (rs.getString("type").equals("Deposit")) {
                    balance += Integer.parseInt(rs.getString("amount"));
                } else {
                    balance -= Integer.parseInt(rs.getString("amount"));
                }
            }

            if (balance < Integer.parseInt(amount)) {
                JOptionPane.showMessageDialog(null, "Insufficient Balance");
                return;
            }

            c.s.executeUpdate("INSERT INTO bank VALUES ('" + pin + "','" + date + "', 'Withdraw', '" + amount + "')");
            JOptionPane.showMessageDialog(null, "Rs. " + amount + " Debited Successfully");

            setVisible(false);
            new main_Class(pin);

        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new FastCash("");
    }
}
