
import javax.swing.*;
import java.util.*;

public class Main {
    public static void printLogin (int loginType){
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String username = scan.nextLine();
        char[] userArray = username.toCharArray();

        while(userArray.length<4 || username.contains(" ")){
            System.out.print("Username should be more than 3 characters with no gaps: ");
            username = scan.nextLine();
            userArray = username.toCharArray();
        } //username should be more than 4 chars


        System.out.print("\nPlease enter your password: ");
        String password = scan.nextLine();
        char[] passArray = password.toCharArray();

        while(passArray.length<8 || password.contains(" ")){
            System.out.print("Password should be more than 7 characters with no gaps: ");
            password = scan.nextLine();
            passArray = password.toCharArray();
        } // password shouldn't be less than 8 chars

        if(loginType==4) {
            System.out.print("\nPlease confirm your password: ");
            String confPass = scan.nextLine();

            while(!confPass.equals(password)){
                System.out.print("Passwords should match each other, please rewrite it: ");
                confPass = scan.nextLine();
                System.out.println();
            }
        }
        System.out.print("\n");
    }





    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
//        ArrayList<String> tenantsUsername;
//        ArrayList<String>  tenantsPassword;
        System.out.println("**************  welcome to sacanati project **************");
        System.out.print("\n Please choose and press the type of login: \n 1)admin 2)tenant 3)owner " +
                "4)register as new tenant : ");
        int logTypeNum=0;

        while(true) {
            try {

                logTypeNum = scanner.nextInt();
                if (logTypeNum > 0 && logTypeNum < 5)
                    break;
                else
                    System.out.print("the number shouldn't exceed this range (1-3) please try again: ");

            } catch (Exception exp) {
                System.out.println("Please enter only a number from one to three");
            }
        }

        if(logTypeNum==4){
            printLogin(logTypeNum);

        }












    }
}