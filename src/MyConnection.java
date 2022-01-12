import java.sql.Connection;
import java.sql.DriverManager;

public class MyConnection {
    
    public static Connection connection()
    {
        Connection conn = null;

        final String DB_URL = "jdbc:mysql://localhost/studentwindowapp?serverTimezone=UTC";
        final String USERNAME = "root";
        final String PASSWORD = "";

        try {

            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL, USERNAME, PASSWORD);
            
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        return conn;



    }
}
