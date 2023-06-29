import java.sql.*;
import java.sql.DriverManager;
import java.sql.Connection;
import java.sql.Statement;

public class FetchData {
    //create connection to the database
    private String DBURL = ("jdbc:mysql://localhost:3306/students?allowPublicKeyRetrieval=true&useSSL = false");
    private static final String fetchStudents = ("SELECT id, name, department, email FROM student_ls");
    private static final String fetchGrades = ("SELECT stud_id, gpa_one, gpa_two FROM grades");
    private static final String leftJoinResult = ("SELECT student_ls.id, student_ls.name, student_ls.department, grades.gpa_one, grades.gpa_two FROM student_ls LEFT OUTER JOIN grades ON student_ls.id = grades.stud_id");

    //method to fetch students
    public void beginFetchStudent(){
        try {
            //access db driver from package
            Class.forName("com.mysql.cj.jdbc.Driver");

            //establish connection
            Connection connection = DriverManager.getConnection(DBURL, "root", "Edward007");
            //create statement from connection object

            Statement statement = connection.createStatement();
            //execute statement
            ResultSet resultSet = statement.executeQuery(fetchStudents);

            //processing results
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                String email = resultSet.getString("email");

                System.out.println(id + " " + name + " " + department + " " + email);
            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        }
    }

    //method to fetch grades
    public void beginFetchGrades(){

        try {
            //create connection to driver calling package
            Class.forName("com.mysql.cj.jdbc.Driver");

            //create connection
            Connection connection = DriverManager.getConnection(DBURL, "root", "Edward007");

            //create statement and execute query
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(fetchGrades);

            //check result returned
            while (resultSet.next()){
                int stud_id = resultSet.getInt("stud_id");
                float gpa_one = resultSet.getFloat("gpa_one");
                float gpa_two = resultSet.getFloat("gpa_two");

                System.out.println(stud_id + " " + gpa_one + " " + gpa_two);
            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        }

    }

    //left join results method
    public void leftJoinTransaction(){
        try {
            //create connection to db package
            Class.forName("com.mysql.cj.jdbc.Driver");
            //create connection to driver
            Connection connection = DriverManager.getConnection(DBURL, "root", "Edward007");
            //create statement
            Statement statement = connection.createStatement();
            //pass query
            ResultSet resultSet = statement.executeQuery(leftJoinResult);

            //check valid output
            while (resultSet.next()){
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String department = resultSet.getString("department");
                float gpa_one = resultSet.getFloat("gpa_one");
                float gpa_two = resultSet.getFloat("gpa_two");

                System.out.println(id + " " + name + " " + department + " gpa1: " + gpa_one + " gpa2: " + gpa_two);
            }
        }catch (SQLException | ClassNotFoundException throwable){
            throwable.printStackTrace();
        }
    }
}
