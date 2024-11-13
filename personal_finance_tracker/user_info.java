package personal_fitness;
import java.sql.*;
import java.util.Scanner;

public class user_info {
    private static final String url = "jdbc:mysql://localhost:3306/regis";
    private static final String username= "root";
    private static final String pass = "Mlpokn@123456";
    public void info(String name){
        int expense = 0;
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
        }
        catch(ClassNotFoundException e){
            System.out.println(e.getMessage());
        }
        try{
            Scanner s = new Scanner(System.in);
            Connection connection = DriverManager.getConnection(url,username,pass);
            String query = "SELECT total_e FROM "+name+" ";
            do {
                PreparedStatement preparedStatement = connection.prepareStatement(query);
                ResultSet r = preparedStatement.executeQuery();
                if (r.next()) {
                    expense = r.getInt("total_e");
                }
                System.out.println("--- Welcome, " + name + " ---");
                System.out.println("TOTAL EXPENSE = " + expense);
                System.out.println("1. Add Expense");
                System.out.println("2. Category-Wise Expense List");
                System.out.println("0. Exit");
                int choice = s.nextInt();
                switch (choice) {
                    case 1:
                        add_expense(name, expense);
                        break;
                    case 2:
                        cat_wise(name);
                        break;
                    case 0:
                        System.exit(0);
                        break;
                    default:
                        System.out.println("Invalid Choice");
                        break;
                }
            }while(true);
        }catch(Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public void add_expense(String name,int expense){
        add_e a = new add_e();
        a.add(name,expense);
    }
    public void cat_wise(String name){
        cat_wise c = new cat_wise();
        c.show(name);
    }
}
