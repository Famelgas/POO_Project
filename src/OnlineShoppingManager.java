import java.sql.DatabaseMetaData;
import java.util.Scanner;
import database.DataBaseManager;
import client.Client;

public class OnlineShoppingManager {
    public static void main(String[] args) {
        int num = 0;
        int flag = 0;
        Client client = new Client();
        DataBaseManager dataBaseManager = new DataBaseManager();
        while(true) {
            while (flag == 0) {
                System.out.println("        Object-Oriented Programming SuperMarket");
                System.out.println("X------------------------------------------------------X");
                System.out.println("                      1. Login");
                System.out.println("                2. Create new account");
                System.out.println("X------------------------------------------------------X");
                System.out.print("Your option: ");
                Scanner sc = new Scanner(System.in);
                num = sc.nextInt();
                if(num != 1 && num != 2){
                    System.out.println();
                    System.out.println("              Please, enter a valid option.");
                    System.out.println();
                }
            }
            
            if(num == 1){   //login
                
                
                
                

            }
     
            if(num == 2){  //create a new account
                if(createAccount() == true){
                    client = dataBaseManager.createAccount();
                }



            }
        }     
    }   
}