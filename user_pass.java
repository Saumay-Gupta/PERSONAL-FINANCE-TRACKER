import com.mysql.cj.protocol.Resultset;
import java.sql.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.util.Scanner;

public class user_pass {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    public static void main(String[] args) {
       try{
           Class.forName("com.mysql.cd.jdbc.Driver");
       }
       catch(ClassNotFoundException e){
           System.out.println(e.getMessage());
       }
       try{
           System.out.println("Enter:");
           Scanner s = new Scanner(System.in);
           String user = s.next();
           Connection connection = DriverManager.getConnection(url,username,pass);
           String query = "SELECT name FROM usepass WHERE name=?";
           PreparedStatement preparedStatement = connection.prepareStatement(query);
           preparedStatement.setString(1,user);
           ResultSet r = preparedStatement.executeQuery();
           while(r.next()){
               String n = r.getString("name");
               if(user.equals(n)) {
                   System.out.println("T");
                   break;
               }
               System.out.println(n);
           }
       }
       catch(Exception e){
           System.out.println(e.getMessage());
       }
    }
}
