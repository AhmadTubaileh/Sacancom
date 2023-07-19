import java.util.*;
import Owner.*;
import java.util.*;


public class Main {
    private String username;
    private String password;
    private static Main main = new Main();
    public void setUser(String user){username= user;}
    public void setPassword(String pass){password =pass;}
    public String getPassword(){return password;}
    public  String getUsername(){return username;}
    private ArrayList<Owner> owners;
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
    public static void printLogin (){
        Scanner scan = new Scanner(System.in);

        System.out.print("Please enter your username: ");
        String username = scan.nextLine();
        main.setUser(username);


        System.out.print("\nPlease enter your password: ");
        String password = scan.nextLine();
        main.setPassword(password);

        System.out.print("\n");
    }

    public static void printRegistration(int registrationType,Owner owner){
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
        confirmPassword(password);
        if(registrationType==4){

        } else if (registrationType==5) {

            owner.setUserName(username);
            owner.setPassword(password);
        }

    }

    public static void owners(ArrayList<String> owners){

    }




    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Owner> owners= new ArrayList<Owner>();
        System.out.println("\n**************  welcome to sacanati project **************");


        while(true) {
            System.out.print("\n Please choose and press the type of login: \n 1)admin 2)owner 3)tenant " +
                    "4)register as new tenant 5)register as an owner : ");
            int logTypeNum = 0;
            boolean flag = false;
            boolean equalFlag = false;

            while (!flag) {
                try {

                    logTypeNum = scanner.nextInt();

                    if (logTypeNum > 0 && logTypeNum < 6)
                        flag = true;
                    else
                        System.out.print("the number shouldn't exceed this range (1-5) please try again: ");


                } catch (Exception exp) {
                    System.out.print("Please enter only a number from one to 5: ");
                    scanner.next();
                }
            }
            if (logTypeNum == 1) { // admin
                printLogin();

            }
            if (logTypeNum == 2) { // owner
                while (true) {
                printLogin();
                    for (Owner o : owners) {
                        if (o.getPassword().equals(main.getPassword()) && o.getUserName().equals(main.getUsername())) {
                            equalFlag = true;
                            break;
                        }

                    }
                    if (!equalFlag) {
                        System.out.println("username or password is wrong.");
                    }
                    if(equalFlag)break;
                }



                ///////////////////////////continue inside owner
            }
            if (logTypeNum == 3) { // tenant
                printLogin();

            }

            if (logTypeNum == 4) { // registration as tenant
                printRegistration(4, null);

            }
            if (logTypeNum == 5) { // registration as owner
                Owner owner = new Owner();
                printRegistration(5, owner);
                owners.add(owner);
            }
        }

    }
}