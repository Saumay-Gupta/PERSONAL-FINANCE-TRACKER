package personal_fitness;

import java.sql.*;
import java.util.Scanner;

public class signup {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    private  String user;
    private String password;
    public void sign(){
        Scanner sc = new Scanner(System.in);
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            int i = 0;
            Connection connection = DriverManager.getConnection(url,username,pass);
            do{
                i=0;
                System.out.print("Enter UserName: ");
                user = sc.next();
                String query = "SELECT name FROM usepass WHERE name = ?";
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                preparedStatement.setString(1,user);
                ResultSet r = preparedStatement.executeQuery();
                if(r.next()){
                    System.out.println("UserName already taken, try with different username");
                    i=1;
                }
            }while(i==1);
                System.out.print("Create PassWord: ");
                password = sc.next();
                String query2 = "INSERT INTO usepass(name,pass) VALUES (? , ?) ";
                PreparedStatement preparedStatement1 = connection.prepareStatement(query2);
                preparedStatement1.setString(1,user);
                preparedStatement1.setString(2,password);
                int rowsaffected = preparedStatement1.executeUpdate();
                if(rowsaffected>0){
                    String query3 = "CREATE TABLE " + user + " ("
                            + "total_e int,"
                            + "category varchar(255),"
                            + "category_e int"
                            + ")";
                    PreparedStatement preparedStatement2 = connection.prepareStatement(query3);
                    preparedStatement2.executeUpdate();
                    String query4 = "INSERT INTO " +user+ " (total_e,category,category_e) VALUES" + "(0,'Food',0)," + "(0,'Travel',0)," + "(0,'Shopping',0)";
                    PreparedStatement preparedStatement3 = connection.prepareStatement(query4);
                    preparedStatement3.executeUpdate();
                    System.out.println("SIGN-UP Completed");
                    user_info u = new user_info();
                    u.info(user);
                }else {
                    System.out.println("Error");
                }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
