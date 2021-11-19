import java.util.Scanner;
import client.*;
import product.*;
import sale.*;

public class OnlineShoppingManager {
    public static void main(String[] args) {
        int num = 0;
        int flag = 0;
        while(flag  == 0){
            System.out.println("choose one of the following options by selecting a number: ");
            System.out.println("1. Login");
            System.out.println("2. Make a purchase");
            System.out.println("3. Consult purchases made");
            System.out.print("Your option: ");
            Scanner sc = new Scanner(System.in);
            num = sc.nextInt();
    
            if(num != 1 && num != 2 && num != 3){
                System.out.println("Please, enter a valid option.");
            }
            else{
                flag = 1;
            }
        }  
        
        if(num == 1){   //onde vamos permitir realizar o login
                


        }

        if(num == 2){  //onde vamos permitir fazer uma compra



        }

        if(num == 3){  //onde vamos permitir consultar as compras realizadas



        }
    }   
}
