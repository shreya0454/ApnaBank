package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class SignupTwo extends JFrame implements ActionListener {

    JTextField panTF, aadharTF;
    JComboBox religionCB, categoryCB, incomeCB, educationCB, occupationCB;
    JRadioButton seniorYes, seniorNo, existingYes, existingNo;
    JButton next;
    String formno;

    public SignupTwo(String formno) {

        this.formno = formno;

        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM - PAGE 2");

        JLabel additionalDetails = new JLabel("Page 2: Additional Details");
        additionalDetails.setFont(new Font("Raleway", Font.BOLD, 26));
        additionalDetails.setBounds(230, 60, 400, 40);
        add(additionalDetails);

        JLabel fno = new JLabel("Form No: " + formno);
        fno.setFont(new Font("Raleway", Font.BOLD, 18));
        fno.setBounds(600, 20, 200, 30);
        add(fno);

        JLabel religion = new JLabel("Religion:");
        religion.setBounds(100, 120, 200, 30);
        religion.setFont(new Font("Raleway", Font.BOLD, 20));
        add(religion);

        String valReligion[] = {"Hindu", "Muslim", "Sikh", "Christian", "Other"};
        religionCB = new JComboBox(valReligion);
        religionCB.setBounds(300, 120, 300, 30);
        add(religionCB);

        JLabel category = new JLabel("Category:");
        category.setBounds(100, 160, 200, 30);
        category.setFont(new Font("Raleway", Font.BOLD, 20));
        add(category);

        String valCategory[] = {"General", "OBC", "SC", "ST", "Other"};
        categoryCB = new JComboBox(valCategory);
        categoryCB.setBounds(300, 160, 300, 30);
        add(categoryCB);

        JLabel income = new JLabel("Income:");
        income.setBounds(100, 220, 200, 30);
        income.setFont(new Font("Raleway", Font.BOLD, 20));
        add(income);

        String valIncome[] = {"<1,50,000", "<2,50,000", "<5,00,000", "Upto 10,00,000", "Above 10,00,000"};
        incomeCB = new JComboBox(valIncome);
        incomeCB.setBounds(300, 220, 300, 30);
        add(incomeCB);

        JLabel education = new JLabel("Education:");
        education.setBounds(100, 280, 200, 30);
        education.setFont(new Font("Raleway", Font.BOLD, 20));
        add(education);

        String educationValues[] = {"Non-Graduate", "Graduate", "Post Graduate", "Doctorate", "Other"};
        educationCB = new JComboBox(educationValues);
        educationCB.setBounds(300, 280, 300, 30);
        add(educationCB);

        JLabel occupation = new JLabel("Occupation:");
        occupation.setBounds(100, 320, 200, 30);
        occupation.setFont(new Font("Raleway", Font.BOLD, 20));
        add(occupation);

        String occupationValues[] = {"Salaried", "Self-Employed", "Business", "Student", "Retired", "Other"};
        occupationCB = new JComboBox(occupationValues);
        occupationCB.setBounds(300, 320, 300, 30);
        add(occupationCB);

        JLabel pan = new JLabel("PAN Number:");
        pan.setBounds(100, 360, 200, 30);
        pan.setFont(new Font("Raleway", Font.BOLD, 20));
        add(pan);

        panTF = new JTextField();
        panTF.setBounds(300, 360, 300, 30);
        add(panTF);

        JLabel aadhar = new JLabel("Aadhar Number:");
        aadhar.setBounds(100, 400, 200, 30);
        aadhar.setFont(new Font("Raleway", Font.BOLD, 20));
        add(aadhar);

        aadharTF = new JTextField();
        aadharTF.setBounds(300, 400, 300, 30);
        add(aadharTF);

        JLabel senior = new JLabel("Senior Citizen:");
        senior.setBounds(100, 430, 200, 30);
        senior.setFont(new Font("Raleway", Font.BOLD, 20));
        add(senior);

        seniorYes = new JRadioButton("Yes");
        seniorNo = new JRadioButton("No");

        ButtonGroup sg = new ButtonGroup();
        sg.add(seniorYes);
        sg.add(seniorNo);

        seniorYes.setBounds(300,430, 80, 30);
        seniorNo.setBounds(450, 430, 80, 30);

        seniorYes.setBackground(Color.WHITE);
        seniorNo.setBackground(Color.WHITE);

        add(seniorYes);
        add(seniorNo);

        JLabel existing = new JLabel("Existing Account:");
        existing.setBounds(100, 480, 200, 30);
        existing.setFont(new Font("Raleway", Font.BOLD, 20));
        add(existing);

        existingYes = new JRadioButton("Yes");
        existingNo = new JRadioButton("No");

        ButtonGroup ea = new ButtonGroup();
        ea.add(existingYes);
        ea.add(existingNo);

        existingYes.setBounds(300, 480, 80, 30);
        existingNo.setBounds(450, 480, 80, 30);

        existingYes.setBackground(Color.WHITE);
        existingNo.setBackground(Color.WHITE);

        add(existingYes);
        add(existingNo);

        next = new JButton("Next");
        next.setBounds(500, 520, 100, 40);
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.addActionListener(this);
        add(next);

        getContentPane().setBackground(Color.WHITE);

        setSize(700, 700);
        setLocation(350, 10);
        setVisible(true);
    }

    public void actionPerformed(ActionEvent ae) {

        String religion = (String) religionCB.getSelectedItem();
        String category = (String) categoryCB.getSelectedItem();
        String income = (String) incomeCB.getSelectedItem();
        String education = (String) educationCB.getSelectedItem();
        String occupation = (String) occupationCB.getSelectedItem();
        String pan = panTF.getText();
        String aadhar = aadharTF.getText();
        String senior = seniorYes.isSelected() ? "Yes" : "No";
        String existing = existingYes.isSelected() ? "Yes" : "No";

        try {
            Conn c = new Conn();

            String q = "INSERT INTO signup2 VALUES ('" + formno + "','" + religion + "','" + category + "','" +
                    income + "','" + education + "','" + occupation + "','" +
                    pan + "','" + aadhar + "','" + senior + "','" + existing + "')";

            c.s.executeUpdate(q);

            setVisible(false);
            new SignupThree(formno).setVisible(true);

        } catch (Exception e) {
            System.out.println("Error: " + e);
        }
    }
}
