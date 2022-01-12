import java.sql.*;
public class Users{

    public String email;
    public String username;
    public String password;
    public String role;

    PreparedStatement ps;


   public void insertUser()
   {
       String  SqlQuery = "insert into users (email, password, Role, username) values (?,?,?,?)";
       try {
        ps =  MyConnection.connection().prepareStatement(SqlQuery);

        ps.setString(1, email);
        ps.setString(2, password);
        ps.setString(3, role);
        ps.setString(4, username);

        ps.executeUpdate();
        
    } catch (SQLException e) {
        e.printStackTrace();
    }
   }

   public void UserAuthentication()
   {
       String SqlQuery = "SELECT * FROM users where email =? AND password =?";

       try {
           ps = MyConnection.connection().prepareStatement(SqlQuery);

           ps.setString(1, email);
           ps.setString(2, password);

           ps.executeQuery();
           
       } catch (Exception e) {
           System.out.println(e.getMessage());
       }
   }
    
}
