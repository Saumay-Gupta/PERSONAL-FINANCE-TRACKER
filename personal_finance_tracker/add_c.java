package personal_fitness;

import java.sql.*;
import java.util.Scanner;

public class add_c {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    public void add(String name) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try {
            Scanner s = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url, username, pass);
            System.out.print("Enter Category: ");
            String cat = s.next();
            String query = "INSERT INTO " +name+" VALUES(0,?,0)";
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1,cat);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
}
