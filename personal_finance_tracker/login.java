package personal_fitness;

import java.sql.*;
import java.util.Scanner;

public class login {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    private  String user;
    private String password;
    public void log(){
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
                if(!r.next()){
                    System.out.println("UserName Not Found, Try with different UserName");
                    i=1;
                }
            }while(i==1);
            System.out.print("Enter PassWord: ");
            password = sc.next();
            String query2 = "SELECT pass FROM usepass WHERE name = ?";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query2);
            preparedStatement1.setString(1,user);
            ResultSet r1 = preparedStatement1.executeQuery();
            String p = "";
            if(r1.next()) {
                p = r1.getString("pass");
            }
            if(p.equals(password)){
                System.out.println("LOGIN SUCCESSFULLY");
                user_info u = new user_info();
                u.info(user);
            }
            else{
                System.out.println("Incorrect PassWord.");
            }
        }catch (Exception e){
            System.out.println(e.getMessage());
        }
    }
}
