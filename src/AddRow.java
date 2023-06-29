import java.sql.*;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
public class AddRow {
    private static String DBURL = ("jdbc:mysql://localhost:3306/students?allowPublicKeyRetrieval=true&useSSL = false");
    private static String insertQuery = ("INSERT INTO student_ls VALUES (4, 'Hope James', 'Sociology', 'UniLag', 'Hope@gmail.com')");

    public void addRowTransaction(){

        try {
            //create connection to mysql driver using package
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection
            Connection connection = DriverManager.getConnection(DBURL, "root", "dbPassword");
            //create statement
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_SENSITIVE, ResultSet.CONCUR_UPDATABLE);
            //execute query
            ResultSet resultSet = statement.executeQuery("SELECT * FROM student_ls");
            resultSet.moveToInsertRow();
            resultSet.updateInt("id", 4);
            resultSet.updateString("name", "Hope James");
            resultSet.updateString("department", "Sociology");
            resultSet.updateString("institution", "UniLag");
            resultSet.updateString("email", "Hope@gmail.com");

            //check returned result
//            while (resultSet.rowInserted()){
//                int id = resultSet.getInt("id");
//                String name = resultSet.getString("name");
//                String department = resultSet.getString("department");
//                String institution = resultSet.getString("institution");
//                String email = resultSet.getString("email");
//
//                System.out.println(id + " " + name + " " + department + " " + institution + " " + email + " " + "added");
//            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        }
    }
}
