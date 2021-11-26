package database;
import java.util.ArrayList;
import java.util.Scanner;
import client.Client;
import client.Purchase;
import product.*;
import date.Date;
import promotion.*;

/**
 * Manages data related to files, clients and products from the supermarket
 */
public class DataBaseManager {
    // Imported client list from text file
    private ArrayList<Client> clientList;
    // Imported supermarket protuct stock form text file 
    private ArrayList<Product> productList;

    public DataBaseManager() {
       clientList = new ArrayList<>();
       productList = new ArrayList<>(); 
    }

    public void addToClientList(String line) {
        clientList.add(Client.separateClientInfo(line));
    }
    
    public void addToProductList(String line) {
        productList.add(Product.separateProductInfo(line));
    }
    
    /**
     * Creates a new client and adds the client to the clientList where it can be 
     * managed or written into an object file
     */
    public void createAccount() {
        Scanner sc = new Scanner(System.in);        
        String name; 
        String address;
        String email; 
        int phoneNumber; 
        String strDate;
        Date birthday;

        System.out.print("Enter your name:");
        name = sc.nextLine();
        System.out.println();
        
        System.out.print("Enter your address:");
        address = sc.nextLine();
        System.out.println();

        System.out.print("Enter your email:");
        email = sc.nextLine();
        System.out.println();
        
        System.out.print("Enter your phone number:");
        phoneNumber = sc.nextInt();
        System.out.println();
     
        System.out.print("Enter your birthday date:");
        strDate = sc.nextLine();
        System.out.println();
        
        birthday = Date.convertStringToDate(strDate);
        
        sc.close();

        Client newClient = new Client(name, address, email, phoneNumber, birthday, false);
        clientList.add(newClient); 
    }

    /**
     * Buy a product from the online strore
     * @param client - client buying the product
     * @return - returns true if the purchase is succesful 
     *           returns false if theres is a problem
     */
    public boolean buyProduct(Client client) {
        ArrayList<Product> shoppingCart = client.getShoppingCart();
        Date date = new Date();
        date = date.getUsersDate();
        Purchase newPurchase = new Purchase(date);

        // Serching through the client's shopping cart
        for (Product productToBuy : shoppingCart) {
            // Serching through the store's stock 
            for (Product productInStock : productList) {
                if (productToBuy.getIdentifier() == productInStock.getIdentifier()) {
                    Promotion promotion = productToBuy.getPromotion();
                    float productsPrice = 0;
                    // If there is more items in stock then what the client wants to buy
                    if ((productInStock.getStock() - productToBuy.getStock()) >= 0) {
                        productsPrice = promotion.priceCalculator(productToBuy);
                        productInStock.setStock(productInStock.getStock() - productToBuy.getStock());
                        
                        
                    }
                    // If the client wants to buy more items then what the supermarket has 
                    // then he can only buy the existing stock
                    if ((productInStock.getStock() - productToBuy.getStock()) < 0) {
                        productToBuy.setStock(productInStock.getStock());
                        productsPrice = promotion.priceCalculator(productToBuy);
                        productList.remove(productInStock);
                    }

                    newPurchase.addToPurchasedProducts(productToBuy);          
                    newPurchase.raisePurchasePrice(productsPrice);
                }
                
                else {
                    System.out.println("Product out of stock.");
                }

            } 
            
        }



        System.out.println("Your total is: " + newPurchase.getPurchasePrice());
        int option = 1;
        while (option == 1) {
            if (client.acceptPayment()) {
                System.out.println("Payment accepted!\nThank you for choosing us!");
                client.addToPurchaseHistory(newPurchase);
                return true;
            }
            else {
                Scanner sc = new Scanner(System.in);
                System.out.println("Payment not accepted.");
                System.out.println("Enter the option you desire:");
                System.out.println("Try again: 1\n" + "Go back: 2");
                option = sc.nextInt();
                sc.close();
                if (option == 2) {
                    return false;
                }
            }

        }
        return true;
    }

}
