import javax.swing.*;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.jdbc.result.ResultSetMetaData;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

public class MainBoard extends JFrame
{
    final private Font mainFont = new Font("Segeo print", Font.BOLD, 18);
    final private Font headerFont = new Font("Segeo print", Font.BOLD, 30);
    final private Font SubheaderFont = new Font("Segeo print", Font.BOLD, 25);
    JTextField tfFirstName, tfLastName, tfRegNo, tfGender, tfAge, tfSubject, tfClass;
    Students students = new Students();

    public void initialize()
    {
        JLabel lbHeading = new JLabel("Dashboard", SwingConstants.CENTER);
        lbHeading.setFont(headerFont);

        //student registration
        JLabel lbStudentReg = new JLabel("Students Registration");  //heading
        lbStudentReg.setFont(SubheaderFont);

        JLabel lbFirstName = new JLabel("First Name"); 
        lbFirstName.setFont(mainFont);

        tfFirstName = new JTextField();
        tfFirstName.setFont(mainFont);

        JLabel lbLastName = new JLabel("Last Name"); 
        lbLastName.setFont(mainFont);

        tfLastName = new JTextField();
        tfLastName.setFont(mainFont);

        JLabel lbREgNo = new JLabel("Registration Number"); 
        lbREgNo.setFont(mainFont);

        tfRegNo = new JTextField();
        tfRegNo.setFont(mainFont);

        JLabel lbGender = new JLabel("Gender"); 
        lbGender.setFont(mainFont);

        tfGender = new JTextField();
        tfGender.setFont(mainFont);

        JLabel lbAge = new JLabel("Age"); 
        lbAge.setFont(mainFont);

        tfAge = new JTextField();
        tfAge.setFont(mainFont);

        JLabel lbSubject = new JLabel("Subject"); 
        lbSubject.setFont(mainFont);

        tfSubject = new JTextField();
        tfSubject.setFont(mainFont);

        JLabel lbClass = new JLabel("Class"); 
        lbClass.setFont(mainFont);

        tfClass = new JTextField();
        tfClass.setFont(mainFont);

        JButton btnReg = new JButton("REGISTER");
        btnReg.setFont(mainFont);
        btnReg.addActionListener(new ActionListener(){

            @Override
            public void actionPerformed(ActionEvent e) {
                
                students.FirstName = tfFirstName.getText();
                students.LastName = tfLastName.getText();
                students.Age = tfAge.getText();
                students.Class = tfClass.getText();
                students.Gender = tfGender.getText();
                students.RegNo = tfRegNo.getText();
                students.Subject = tfSubject.getText();

                if(students.FirstName.equals("") || 
                students.LastName.equals("") ||
                students.Age.equals("") ||
                students.Class.equals("") ||
                students.Gender.equals("") ||
                students.RegNo.equals("") ||
                students.Subject.equals(""))
                {
                    JOptionPane.showMessageDialog(null, 
                    "All fields are required", 
                    "Error", 
                    JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                    students.insertStudent();
                    JOptionPane.showMessageDialog(null, 
                    tfFirstName.getText() + " " + tfLastName.getText() + " Successffully registered ", 
                    "Success", 
                    JOptionPane.OK_OPTION);
                }
                
            }
            
        });

        

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

        //grid vieww
        //layout for logic
        Vector ColumnNames = new Vector();
        Vector Rows = new Vector();
        ResultSetMetaData datamodel = students.getStudents().getMetaData();
        int columns = datamodel.getColumnCount();
        for(int i = 1; i <= columns; i++)
        {
            ColumnNames.addElement(datamodel.getColumnName(i));
        }
        while(students.getStudents().next()){
            Vector row = new Vector(columns);
            for(int i; i<=columns; i++)
            {
                row.addElement(students.getStudents().getObject(i));
            }

            Rows.addElement(row);

        }
         


        JTable table = new JTable();
        JScrollPane scroller = new JScrollPane();
        scroller.setBounds(10,34,416, 126);
        scroller.setViewportView(table);

        
        JPanel tablepanel = new JPanel();
        tablepanel.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        tablepanel.add(scroller);



         //....................layout
         add(lbHeading, BorderLayout.NORTH);
         add(FormPanel, BorderLayout.WEST);
         add(tablepanel, BorderLayout.CENTER);




        
        setTitle("Dashboard");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(1100, 650);
        //setResizable
        setLocationRelativeTo(null);
        setVisible(true); 
    
    }



    
}
