import java.sql.*;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;
import java.sql.Statement;

public class DataBasePrac {
    //create connection string first
    private String databaseURL = ("jdbc:mysql://localhost:3306/university?allowPublicKeyRetrieval=true&useSSL = false");

    private static final String QUERY = ("SELECT dept_id , dept_name FROM departments ORDER BY dept_name");
    private static final String secQUERY = ("SELECT dept_id , dept_name FROM departments ORDER BY dept_id");

    public void startTransactions(){
        try {
            //calling the jdbc package to access driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            //step 1 establish connection to database
            Connection connection = DriverManager.getConnection(databaseURL, "root", "myPassword");

            //step 2 create statement using connection object
            Statement statement = connection.createStatement();

            //step 3 execute the query
            ResultSet resultSet = statement.executeQuery(QUERY);

            //step 4 processing the result
            while (resultSet.next()){
                int id = resultSet.getInt("dept_id");
                String departmentName = resultSet.getString("dept_name");
//                String building = resultSet.getString("building");
//                String budget = resultSet.getString("budget");

                System.out.println(id + " " + departmentName);
            }

        } catch (SQLException | ClassNotFoundException throwables) {
            throwables.printStackTrace();
        }
    }
}
