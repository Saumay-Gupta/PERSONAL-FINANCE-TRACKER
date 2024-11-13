package personal_fitness;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class cat_wise {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    public void show(String name){
            try{
                Class.forName("com.mysql.cj.jdbc.Driver");
            }catch (ClassNotFoundException e){
                System.out.println(e.getMessage());
            }
            try {
                Connection connection = DriverManager.getConnection(url, username, pass);
                String query = "SELECT category,category_e FROM "+name;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet r = preparedStatement.executeQuery();
                while(r.next()){
                    String cat = r.getString("category");
                    int ce = r.getInt("category_e");
                    System.out.println("Category: "+cat+", Expense= "+ce);
                }
            }
            catch (Exception e){
                System.out.println(e.getMessage());
            }
    }
}
