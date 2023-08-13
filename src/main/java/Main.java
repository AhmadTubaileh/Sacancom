
import owner.*;
import tenant.*;
import admin.*;
import house.*;

import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Main {
    private static final Logger LOGGER = Logger.getLogger("org.example.Main");
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
    public static void printRegistration(int registrationType,Object obj){
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
            Tenant tenant = (Tenant) obj;
            tenant.setUsername(username);
            tenant.setPassword(password);
            System.out.print("please enter your name and family name: ");
            tenant.setName(scan.nextLine());
            System.out.print("please enter your resident & information to contact with you: ");
            tenant.setInformation(scan.nextLine());
            System.out.print("are you a student? (y) for yes and anything else for no: ");
            String answer = scan.nextLine();
            if(answer.equals("y")) {
                tenant.setStudent(true);
                System.out.print("what is your major: ");
                answer=scan.nextLine();
                tenant.setMajor(answer);
                System.out.print("what is your age: ");
                answer= scan.nextLine();
                tenant.setAge(answer);
            }

        } else if (registrationType==5) {
            Owner owner = (Owner) obj;
            owner.setUserName(username);
            owner.setPassword(password);
            System.out.print("please enter your full name: ");
            owner.setName(scan.nextLine());
            System.out.print("please enter your resident & information to contact with you: ");
            owner.setInformation(scan.nextLine());
        }

    }

    public static void main(String[] args) {
        Scanner scanner;
        Admin admin = new Admin();
        admin.setUsername("mahmoud");
        admin.setPassword("2392975asd");
        ArrayList<Owner> owners= new ArrayList<>();
        ArrayList<Tenant> tenants = new ArrayList<>();
       Owner ownerTest = new Owner();
       House houseTest = new House();
       houseTest.setHouseName("sacanati");
        houseTest.setFloors("4");
        houseTest.setIsHouseStudent(true);
        houseTest.setLocation("nablus");
        houseTest.setPrice("1500$");
        houseTest.setAvailableServices("non");
        houseTest.setStreet("yafa");
        houseTest.setPhotosLink("link1");

        ownerTest.setHouses(houseTest);
        ownerTest.setUserName("ahmad");
        ownerTest.setPassword("2392975asd");
        ownerTest.setInformation("0595160600");
        ownerTest.setName("ahmad tubaileh");
        owners.add(ownerTest);
        admin.setOwner(ownerTest);

        System.out.println("\n**************  welcome to sacanati project **************");


        while(true) {
            String write = "\nPlease choose and press the type of login: \n 1)admin 2)owner 3)tenant 4)register as new tenant 5)register as an owner\n6) exit. : ";

           LOGGER.log(Level.INFO,write);
            int logTypeNum = 0;
            boolean flag = false;

            scanner = new Scanner(System.in);

            while (!flag) {
                try {

                    logTypeNum = scanner.nextInt();

                    if (logTypeNum > 0 && logTypeNum < 7)
                        flag = true;
                    else
                        System.out.print("the number shouldn't exceed this range (1-5) please try again: ");


                } catch (Exception exp) {
                    System.out.print("Please enter only a number from one to 5: ");
                    scanner.next();
                }
            }








            if (logTypeNum == 1) { // admin
                String user = "";
                String pass = "";
                scanner = new Scanner(System.in);
                Boolean foundAdmin = false;

                do {
                    write="please enter your username : ";
                    LOGGER.log(Level.INFO,write);
                    user = scanner.nextLine();
                    write="please enter your password : ";
                    LOGGER.log(Level.INFO,write);
                    pass = scanner.nextLine();
                    if (admin.getPassword().equals(pass) && admin.getUsername().equals(user)) {
                        foundAdmin = true;
                    }
                    if (Boolean.FALSE.equals(foundAdmin)) {
                        write = "username or password is wrong. ";
                        LOGGER.log(Level.WARNING, write);
                    }
                } while (Boolean.FALSE.equals(foundAdmin));



                do{
                    write = "what to do next: 1)look at the request of adding houses." +
                            "2)see all reservations. \n"+"3) type anything else to exit";////////////////////////////
                    LOGGER.log(Level.INFO, write);
                    scanner = new Scanner(System.in);
                String answer = scanner.nextLine();
                int counter = 0;

                    if (answer.equals("1")) {
                        for (Owner o : admin.getOwners()) {
                            int k = 0;
                            int size = o.getHouseRequests().size();

                            for (int i = 0; i < size; i++) {
                                House h = o.getHouseRequest(i - k);

                                write = counter + ") " + "\nowner name: " + o.getName() + "\nowner information: " + o.getInformation() +
                                        "\nhouse name: " + h.getHouseName() + "\nlocation: " + h.getLocation() + " at the street: "
                                        + h.getStreet() + "\nnumber of floors: " + h.getFloors();
                                LOGGER.log(Level.INFO, write);
                                for (String s : h.getPhotosLink()) {
                                    write = "\nphoto of the house link: " + s;
                                    LOGGER.log(Level.INFO, write); // print all the photos for one house
                                }
                                write = "\nMonthly rent for each department: " + h.getPrice() + "\nprovided services: " +
                                        h.getAvailableServices() + "\n";
                                LOGGER.log(Level.INFO, write);

                                write = "do you want to advertise it ?? (y) for yes (n) for no\n";
                                LOGGER.log(Level.INFO, write);
                                boolean validInput = false;
                                do {
                                    scanner = new Scanner(System.in);
                                    answer = scanner.nextLine();
                                    if (answer.equalsIgnoreCase("n")) {
                                        o.removeHouseRequest(i - k);
                                        k++;
                                        validInput = true;
                                    } else if (answer.equalsIgnoreCase("y")) {
                                        o.setHouses(h);
                                        validInput = true;
                                    } else {
                                        write = "please enter y or n only";
                                        LOGGER.log(Level.WARNING, write);
                                    }
                                } while (!validInput);

                                counter++;
                            }
                        }
                    } else if (answer.equals("2")) {
                        int count = 0;
                        for (Tenant t : admin.getTenantsRequest()) {
                            write = count + ") tenant: " + t.getName() + " has reserved in " + t.getHouse().getHouseName() +
                                    " for " + t.getOwner().getName() + "\n";
                            LOGGER.log(Level.INFO, write);
                            count++;
                        }
                    } else {
                        break ;
                    }

            }while(true);
            }















           else if (logTypeNum == 2) { // owner
                Owner owner = new Owner(); //this owner is used after searching for an existing owner.
                String user="";
                String pass="";
                scanner= new Scanner(System.in);
                boolean foundOwner =false;

                while (true) {
                    System.out.print("please enter your username: ");
                     user = scanner.nextLine();
                    System.out.print("please enter your password: ");
                     pass = scanner.nextLine();

                    for (Owner o : owners) {
                        if (o.getPassword().equals(pass) && o.getUserName().equals(user)) {
                            foundOwner = true;
                            owner = o;
                            break;
                        }

                    }

                    if (!foundOwner) {
                        System.out.println("username or password is wrong.");
                    }
                    else break;
                }

                while(true){
                    System.out.println("What do you want to do next?? \n" +
                            "1)Add housing data 2)view your housing data 3)exit the program.");
                    scanner = new Scanner(System.in);
                    String choice = scanner.nextLine();
                    if (choice.equals("1")) {
                        House house = new House();
                    String link = "";
                    System.out.print("what is the name of your house: ");
                    house.setHouseName(scanner.nextLine());
                    System.out.print("what is the street of your house: ");
                    house.setStreet(scanner.nextLine());
                    System.out.print("what is the location of your house(does not include the street): ");
                    house.setLocation(scanner.nextLine());

                    System.out.print("is the house for students? answer (y) for yes and (n) for no: ");
                    String answer = scanner.nextLine();
                    house.setIsHouseStudent(answer.equals("y")); //true if answer = y

                    System.out.print("what is the number of floors you have: ");
                    house.setFloors(scanner.nextLine());
                    System.out.print("Type the photo links you want to add, after you put one link press enter \n" +
                            "type (exit) if you are done: ");
                    while (true) {
                        link = scanner.nextLine();
                        house.setPhotosLink(link);
                        if(link.equals("exit")) break;
                        System.out.print("Please enter the next link or type exit to continue: ");
                    }

                    System.out.print("Please enter the available services for your house: ");
                    house.setAvailableServices(scanner.nextLine());
                    System.out.print("Please enter the monthly rent \n& is it inclusive the electricity with water or not: ");
                    house.setPrice(scanner.nextLine());
                    owner.setHouseRequest(house);


                } else if (choice.equals("2")) { //view the housing system for one house only
                    System.out.print("choose which house you want to view: \n");

                    for (int i = 0; i < owner.getHouses().size(); i++) {
                        System.out.println(i + ") " + owner.getHouse(i).getHouseName());
                    }
                    System.out.print("enter the number here: ");
                    int chosenNumber = scanner.nextInt(); //................exception
                    System.out.println("house name:" + owner.getHouse(chosenNumber).getHouseName());
                    System.out.println("location: " + owner.getHouse(chosenNumber).getLocation() + " at street: "
                            + owner.getHouse(chosenNumber).getStreet());

                    System.out.println("number of floors: " + owner.getHouse(chosenNumber).getFloors());
                    for(String s: owner.getHouse(chosenNumber).getPhotosLink()){
                        System.out.println("photo of the house link: "+s); // print all the photos for one house
                    }
                    System.out.println("Monthly rent for each department: " + owner.getHouse(chosenNumber).getPrice());
                    System.out.println("provided services: " + owner.getHouse(chosenNumber).getAvailableServices());
                    System.out.println("Done.");
                }
                else if(choice.equals("3")){
                    break;
                }
                else {
                    System.out.println("please enter valid number (1 or 2)");
                }
            }
            }













           else if (logTypeNum == 3) { // tenant
                Tenant tenant = new Tenant(); //this tenant is used after searching for an existing owner.
                String user1 = "";
                String pass1 = "";
                scanner = new Scanner(System.in);
               boolean equalFlagTenant = false;

                while (!equalFlagTenant) {
                    System.out.print("please enter your username: ");
                    user1 = scanner.nextLine();
                    System.out.print("please enter your password: ");
                    pass1 = scanner.nextLine();


                    for (Tenant t : tenants) {
                        if (t.getPassword().equals(pass1) && t.getUsername().equals(user1)) {
                            equalFlagTenant = true;
                            tenant = t;
                            break;
                        }

                    }

                    if (!equalFlagTenant) {
                        System.out.println("username or password is wrong.");
                    }

                }

                Owner ow = new Owner();
                if (!tenant.isBooked()) {
                    System.out.print("please enter what do you want to do next: \n" +
                            "1)book a house 2) type anything to exit");
                    scanner = new Scanner(System.in);
                    String ans = scanner.nextLine();
                     if (ans.equals("1")) {

                    //what to do after he opens
                    int countOwners = 1;
                    System.out.println("please choose the house you want to book.");
                    System.out.println("here are all the houses");
                    for (Owner o : owners) {
                        for (int i = 0; i < o.getHouses().size(); i++) {
                            System.out.println("owner number: " + countOwners + ") ");
                            System.out.println("owner name: " + o.getName());
                            System.out.println("owner information: " + o.getInformation());
                            System.out.println("house name: " + o.getHouse(i).getHouseName());
                            System.out.println("location: " + o.getHouse(i).getLocation() + " at street: " + o.getHouse(i).getStreet());
                            System.out.println("number of floors: " + o.getHouse(i).getFloors());
                            System.out.println("Monthly rent for each department: " + o.getHouse(i).getPrice());
                            System.out.println("provided services: " + o.getHouse(i).getAvailableServices());
                            if (tenant.isStudent() && o.getHouse(i).isHouseStudent()) {
                                System.out.println("students in this house: ");
                                for (int k = 0; i < o.getHouse(i).getTenantsArrayList().size(); i++) {
                                    System.out.println(i + ") " + "\nname:" + o.getHouse(i).getTenant(k).getName());
                                    System.out.println("major: " + o.getHouse(i).getTenant(k).getMajor());
                                    System.out.println("age: " + o.getHouse(i).getTenant(k).getAge());
                                }
                            }
                            System.out.print("\n\n");
                        }
                        countOwners++;
                    }

                    System.out.print("choose the the owner number of the house you want: ");
                    while (true) {//choosing an owner
                        scanner = new Scanner(System.in);
                        ow = new Owner();
                        int choice = scanner.nextInt(); // exception handling..........................
                        if (choice > owners.size() || choice < 1) {
                            System.out.print("please enter a valid number: ");
                        } else {
                            ow = owners.get(choice - 1);
                            tenant.setOwner(ow);
                            break;
                        }
                    }
                    int flag1 = 0;
                    while (true) {
                        System.out.println("enter the name of the house you want: ");
                        scanner = new Scanner(System.in);

                        String chosenHouseName = scanner.nextLine();
                        for (int i = 0; i < ow.getHouses().size(); i++) {
                            if (ow.getHouse(i).getHouseName().equals(chosenHouseName)) {
                                flag1 = 1;
                                tenant.setBooked(true);
                                tenant.setHouse(ow.getHouse(i));
                                admin.setTenantRequest(tenant);
                                System.out.println("you has booked !!\ndone.");

                            }
                        }
                        if (flag1 == 0) {
                            System.out.println("please enter a valid name: ");
                        } else break;
                    }
                }
            } else if (tenant.isStudent()) {

                        System.out.println("Welcome " + tenant.getName());
                    System.out.print("here are all your info");
                    System.out.println("username: " + tenant.getUsername());
                    System.out.println("information: " + tenant.getInformation());
                    System.out.println("Major: " + tenant.getMajor());
                    System.out.println("age: " + tenant.getAge());
                    System.out.println("house owner name: " + tenant.getOwner().getName());
                    System.out.println("house owner contact information: " + tenant.getOwner().getInformation());
                    System.out.println("house name: " + tenant.getHouse().getHouseName());
                    System.out.println("here are used furniture if you are interested:");
                    for(Owner o:owners) {
                        for (int i = 0; i < o.getHouses().size(); i++) {
                            if (o.getHouse(i).isHouseStudent()) {
                                for (Tenant t : o.getHouse(i).getTenantsArrayList()) {
                                    if(t.isHasFurniture()){
                                    System.out.println(t.getUsedFurniture() + "\nhis information: " + t.getInformation());
                                    }
                                }
                            }
                        }
                    }
                    while (true){
                    System.out.println("what do you want to do next?\n1)press one for advertise your used furniture to sale " +
                            "2) type anything else to exit to main menu ");
                    scanner = new Scanner(System.in);
                    String answer = scanner.nextLine();
                    if (answer.equals("1")) {
                        System.out.println("type what is the furniture and full details about it: ");
                        tenant.setUsedFurniture(scanner.nextLine());
                        tenant.setHasFurniture(true);


                    } else break;
                }

                }

            }








           else if (logTypeNum == 4) { // registration as tenant
                Tenant tenant = new Tenant();
                printRegistration(4,tenant);
                tenants.add(tenant);

            }
           else if (logTypeNum == 5) { // registration as owner
                Owner owner = new Owner();
                printRegistration(5, owner);
                owners.add(owner);
                admin.setOwners(owners);
            }
           else break;
        }

    }
}