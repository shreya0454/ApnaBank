package BankManagementSystem;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Signup extends JFrame implements ActionListener {

    JRadioButton r1, r2, r3, m1, m2, m3;
    JButton Next;
    JTextField textName1, textFName, textAddress, textDOB, textEmail, textPinCode, textCity, textStates;
    Random ran = new Random();
    long first4 = (ran.nextLong() % 9000L) + 1000L;
    String first = " " + Math.abs(first4);

    Signup() {
        super("APPLICATION FORM");

        ImageIcon bank = new ImageIcon(ClassLoader.getSystemResource("icon/bank.png"));
        Image bank1 = bank.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon bank2 = new ImageIcon(bank1);
        JLabel image = new JLabel(bank2);
        image.setBounds(25, 10, 100, 100);
        add(image);

        JLabel label1 = new JLabel("APPLICATION FORM NO. " + first);
        label1.setBounds(160, 20, 600, 40);
        label1.setFont(new Font("Raleway", Font.BOLD, 40));
        add(label1);

        JLabel label2 = new JLabel("Page 1");
        label2.setFont(new Font("Time new Roman", Font.BOLD, 30));
        label2.setBounds(330, 70, 600, 35);
        add(label2);

        JLabel label3 = new JLabel("Personal Details");
        label3.setFont(new Font("Time new Roman", Font.BOLD, 22));
        label3.setBounds(290, 110, 600, 30);
        add(label3);

        // Name
        JLabel labelName = new JLabel("Full Name:");
        labelName.setFont(new Font("Courier", Font.BOLD, 30));
        labelName.setBounds(100, 190, 180, 25);
        add(labelName);

        textName1 = new JTextField();
        textName1.setFont(new Font("Raleway", Font.BOLD, 14));
        textName1.setBounds(350, 195, 400, 25);
        add(textName1);

        // Father Name
        JLabel labelName1 = new JLabel("Father's Name:");
        labelName1.setFont(new Font("Raleway", Font.BOLD, 30));
        labelName1.setBounds(100, 240, 400, 25);
        add(labelName1);

        textFName = new JTextField();
        textFName.setFont(new Font("Raleway", Font.BOLD, 14));
        textFName.setBounds(350, 240, 400, 25);
        add(textFName);

        // Date Of Birth
        JLabel DOB = new JLabel("Date of Birth:");
        DOB.setFont(new Font("Raleway", Font.BOLD, 30));
        DOB.setBounds(100, 290, 200, 25);
        add(DOB);

        textDOB = new JTextField();
        textDOB.setFont(new Font("Raleway:", Font.BOLD, 14));
        textDOB.setBounds(350, 290, 400, 25);
        add(textDOB);

        // Gender
        JLabel labelG = new JLabel("Gender:");
        labelG.setFont(new Font("Raleway", Font.BOLD, 30));
        labelG.setBounds(100, 335, 200, 25);
        add(labelG);

        r1 = new JRadioButton("Male");
        r1.setFont(new Font("Raleway", Font.BOLD, 14));
        r1.setBackground(new Color(222, 255, 228));
        r1.setBounds(350, 335, 70, 25);
        add(r1);

        r2 = new JRadioButton("Female");
        r2.setFont(new Font("Raleway", Font.BOLD, 14));
        r2.setBackground(new Color(222, 255, 228));
        r2.setBounds(430, 335, 90, 25);
        add(r2);

        r3 = new JRadioButton("Not Prefer");
        r3.setFont(new Font("Raleway", Font.BOLD, 14));
        r3.setBackground(new Color(222, 255, 228));
        r3.setBounds(530, 335, 100, 25);
        add(r3);

        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(r1);
        genderGroup.add(r2);
        genderGroup.add(r3);

        // Email
        JLabel labelEmail = new JLabel("Email Address:");
        labelEmail.setFont(new Font("Raleway", Font.BOLD, 30));
        labelEmail.setBounds(100, 380, 250, 25);
        add(labelEmail);

        textEmail = new JTextField();
        textEmail.setFont(new Font("Raleway", Font.BOLD, 14));
        textEmail.setBounds(350, 380, 400, 25);
        add(textEmail);

        // Married Status
        JLabel labeMS = new JLabel("Married Status:");
        labeMS.setFont(new Font("Raleway", Font.BOLD, 30));
        labeMS.setBounds(100, 435, 250, 25);
        add(labeMS);

        m1 = new JRadioButton("Married");
        m1.setFont(new Font("Raleway", Font.BOLD, 14));
        m1.setBackground(new Color(222, 255, 228));
        m1.setBounds(350, 435, 80, 25);
        add(m1);

        m2 = new JRadioButton("Not Married");
        m2.setFont(new Font("Raleway", Font.BOLD, 14));
        m2.setBackground(new Color(222, 255, 228));
        m2.setBounds(430, 435, 120, 25);
        add(m2);

        m3 = new JRadioButton("Divorce");
        m3.setFont(new Font("Raleway", Font.BOLD, 14));
        m3.setBackground(new Color(222, 255, 228));
        m3.setBounds(550, 435, 100, 25);
        add(m3);

        ButtonGroup msGroup = new ButtonGroup();
        msGroup.add(m1);
        msGroup.add(m2);
        msGroup.add(m3);

        // Address
        JLabel labeAdd = new JLabel("Address:");
        labeAdd.setFont(new Font("Raleway", Font.BOLD, 30));
        labeAdd.setBounds(100, 480, 250, 25);
        add(labeAdd);

        textAddress = new JTextField();
        textAddress.setFont(new Font("Raleway", Font.BOLD, 14));
        textAddress.setBounds(350, 480, 400, 25);
        add(textAddress);

        // City
        JLabel labelCity = new JLabel("City:");
        labelCity.setFont(new Font("Raleway", Font.BOLD, 30));
        labelCity.setBounds(100, 520, 250, 25);
        add(labelCity);

        textCity = new JTextField();
        textCity.setFont(new Font("Raleway", Font.BOLD, 14));
        textCity.setBounds(350, 520, 400, 25);
        add(textCity);

        // Pin Code
        JLabel labePinCode = new JLabel("Pin Code:");
        labePinCode.setFont(new Font("Raleway", Font.BOLD, 30));
        labePinCode.setBounds(100, 570, 250, 25);
        add(labePinCode);

        textPinCode = new JTextField();
        textPinCode.setFont(new Font("Raleway", Font.BOLD, 14));
        textPinCode.setBounds(350, 570, 400, 25);
        add(textPinCode);

        // State
        JLabel labelStates = new JLabel("State:");
        labelStates.setFont(new Font("Raleway", Font.BOLD, 30));
        labelStates.setBounds(100, 620, 250, 25);
        add(labelStates);

        textStates = new JTextField();
        textStates.setFont(new Font("Raleway", Font.BOLD, 14));
        textStates.setBounds(350, 620, 400, 25);
        add(textStates);

        // Next Button
        Next = new JButton("Next");
        Next.setFont(new Font("Raleway", Font.BOLD, 14));
        Next.setBackground(Color.BLACK);
        Next.setForeground(Color.WHITE);
        Next.setBounds(620, 710, 80, 30);
        Next.addActionListener(this);
        add(Next);

        // Frame Settings
        getContentPane().setBackground(new Color(222, 255, 228));
        setLayout(null);
        setSize(850, 800);
        setLocation(360, 40);
        setVisible(true);
    }

    public static void main(String[] args) {
        new Signup();
    }

    // ACTION LISTENER
    @Override
    public void actionPerformed(ActionEvent e) {

        String formno = first;
        String name = textName1.getText();
        String fname = textFName.getText();
        String DOB = textDOB.getText();
        String gender = r1.isSelected() ? "Male" :
                        r2.isSelected() ? "Female" : "Not Prefer";

        String Email = textEmail.getText();
        String Married = m1.isSelected() ? "Married" :
                         m2.isSelected() ? "Not Married" : "Divorce";

        String Address = textAddress.getText();
        String City = textCity.getText();
        String PinCode = textPinCode.getText();
        String States = textStates.getText();

        try {
            if (name.equals("")) {
                JOptionPane.showMessageDialog(null, "Fill all the fields");
            } else {

                Conn con1 = new Conn(); // UPDATED HERE
                String q = "INSERT INTO signup VALUES('" + formno + "','" + name + "','" + fname + "','" + DOB + "','" + gender + "','" + Email + "','" + Married + "','" + Address + "','" + City + "','" + PinCode + "','" + States + "')";

                con1.s.executeUpdate(q);

                new Signup2(formno);
                setVisible(false);
            }

        } catch (Exception E) {
            System.out.println(E);
        }
    }
}
