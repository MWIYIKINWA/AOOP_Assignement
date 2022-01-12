import javax.swing.JFrame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RegForm  extends JFrame
{

    final private Font mainFont = new Font("Segeo print", Font.BOLD, 18);
    JTextField tfEmail, tfUsername, tfRole;
    JPasswordField pfPassword;
   

    public void initialize()
    {
        Users users = new Users();

        //form panel
        
        JLabel lbLoginForm = new JLabel("Registraion Form", SwingConstants.CENTER);
        lbLoginForm.setFont(mainFont);

        JLabel lbEmail = new JLabel("Email"); //email
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbUsername = new JLabel("User name");  //username
        lbUsername.setFont(mainFont);

        tfUsername = new JTextField();
        tfUsername.setFont(mainFont);

        JLabel lbRole = new JLabel("Role");  //Role
        lbRole.setFont(mainFont);

        tfRole = new JTextField();
        tfRole.setFont(mainFont);


        JLabel lbPassword = new JLabel("Password"); //password
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50 ,30 ,50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbUsername);
        formPanel.add(tfUsername);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);
        formPanel.add(lbRole);
        formPanel.add(tfRole);

        
        //buttons panel
        
        //Reg Button
        JButton btnRegister = new JButton("Register");
        btnRegister.setFont(mainFont);
        btnRegister.addActionListener(new ActionListener()
        {

           @Override
           public void actionPerformed(ActionEvent e) {
             
               users.email = tfEmail.getText();
               users.username = tfUsername.getText();
               users.role = tfRole.getText();
               users.password = String.valueOf(pfPassword.getPassword());

               if( users.email.equals("") || users.username.equals("") || users.role.equals("") || users.password.equals(""))
               {
                  JOptionPane.showMessageDialog(null, 
                  "All fields are required", 
                  "Try again", 
                  JOptionPane.ERROR_MESSAGE);
               }
               else
               {
                users.insertUser();
                JOptionPane.showMessageDialog(null, "Record Added", "Success",JOptionPane.OK_OPTION);
                tfEmail.setText("");
                tfUsername.setText("");
                tfRole.setText("");
                pfPassword.setText("");

               }
               
           }

       

           
            
        });

        JButton btnCancel = new JButton("Cancel");
        btnCancel.setFont(mainFont);
        btnCancel.addActionListener(new ActionListener()
        {

           @Override
           public void actionPerformed(ActionEvent e) {
              dispose();
               
           }

           
            
        });

        JPanel buttonsPanel = new JPanel();
        buttonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
        buttonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 40, 20, 40));
        buttonsPanel.add(btnRegister);
        buttonsPanel.add(btnCancel);

        //layout
        add(formPanel, BorderLayout.NORTH);
        add(buttonsPanel, BorderLayout.SOUTH);

        setTitle("Registration Form");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(350, 450));
        //setResizable
        setLocationRelativeTo(null);
        setVisible(true);
    }
    
}
