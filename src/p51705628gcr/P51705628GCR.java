/*
 * Raghad Zohair,  ID 1705628, section number  GCR .
 * EMAIL  ryahya0010@stu.kau.edu.sa
 * Program 5: Customer Management System.  Sunday December 17, 2017
 */
package p51705628gcr;

import java.util.Scanner;

/**
 *
 * @author Raghad
 */
public class P51705628GCR {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("-------------------------------------------------------------------");
        System.out.println("      ------ Welcome to the Customer Management System ------      ");
        System.out.println("-------------------------------------------------------------------");
        System.out.print("> Please enter the registration year (ex: 2017): ");
        int year = input.nextInt();
        System.out.println();
        System.out.print("> How many customers do you want to register in year  "+year+" : ");
        int customer = input.nextInt();
        System.out.println();
        
        //declear var 
        int[] id = new int[customer];
        String[] fname = new String[customer];
        String[] lname = new String[customer];
        double[] totalPurchase = new double[customer];
        int[] yearCustomer =new int[customer];
        double[] ageCustomer = new double[customer];
        String[] genderCustomer = new String[customer];
        String[] cityCustomer = new String[customer]; 
        // count number of customers in the system
        int customerCount = 0 ;
        
        while(true){
            displayMainMenu();
            String choice = input.next();
            inputAndCheck(choice);
            System.out.println();
            // enter the data of customer if the user choice  'a'
            if(choice.equalsIgnoreCase("a")){
                // inc. 1 if user inter the data of customer
                customerCount++;
                int posion = customerCount - 1;
                System.out.println();
                System.out.print(" > Enter customer ID: ");
                id[posion] = input.nextInt();
                System.out.print(" > Enter customer first name: ");
                fname[posion] = input.next();
                System.out.print(" > Enter customer last name:  ");
                lname[posion] = input.next();
                totalPurchase[posion] = readTotalPurchase(0);
                yearCustomer[posion] = readRegisterYear (0);
                ageCustomer[posion] =readCustomerAge(0);
                genderCustomer[posion]= readCustomerGender("");
                cityCustomer[posion] = readCustomerCity("");
                System.out.println("*****************************");
                System.out.println(" > "+fname[posion]+" "+lname[posion]+" (ID #"+id[posion]+") has been added to the system.");
                System.out.println();
                continue;
            }
            // the program search about the customer if user choice 'd'
            if(choice.equalsIgnoreCase("d")){
                while(true){
                    System.out.println(" > Enter 1 to search/display customer by ID number");
                    System.out.println(" > Enter 2 to search/display customer by name");
                    System.out.println(" > Enter 0 to return to the Main Menu");
                    System.out.println();
                    System.out.print(" > Enter choice: ");
                    int choice2 = input.nextInt();
                    input.nextLine();
                    System.out.println();
                    if ( !(choice2 == 1 || choice2 == 2 || choice2 == 0) ){
                        System.out.println("Invalid selection! Please try again");
                        System.out.println();
                        continue;
                    }
                    // if user choice 1 the program search about customer by ID
                    if(choice2 == 1){
                        while(true){
                            System.out.print(" > Enter customer id: ");
                            int customerId = input.nextInt(); 
                            System.out.println(" > Customer  Details:");
                            System.out.println();
                            int posionId = search (id , customerId, customerCount);
                            if(posionId == -1){
                                System.out.println("Sorry! ID customer #"+customerId+" Not found in the system");
                                System.out.println();
                                continue;
                            }
                            displayCustomerInformation(id[posionId], fname[posionId], lname[posionId], totalPurchase[posionId], 
                                yearCustomer[posionId], ageCustomer[posionId], genderCustomer[posionId], cityCustomer[posionId] );                           
                            System.out.println();    
                            break;
                        }
                    }
                    // if user choice 2 the program search about the customer by first and last name
                    if(choice2 == 2){
                        while(true){
                            System.out.print(" > Enter customer first name: ");
                            String fnameCustomer = input.nextLine();
                            System.out.print(" > Enter customer last name:  ");
                            String lnameCustomer = input.nextLine();
                            System.out.println(" > Customer  Details:");
                            System.out.println();
                            int posionName = search(fname, lname, fnameCustomer, lnameCustomer, customerCount);
                            if(posionName == -1){
                                System.out.println("Sorry! Name customer: "+fnameCustomer+" "+lnameCustomer+". Not found in the system");
                                System.out.println();
                                continue;
                            }
                            displayCustomerInformation(id[posionName], fname[posionName], lname[posionName], totalPurchase[posionName], 
                                yearCustomer[posionName], ageCustomer[posionName], genderCustomer[posionName], cityCustomer[posionName] );
                            System.out.println();
                            break;
                        }
                    }
                    // if user choice 0 the program back to main menu
                    if(choice2 == 0){
                        break;
                    }
                }
            }
            // The program ends if user choice 'e'
            if(choice.equalsIgnoreCase("e")){
                System.out.println(" > Thank you for using the Customers Management System!");
                System.out.println();
                System.out.println(" > Good Bye.");
                System.out.println();
                System.exit(0);
            }
        }
    }
    // for displayMainMenu
    public static void displayMainMenu(){
        System.out.println("-------------------------------------------------------------------");
        System.out.println("-------              Customer Management System             -------");
        System.out.println("-------                     *MAIN MENU*                     -------");
        System.out.println("-------------------------------------------------------------------");
        System.out.println(" | A/a: Enter A or a for Adding a Customer                       | ");
        System.out.println(" | D/d: Enter D or d for Printing Customer Details               | ");
        System.out.println(" | E/e: Enter E or e for Exiting the Program                     | ");
        System.out.println("-------------------------------------------------------------------");
        System.out.println();
        System.out.print(" > Please enter your choice: ");
    }
    // check if choice correct from main menu
    public static char inputAndCheck(String choice){ 
        while(true){
            if( !(choice.equalsIgnoreCase("a") || choice.equalsIgnoreCase("d") || choice.equalsIgnoreCase("e")) ){
                System.out.println(">Invalid selection! Please try again.");
                System.out.println();
            }
            char ch = choice.charAt(0);       
            return ch;  
        }    
    }
    // for take the age of customer from user
    public static double readCustomerAge(double  age ){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print(" > Enter the age of customer:  ");
            age = input.nextDouble();
            // check if the age includes the range
            if(age<15 || age>90){
                System.out.println();
                System.out.println(" >    Invalid input! (age must be between 15 and 90)");
                System.out.println(" >    Please try again.");
                System.out.println();
                continue;
            }
          return age;  
        }
    }
    // for take the Total Purchase of customer from user
    public static double readTotalPurchase(double purchase){
        Scanner input = new Scanner(System.in);
        System.out.print(" > Enter the customer total number of purchases:  ");
        purchase = input.nextDouble();
        return purchase;
    }
    // for take the Register Year of customer from user
    public static int readRegisterYear (int yearCus){
        Scanner input = new Scanner(System.in);
        System.out.print(" > Enter the customer regisrtation year: ");
        yearCus = input.nextInt();
        return yearCus;
    } 
    // for take the Gender of customer from user
    public static String readCustomerGender (String gender){
        Scanner input = new Scanner(System.in);
        while(true){
            System.out.print(" > Enter the  gender of customer: ");
            gender = input.nextLine();
            // check if user enter male or femal
            if(! (gender.equalsIgnoreCase("female") || gender.equalsIgnoreCase("male")) ){
                System.out.println();
                System.out.println(" >    Invalid input! (gender must be male or female)");
                System.out.println(" >    Please try again");
                System.out.println();
                continue;
            }
            return gender;
        }
        
    }
    // for take the City of customer from user
    public static String readCustomerCity (String city){
        Scanner input = new Scanner(System.in);
        System.out.print(" > Enter the city of customer: ");
        city = input.nextLine();
        return city ;
    }
    // search about the customer by ID
    public static int search (int[] id, int customerId, int customerCount){ 
        // initialized posion Id
        int posion = 0 ;
        // check the id posion by length of id for customer
        for(int check = 0; check<id.length; check++){
            if(id[check] == customerId){
                posion = check ;
                break;
            }
            else
                posion = -1;
        }
        return posion ;
    }
    // search about the customer by first and last name
    public static int search (String[] fname, String[] lname, String fristName, String lastName, int customerCount){
        // initialized posionId
        int posion = 0;
        // check the first and last name posion by length of name for customer
        for(int i = 0; i<fname.length && i<lname.length; i++){
            if(fname[i].equalsIgnoreCase(fristName)) {
                    if(lname[i].equalsIgnoreCase(lastName)){
                        posion = i; 
                        break;
                    }
            }
            else
                posion = -1;
        }
        return posion ; 
    }
    // display Customer Information
    public static void displayCustomerInformation(int id, String fname, String lname, double tpur, int ryear, 
            double age, String gender, String city){
        System.out.println(" > ID	     Name		  "+
                "Number of Purchases	  Registration Year 	  Age"
                +" 	  Gender	  City");
        System.out.println(" > -----------------------------------------"+
                "-----------------------------------------------------------------------");
        System.out.println("  "+id+"     "+fname+" "+lname+"		  "+tpur+"	               "+ryear+"	          "+
                age+"	    "+gender+"	  "+city);
        
    }
}
