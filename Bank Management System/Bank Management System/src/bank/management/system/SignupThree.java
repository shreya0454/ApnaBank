package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

public class SignupThree extends JFrame implements ActionListener {

    JRadioButton savingAcc, fixedDep, currentAcc, recurringDep;
    JCheckBox atm, internet, mobile, email, cheque, statement;
    JButton submit, cancel;
    String formno;

    public SignupThree(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 3");

        JLabel details = new JLabel("Page 3: Account Details");
        details.setFont(new Font("Raleway", Font.BOLD, 26));
        details.setBounds(250, 80, 400, 40);
        add(details);

        savingAcc = new JRadioButton("Saving Account");
        fixedDep = new JRadioButton("Fixed Deposit Account");
        currentAcc = new JRadioButton("Current Account");
        recurringDep = new JRadioButton("Recurring Deposit Account");

        savingAcc.setBounds(100, 160, 250, 30);
        fixedDep.setBounds(100, 200, 250, 30);
        currentAcc.setBounds(100, 240, 250, 30);
        recurringDep.setBounds(100, 280, 300, 30);

        ButtonGroup accGroup = new ButtonGroup();
        accGroup.add(savingAcc);
        accGroup.add(fixedDep);
        accGroup.add(currentAcc);
        accGroup.add(recurringDep);

        add(savingAcc);
        add(fixedDep);
        add(currentAcc);
        add(recurringDep);

        atm = new JCheckBox("ATM Card");
        internet = new JCheckBox("Internet Banking");
        mobile = new JCheckBox("Mobile Banking");
        email = new JCheckBox("Email Alerts");
        cheque = new JCheckBox("Cheque Book");
        statement = new JCheckBox("E-Statement");

        atm.setBounds(100, 340, 200, 30);
        internet.setBounds(100, 380, 200, 30);
        mobile.setBounds(100, 420, 200, 30);
        email.setBounds(400, 340, 200, 30);
        cheque.setBounds(400, 380, 200, 30);
        statement.setBounds(400, 420, 200, 30);

        add(atm);
        add(internet);
        add(mobile);
        add(email);
        add(cheque);
        add(statement);

        submit = new JButton("Submit");
        submit.setBounds(250, 550, 100, 40);
        submit.addActionListener(this);
        add(submit);

        cancel = new JButton("Cancel");
        cancel.setBounds(450, 550, 100, 40);
        cancel.addActionListener(this);
        add(cancel);

        setSize(800, 800);
        setLocation(350, 10);
        setVisible(true);
    }

    String generateCardNumber(String prefix) {

        Random rand = new Random();
        StringBuilder sb = new StringBuilder(prefix);

        while (sb.length() < 16) {
            sb.append(rand.nextInt(10));
        }

        // Format XXXX XXXX XXXX XXXX
        return sb.toString().replaceAll("(.{4})", "$1 ").trim();
    }

    String generatePin() {
        Random rand = new Random();
        return "" + (rand.nextInt(9000) + 1000);
    }

    public void actionPerformed(ActionEvent ae) {
        if (ae.getSource() == submit) {

            try {

                String accountType = "";
                String prefix = "";

                // Correct prefixes as you requested
                if (savingAcc.isSelected()) { accountType = "Saving Account"; prefix = "4321"; }
                else if (fixedDep.isSelected()) { accountType = "Fixed Deposit"; prefix = "9876"; }
                else if (currentAcc.isSelected()) { accountType = "Current Account"; prefix = "1234"; }
                else if (recurringDep.isSelected()) { accountType = "Recurring Deposit"; prefix = "6789"; }

                String cardno = generateCardNumber(prefix);
                String pin = generatePin();

                String facility = "";
                if (atm.isSelected()) facility += "ATM, ";
                if (internet.isSelected()) facility += "Internet Banking, ";
                if (mobile.isSelected()) facility += "Mobile Banking, ";
                if (email.isSelected()) facility += "Email Alerts, ";
                if (cheque.isSelected()) facility += "Cheque Book, ";
                if (statement.isSelected()) facility += "E-Statement";

                Conn c = new Conn();

                String q1 = "INSERT INTO signup3 VALUES ('" + formno + "','" + accountType + "','" + cardno + "','" + pin + "','" + facility + "')";
                
                // Correct query for login table (2 columns only)
                String q2 = "INSERT INTO login VALUES ('" + cardno + "','" + pin + "')";

                c.s.executeUpdate(q1);
                c.s.executeUpdate(q2);

                JOptionPane.showMessageDialog(null, 
                    "Account Created Successfully!\nYour Card Number: " + cardno + "\nYour PIN: " + pin);

                setVisible(false);
                new Login();

            } catch (Exception e) {
                System.out.println("Error: " + e);
            }

        } else if (ae.getSource() == cancel) {
            System.exit(0);
        }
    }
}
