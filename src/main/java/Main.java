
import javax.swing.*;
import java.util.*;

public class Main {

    public static void confirmPassword(String password){
        Scanner scan = new Scanner(System.in);
        System.out.print("\nPlease confirm your password: ");
        String confPass = scan.nextLine();

        while(!confPass.equals(password)){
            System.out.print("Passwords should match each other, please rewrite it: ");
            confPass = scan.nextLine();
            System.out.println();
        }
    }
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

        while(passArray.length<8){
            System.out.print("Password should be more than 7 characters : ");
            password = scan.nextLine();
            passArray = password.toCharArray();
        } // password shouldn't be less than 8 chars

        if(loginType==4) {
          confirmPassword(password);
        }

        if(loginType==1||loginType==2||loginType==3){
            
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
        boolean flag=false;

        while(!flag){
            try {

                logTypeNum = scanner.nextInt();

                if (logTypeNum > 0 && logTypeNum < 5)
                    flag = true;
                else
                    System.out.print("the number shouldn't exceed this range (1-4) please try again: ");


            } catch (Exception exp) {
                System.out.print("Please enter only a number from one to three: ");
                scanner.next();
            }
        }
        if(logTypeNum==1){
            printLogin(logTypeNum);

        }
        if(logTypeNum==2){
            printLogin(logTypeNum);

        }
        if(logTypeNum==3){
            printLogin(logTypeNum);

        }

        if(logTypeNum==4){
            printLogin(logTypeNum);

        }












    }
}