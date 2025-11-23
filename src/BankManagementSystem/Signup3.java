package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup3 extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, r4;
    JCheckBox c1, c2, c3, c4, c5, c6, c7;
    JButton Submit, Cancel;
    String formno;

    Signup3(String formno) {

        this.formno = formno;

        ImageIcon i1 = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image i2 = i1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon i3 = new ImageIcon(i2);
        JLabel image = new JLabel(i3);
        image.setBounds(150, 5, 100, 100);
        add(image);

        JLabel l1 = new JLabel("Page 3:");
        l1.setFont(new Font("Raleway", Font.BOLD, 22));
        l1.setBounds(280, 40, 400, 40);
        add(l1);

        JLabel l2 = new JLabel("Account Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        l2.setBounds(280, 70, 400, 40);
        add(l2);

        JLabel l3 = new JLabel("Account Type:");
        l3.setFont(new Font("Raleway", Font.BOLD, 18));
        l3.setBounds(100, 140, 200, 30);
        add(l3);

        r1 = new JRadioButton("Saving Account");
        r1.setFont(new Font("Raleway", Font.BOLD, 16));
        r1.setBackground(new Color(215, 252, 252));
        r1.setBounds(100, 180, 150, 30);
        add(r1);

        r2 = new JRadioButton("Fixed Deposit Account");
        r2.setFont(new Font("Raleway", Font.BOLD, 16));
        r2.setBackground(new Color(215, 252, 252));
        r2.setBounds(350, 180, 250, 30);
        add(r2);

        r3 = new JRadioButton("Current Account");
        r3.setFont(new Font("Raleway", Font.BOLD, 16));
        r3.setBackground(new Color(215, 252, 252));
        r3.setBounds(100, 220, 250, 30);
        add(r3);

        r4 = new JRadioButton("Recurring Deposit Account");
        r4.setFont(new Font("Raleway", Font.BOLD, 16));
        r4.setBackground(new Color(215, 252, 252));
        r4.setBounds(350, 220, 250, 30);
        add(r4);

        ButtonGroup buttonGroup = new ButtonGroup();
        buttonGroup.add(r1); buttonGroup.add(r2);
        buttonGroup.add(r3); buttonGroup.add(r4);

        JLabel l4 = new JLabel("Card Number:");
        l4.setFont(new Font("Raleway", Font.BOLD, 18));
        l4.setBounds(100, 300, 200, 30);
        add(l4);

        JLabel l5 = new JLabel("(Your 16-digit Card Number)");
        l5.setFont(new Font("Raleway", Font.BOLD, 12));
        l5.setBounds(100, 330, 200, 20);
        add(l5);

        JLabel l6 = new JLabel("XXXX-XXXX-XXXX-5952");
        l6.setFont(new Font("Raleway", Font.BOLD, 18));
        l6.setBounds(330, 300, 250, 30);
        add(l6);

        JLabel l7 = new JLabel("(It would appear on ATM card/Cheque Book and Statements)");
        l7.setFont(new Font("Raleway", Font.BOLD, 12));
        l7.setBounds(330, 330, 500, 20);
        add(l7);

        JLabel l8 = new JLabel("PIN:");
        l8.setFont(new Font("Raleway", Font.BOLD, 18));
        l8.setBounds(100, 370, 200, 30);
        add(l8);

        JLabel l9 = new JLabel("****");
        l9.setFont(new Font("Raleway", Font.BOLD, 18));
        l9.setBounds(330, 370, 200, 30);
        add(l9);

        JLabel l10 = new JLabel("(4-digit Password)");
        l10.setFont(new Font("Raleway", Font.BOLD, 12));
        l10.setBounds(100, 400, 200, 20);
        add(l10);

        JLabel l11 = new JLabel("Services Required:");
        l11.setFont(new Font("Raleway", Font.BOLD, 18));
        l11.setBounds(100, 450, 200, 30);
        add(l11);

        c1 = new JCheckBox("ATM CARD");
        c2 = new JCheckBox("Internet Banking");
        c3 = new JCheckBox("Mobile Banking");
        c4 = new JCheckBox("EMAIL Alerts");
        c5 = new JCheckBox("Cheque Book");
        c6 = new JCheckBox("E-Statement");

        JCheckBox[] all = {c1, c2, c3, c4, c5, c6};

        int y = 500;
        for (int i = 0; i < all.length; i++) {
            all[i].setFont(new Font("Raleway", Font.BOLD, 16));
            all[i].setBackground(new Color(215, 252, 252));
            all[i].setBounds((i % 2 == 0) ? 100 : 350, y, 200, 30);
            add(all[i]);
            if (i % 2 == 1) y += 50;
        }

        c7 = new JCheckBox("I hereby declare that the above entered details are correct.");
        c7.setFont(new Font("Raleway", Font.BOLD, 12));
        c7.setBackground(new Color(215, 252, 252));
        c7.setBounds(100, 680, 600, 20);
        add(c7);

        JLabel l12 = new JLabel("Form No : ");
        l12.setFont(new Font("Raleway", Font.BOLD, 14));
        l12.setBounds(700, 10, 100, 30);
        add(l12);

        JLabel l13 = new JLabel(formno);
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        l13.setBounds(760, 10, 60, 30);
        add(l13);

        Submit = new JButton("Submit");
        Submit.setFont(new Font("Raleway", Font.BOLD, 14));
        Submit.setBackground(Color.BLACK);
        Submit.setForeground(Color.WHITE);
        Submit.setBounds(250, 720, 100, 30);
        Submit.addActionListener(this);
        add(Submit);

        Cancel = new JButton("Cancel");
        Cancel.setFont(new Font("Raleway", Font.BOLD, 14));
        Cancel.setBackground(Color.BLACK);
        Cancel.setForeground(Color.WHITE);
        Cancel.setBounds(420, 720, 100, 30);
        Cancel.addActionListener(this);
        add(Cancel);

        getContentPane().setBackground(new Color(215, 252, 252));
        setSize(850, 800);
        setLayout(null);
        setLocation(400, 20);
        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Submit) {

            // ACCOUNT TYPE
            String atype = null;
            if (r1.isSelected()) atype = "Saving Account";
            else if (r2.isSelected()) atype = "Fixed Deposit Account";
            else if (r3.isSelected()) atype = "Current Account";
            else if (r4.isSelected()) atype = "Recurring Deposit Account";

            // VALIDATION
            if (atype == null) {
                JOptionPane.showMessageDialog(null, "Please select an account type");
                return;
            }

            if (!c7.isSelected()) {
                JOptionPane.showMessageDialog(null, "Please accept the declaration");
                return;
            }

            // CARD + PIN GENERATION
            Random ran = new Random();
            String cardno = "" + Math.abs((ran.nextLong() % 90000000L) + 2510074000000000L);
            String pin = "" + Math.abs((ran.nextLong() % 9000L) + 1000L);

            // SERVICES - MULTIPLE CHECKBOX SUPPORT
            StringBuilder fac = new StringBuilder();
            if (c1.isSelected()) fac.append("ATM CARD, ");
            if (c2.isSelected()) fac.append("Internet Banking, ");
            if (c3.isSelected()) fac.append("Mobile Banking, ");
            if (c4.isSelected()) fac.append("EMAIL Alerts, ");
            if (c5.isSelected()) fac.append("Cheque Book, ");
            if (c6.isSelected()) fac.append("E-Statement");

            try {
                Conn c1 = new Conn();

                String q1 = "INSERT INTO signup3 VALUES('" + formno + "', '" + atype + "', '" + cardno + "', '" + pin + "', '" + fac + "')";
                String q2 = "INSERT INTO login VALUES('" + cardno + "', '" + pin + "')";

                c1.s.executeUpdate(q1);
                c1.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, "Card Number: " + cardno + "\nPIN: " + pin);

                setVisible(false);
                new Deposit(pin);

            } catch (Exception ex) {
                ex.printStackTrace();
            }

        } else if (e.getSource() == Cancel) {
            System.exit(0);
        }
    }

    public static void main(String[] args) {
        new Signup3("");
    }
}
