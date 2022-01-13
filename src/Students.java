import java.sql.*;


public class Students {
    
    public String FirstName;
    public String LastName;
    public String RegNo;
    public String Gender;
    public String Subject;
    public String Class;
    public String Age;

    PreparedStatement ps;
   

    public void insertStudent()
    {
        String SqlQuery = "insert into students (FirstName, LastName, RegNo, Age, class, Subject, gender) values (?,?,?,?,?,?,?)";
        try {
            ps = MyConnection.connection().prepareStatement(SqlQuery);

            ps.setString(1, FirstName);
            ps.setString(2, LastName);
            ps.setString(3, RegNo);
            ps.setString(4, Age);
            ps.setString(5, Class);
            ps.setString(6, Subject);
            ps.setString(7, Gender);

            ps.executeUpdate();

        } catch (SQLException e) {
           e.printStackTrace();
        }

       
        
    }


    public ResultSet getStudents()
    {
        // Vector ColumnNames = new Vector();
        // Vector data = new Vector();
        Statement stmt;
        ResultSet rs = null;


        String Sql = "select * from students";
        
        try {
            stmt = MyConnection.connection().createStatement();
            rs = stmt.executeQuery(Sql);

            //ResultSetMetaData datamodel = rs.getMetaData();
           
        } catch (SQLException e) {
           
            e.printStackTrace();
        }

        return rs;

    
    }
    
}
