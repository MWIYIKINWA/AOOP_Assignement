import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;

public class MainBoard extends JFrame
{
    final private Font mainFont = new Font("Segeo print", Font.BOLD, 18);
    final private Font headerFont = new Font("Segeo print", Font.BOLD, 30);
    final private Font SubheaderFont = new Font("Segeo print", Font.BOLD, 25);
    JTextField tfFirstName, tfLastName, tfRegNo, tfGender, tfAge, tfSubject;

    public void initialize()
    {
        JLabel lbHeading = new JLabel("Dashboard", SwingConstants.CENTER);
        lbHeading.setFont(headerFont);

        //student registration
        JLabel lbStudentReg = new JLabel("Students Registration");  //heading
        lbStudentReg.setFont(SubheaderFont);

        JLabel lbFirstName = new JLabel("First Name"); 
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField("FirstName");
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name"); 
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField("LastName");
        tfLastName.setFont(mainFont);

        JLabel lbREgNo = new JLabel("Registration Number"); 
        lbREgNo.setFont(mainFont);

        tfRegNo = new JTextField("RegNo");
        tfRegNo.setFont(mainFont);

        JLabel lbGender = new JLabel("Gender"); 
        lbGender.setFont(mainFont);

        tfGender = new JTextField("Gender");
        tfGender.setFont(mainFont);

        JLabel lbAge = new JLabel("Age"); 
        lbAge.setFont(mainFont);

        tfAge = new JTextField("Age");
        tfAge.setFont(mainFont);

        JLabel lbSubject = new JLabel("Subject"); 
        lbSubject.setFont(mainFont);

        tfSubject = new JTextField("Subject");
        tfSubject.setFont(mainFont);

        JLabel lbClass = new JLabel("Class"); 
        lbClass.setFont(mainFont);

        tfClass = new JTextField("Class");
        tfClass.setFont(mainFont);

        JButton btnReg = new JButton("REGISTER");
        btnReg.setFont(mainFont);

        JButton btnUpdate = new JButton("UPDATE");
        btnUpdate.setFont(mainFont);

        JButton btnDelete = new JButton("DELETE");
        btnDelete.setFont(mainFont);

        JPanel FormPanel = new JPanel();
        FormPanel.setLayout(new GridLayout(0,1,10,10));
        FormPanel.setBorder(BorderFactory.createEmptyBorder(30, 50, 30, 50));
        FormPanel.add(lbStudentReg);
        FormPanel.add(lbFirstName);
        FormPanel.add(tfFirstName);
        FormPanel.add(lbLastName);
        FormPanel.add(tfLastName);
        FormPanel.add(lbREgNo);
        FormPanel.add(tfRegNo);
        FormPanel.add(lbGender);
        FormPanel.add(tfGender);
        FormPanel.add(lbAge);
        FormPanel.add(tfAge);
        FormPanel.add(lbSubject);
        FormPanel.add(tfSubject);
        FormPanel.add(btnReg);
        FormPanel.add(btnDelete);
        FormPanel.add(btnUpdate);



         //....................layout
         add(lbHeading, BorderLayout.NORTH);
         add(FormPanel, BorderLayout.WEST);



        
        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        //setResizable
        setLocationRelativeTo(null);
        setVisible(true); 
    
    }
    
}
