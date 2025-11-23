package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;

public class SignupOne extends JFrame implements ActionListener {

    JTextField nameField, fnameField, dobField, emailField, addressField, cityField, stateField, pinField;
    JRadioButton male, female, married, unmarried;
    JButton next;
    String formno;

    public SignupOne() {

        setLayout(null);

        // Generate Application Form Number
        Random r = new Random();
        formno = "" + Math.abs(r.nextInt() % 10000);

        JLabel title = new JLabel("APPLICATION FORM NO. " + formno);
        title.setFont(new Font("Raleway", Font.BOLD, 28));
        title.setBounds(140, 20, 600, 40);
        add(title);

        JLabel name = new JLabel("Name:");
        name.setBounds(100, 100, 150, 30);
        name.setFont(new Font("Raleway", Font.BOLD, 18));
        add(name);

        nameField = new JTextField();
        nameField.setBounds(300, 100, 300, 30);
        add(nameField);

        JLabel fname = new JLabel("Father's Name:");
        fname.setBounds(100, 140, 150, 30);
        fname.setFont(new Font("Raleway", Font.BOLD, 18));
        add(fname);

        fnameField = new JTextField();
        fnameField.setBounds(300, 140, 300, 30);
        add(fnameField);

        JLabel dob = new JLabel("Date of Birth:");
        dob.setBounds(100, 180, 150, 30);
        dob.setFont(new Font("Raleway", Font.BOLD, 18));
        add(dob);

        dobField = new JTextField();
        dobField.setBounds(300, 180, 300, 30);
        add(dobField);

        JLabel gender = new JLabel("Gender:");
        gender.setBounds(100, 220, 150, 30);
        gender.setFont(new Font("Raleway", Font.BOLD, 18));
        add(gender);

        male = new JRadioButton("Male");
        female = new JRadioButton("Female");
        male.setBounds(300, 220, 100, 30);
        female.setBounds(450, 220, 100, 30);
        male.setBackground(Color.WHITE);
        female.setBackground(Color.WHITE);
        add(male);
        add(female);

        ButtonGroup bg1 = new ButtonGroup();
        bg1.add(male);
        bg1.add(female);

        JLabel email = new JLabel("Email:");
        email.setBounds(100, 260, 150, 30);
        email.setFont(new Font("Raleway", Font.BOLD, 18));
        add(email);

        emailField = new JTextField();
        emailField.setBounds(300, 260, 300, 30);
        add(emailField);

        JLabel marital = new JLabel("Marital Status:");
        marital.setBounds(100, 300, 150, 30);
        marital.setFont(new Font("Raleway", Font.BOLD, 18));
        add(marital);

        married = new JRadioButton("Married");
        unmarried = new JRadioButton("Unmarried");
        married.setBounds(300, 300, 100, 30);
        unmarried.setBounds(450, 300, 100, 30);
        married.setBackground(Color.WHITE);
        unmarried.setBackground(Color.WHITE);
        add(married);
        add(unmarried);

        ButtonGroup bg2 = new ButtonGroup();
        bg2.add(married);
        bg2.add(unmarried);

        JLabel address = new JLabel("Address:");
        address.setBounds(100, 340, 150, 30);
        address.setFont(new Font("Raleway", Font.BOLD, 18));
        add(address);

        addressField = new JTextField();
        addressField.setBounds(300, 340, 300, 30);
        add(addressField);

        JLabel city = new JLabel("City:");
        city.setBounds(100, 380, 150, 30);
        city.setFont(new Font("Raleway", Font.BOLD, 18));
        add(city);

        cityField = new JTextField();
        cityField.setBounds(300, 380, 300, 30);
        add(cityField);

        JLabel state = new JLabel("State:");
        state.setBounds(100, 420, 150, 30);
        state.setFont(new Font("Raleway", Font.BOLD, 18));
        add(state);

        stateField = new JTextField();
        stateField.setBounds(300, 420, 300, 30);
        add(stateField);

        JLabel pin = new JLabel("Pincode:");
        pin.setBounds(100, 460, 150, 30);
        pin.setFont(new Font("Raleway", Font.BOLD, 18));
        add(pin);

        pinField = new JTextField();
        pinField.setBounds(300,460, 300, 30);
        add(pinField);
        next = new JButton("NEXT");
        next.setBounds(520, 500, 120, 40);   // moved UP so it is visible
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        setSize(600, 600);  // increased height so bottom elements never hide

        getContentPane().setBackground(Color.WHITE);

        setSize(800, 750);
        setLocationRelativeTo(null);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {
        try {
            String gender = male.isSelected() ? "Male" : "Female";
            String maritalStatus = married.isSelected() ? "Married" : "Unmarried";

            Conn c = new Conn();

            String query = "INSERT INTO signup VALUES('" + formno + "', '" +
                    nameField.getText() + "', '" + fnameField.getText() + "', '" +
                    dobField.getText() + "', '" + gender + "', '" +
                    emailField.getText() + "', '" + maritalStatus + "', '" +
                    addressField.getText() + "', '" + cityField.getText() + "', '" +
                    pinField.getText() + "', '" + stateField.getText() + "')";

            c.s.executeUpdate(query);

            setVisible(false);
            new SignupTwo(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println("Error: " + e);
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        new SignupOne();
    }
}
