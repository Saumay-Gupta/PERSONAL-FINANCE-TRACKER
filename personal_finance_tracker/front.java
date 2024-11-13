package personal_fitness;

import java.util.Scanner;

public class front {
    private int choice;
    public front(){
        Scanner s = new Scanner(System.in);
        System.out.println("---Welcome---");
        System.out.println("1. SIGN-UP");
        System.out.println("2. LOGIN");
        System.out.println("0. EXIT");
        choice = s.nextInt();
        switch (choice){
            case 1:
                sign_up();
                break;
            case 2:
                log_in();
                break;
            case 0:
                System.exit(0);
                break;
            default:
                System.out.println("Invalid Choice");
                break;
        }
    }
    public void sign_up(){
        signup s= new signup();
        s.sign();
    }
    public void log_in(){
        login l = new login();
        l.log();
    }
}
