import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame
{
    final private Font mainFont = new Font("Segeo print", Font.BOLD, 18);
    final private Font headerFont = new Font("Segeo print", Font.BOLD, 25);
    JTextField tfEmail;
    JPasswordField pfPassword;
    Users users = new Users();

    public void initialize()
    {
        //form panel
        JLabel lbLoginForm = new JLabel("Login Form", SwingConstants.CENTER);
        lbLoginForm.setFont(headerFont);

        JLabel lbEmail = new JLabel("Email");
        lbEmail.setFont(mainFont);

        tfEmail = new JTextField();
        tfEmail.setFont(mainFont);

        JLabel lbPassword = new JLabel("Password");
        lbPassword.setFont(mainFont);

        pfPassword = new JPasswordField();
        pfPassword.setFont(mainFont);

        JPanel formPanel = new JPanel();
        formPanel.setLayout(new GridLayout(0, 1, 10, 10));
        formPanel.setBorder(BorderFactory.createEmptyBorder(30, 50 ,30 ,50));
        formPanel.add(lbLoginForm);
        formPanel.add(lbEmail);
        formPanel.add(tfEmail);
        formPanel.add(lbPassword);
        formPanel.add(pfPassword);

         //buttons panel
         JButton btnLogin = new JButton("Login");
         btnLogin.setFont(mainFont);
         btnLogin.addActionListener(new ActionListener()
         {

            @Override
            public void actionPerformed(ActionEvent e) {
                
                users.email = tfEmail.getText();
                users.password = String.valueOf(pfPassword.getPassword());
                if(users.email.equals("") || users.password.equals(""))
                {
                   JOptionPane.showMessageDialog(null, 
                   "All fields are required", 
                   "Try again", 
                   JOptionPane.ERROR_MESSAGE);
                }
                else
                {
                
                users.UserAuthentication();
                MainBoard mb = new MainBoard();
                mb.initialize();
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

         JButton btnRegister = new JButton("Register");
         btnRegister.setFont(mainFont);
         btnRegister.addActionListener(new ActionListener()
         {

            @Override
            public void actionPerformed(ActionEvent e) {
               
              RegForm registration = new RegForm();
              registration.initialize();
                
            }
             
         });

         JPanel butonsPanel = new JPanel();
         butonsPanel.setLayout(new GridLayout(1, 2, 10, 0));
         butonsPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 40, 50));
         butonsPanel.add(btnLogin);
         butonsPanel.add(btnCancel);
         butonsPanel.add(btnRegister);

          //inistialise the frame
        add(formPanel, BorderLayout.NORTH);
        add(butonsPanel, BorderLayout.SOUTH);
        

        setTitle("Katikamu Primary School Login");
        setDefaultCloseOperation(WindowConstants.DISPOSE_ON_CLOSE);
        setSize(400, 500);
        setMinimumSize(new Dimension(390, 500));
        //setResizable
        setLocationRelativeTo(null);
        setVisible(true);
    }

    

}