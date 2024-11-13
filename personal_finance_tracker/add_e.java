package personal_fitness;
import java.sql.*;
import java.util.Scanner;

public class add_e {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    public void add(String name,int exp){
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            int choice = 0;
            Scanner s = new Scanner(System.in);
            int i =1;
            int j= 0;
            Connection connection = DriverManager.getConnection(url,username,pass);
            String query = "SELECT category FROM "+name;
            do{
                j =0;
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet r = preparedStatement.executeQuery();
                while (r.next()) {
                    String c = r.getString("category");
                    System.out.println(i + ". " + c);
                    i++;
                }
                System.out.println(i + ". Add New Category");
                choice = s.nextInt();
                if (choice == i) {
                    add_c ac = new add_c();
                    ac.add(name);
                    j=1;
                    i=1;
                }
            }while(j==1);
            System.out.print("Enter Expense: ");
            int expense = s.nextInt();
            String query2 =  " UPDATE " +name+" SET category_e = ? WHERE category = ( SELECT category FROM (SELECT category FROM "+name+ " LIMIT 1 OFFSET ?) AS temp); ";
            PreparedStatement preparedStatement1 = connection.prepareStatement(query2);
            preparedStatement1.setInt(1,expense);
            preparedStatement1.setInt(2,choice-1);
            preparedStatement1.executeUpdate();

            String query3 = "UPDATE "+name+" SET total_e = ?";
            PreparedStatement preparedStatement3 = connection.prepareStatement(query3);
            preparedStatement3.setInt(1,(exp+expense));
            preparedStatement3.executeUpdate();
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
    }
}


