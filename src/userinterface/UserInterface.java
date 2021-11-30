package userinterface;
import java.util.Scanner;
import database.DataBaseManager;
import database.FormatText;
import client.*;
import date.Date;
import product.*;

public class UserInterface {
    public UserInterface() {}

    public void menu(DataBaseManager dataBaseManager) {
        Client client = new Client();
        Scanner sc = new Scanner(System.in);

        // Date and time options
        System.out.println(FormatText.alignCenterText("1. Enter date manualy"));
        System.out.println(FormatText.alignCenterText("2.   Use local date  "));
        System.out.print("Enter option: ");
        int dateOption = sc.nextInt();
        System.out.println();

        Date date;

        switch (dateOption) {
            case 1 -> {
                System.out.println("Enter date:");
                System.out.print("Day:");
                int day = sc.nextInt();
                System.out.print("Month:");
                int month = sc.nextInt();
                System.out.print("Year:");
                int year = sc.nextInt();
                System.out.println();
                date = new Date(day, month, year);
            }
            case 2 -> {
                date = Date.getLocalDate();
                System.out.println(date);
            }
                
            default -> date = new Date();
        }


        // inventar um nome pra loja
        
        System.out.println("\n");
        FormatText.separationLine();
        System.out.println("\n");
        System.out.println(FormatText.alignCenterText("Welcome to the Online Shopping"));
        System.out.println("\n");
        
        
        // App menus, first the login menu comes up and once the client has entered the shop menu apears
        while(true) {
            
            // Login menu
            while (true) {
                FormatText.separationLine();
                System.out.println("\n");

                int preMenuOption = 0;
                System.out.println(FormatText.alignCenterText("1. Sign in"));
                System.out.println(FormatText.alignCenterText("2. Sing up"));
                System.out.println(FormatText.alignCenterText("3.  Quit  "));

                System.out.println("\n");
                System.out.print("Enter option: ");
                preMenuOption = sc.nextInt();
                System.out.println("\n");
                
                
                if(preMenuOption == 1){
                    sc.nextLine();
                    System.out.println(FormatText.alignCenterText("Please enter you email:"));
                    String email = sc.nextLine();
                    client = dataBaseManager.login(email);
                    sc.nextLine();
                    
                    if (client == null) {
                        System.out.println("Email not found, please create a new acount.");
                        preMenuOption = 0;
                    }  

                    if (client != null) {
                        System.out.println(FormatText.alignCenterText("Login successful!\n"));
                        break;
                    }
                }
                
                if (preMenuOption == 2) {

                    String name; 
                    String address;
                    String email; 
                    int phoneNumber; 
                    Date birthday;
                    
                    sc.nextLine();
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
                    
                    System.out.println("Enter your birthday date:");
                    System.out.print("Day:");
                    int day = sc.nextInt();
                    System.out.print("Month:");
                    int month = sc.nextInt();
                    System.out.print("Year:");
                    int year = sc.nextInt();
                    System.out.println();

                    birthday = new Date(day, month, year);
                    
                    sc.nextLine();


                    client = dataBaseManager.createAccount(name, address, email, phoneNumber, birthday);
                    System.out.println(FormatText.alignCenterText("Account created successfuly!\n"));
                    break;
                }

                if (preMenuOption == 3) {
                    sc.close();
                    return;
                }
            }
            

            // Shop menu
            while (true) {
                int menuOption = 0;
                FormatText.separationLine();
                System.out.println("\n");

                System.out.println(FormatText.alignCenterText("1. View Profile"));
                System.out.println(FormatText.alignCenterText("2.     Shop    "));
                System.out.println(FormatText.alignCenterText("3.   Log out   "));
                System.out.println(FormatText.alignCenterText("4.     Quit    "));
                
                System.out.println("\n");
                System.out.print("Enter option: ");
                menuOption = sc.nextInt();
                System.out.println("\n");

                // 1. View Profile
                if (menuOption == 1) {
                    while (true) {
                        FormatText.separationLine();
                        System.out.println("\n");
    
                        System.out.println(FormatText.alignCenterText("1.    Edit profile     "));
                        System.out.println(FormatText.alignCenterText("2. See purchase history"));
                        System.out.println(FormatText.alignCenterText("2.      Go back        "));
                        
                        int subMenuOption;
                        System.out.println("\n");
                        System.out.print("Enter option: ");
                        subMenuOption = sc.nextInt();
                        System.out.println("\n");
    
                        // 1. Edit profile
                        if (subMenuOption == 1) {
                            FormatText.separationLine();
                            System.out.println("\n");
                            
                            // Shows the client info
                            System.out.println(client);
                            
                            System.out.println(FormatText.alignCenterText("1. Change name"));
                            System.out.println(FormatText.alignCenterText("2. Change address"));
                            System.out.println(FormatText.alignCenterText("3. Change email"));
                            System.out.println(FormatText.alignCenterText("4. Change phoneNumber"));
                            System.out.println(FormatText.alignCenterText("5. Change birthday"));
                            System.out.println(FormatText.alignCenterText("6. Change MBWay pin"));
                            System.out.println(FormatText.alignCenterText("7. Change credit card number"));
                            System.out.println(FormatText.alignCenterText("8. Change credit card expiration date"));
                            System.out.println(FormatText.alignCenterText("9. Change credit card CVV"));
                            
                            int profileOption;
                            System.out.println("\n");
                            System.out.print("Enter option: ");
                            profileOption = sc.nextInt();
                            System.out.println("\n");
    
                            if (profileOption == 1) {
                                sc.nextLine();
                                String newName;
                                System.out.print("Enter new name: ");
                                newName = sc.nextLine();
                                client.setName(newName);
                                System.out.println("\n");
                                sc.nextLine();
                            }
                            
                            if (profileOption == 2) {
                                sc.nextLine();
                                String newAddress;
                                System.out.print("Enter new address: ");
                                newAddress = sc.nextLine();
                                client.setAddress(newAddress);
                                System.out.println("\n");
                                sc.nextLine();
    
                            }
                            
                            if (profileOption == 3) {
                                sc.nextLine();
                                String newEmail;
                                System.out.print("Enter new name: ");
                                newEmail = sc.nextLine();
                                client.setEmail(newEmail);
                                System.out.println("\n");
                                sc.nextLine();
                            }
                            if (profileOption == 4) {
                                int newPhoneNumber;
                                System.out.print("Enter new phone number: ");
                                newPhoneNumber = sc.nextInt();
                                client.setPhoneNumber(newPhoneNumber);
                                System.out.println("\n");
                            }
                            
                            if (profileOption == 5) {
                                System.out.println("Enter new birthday:");
                                System.out.print("Enter day: ");
                                int day = sc.nextInt();
                                System.out.print("\nEnter month: ");
                                int month = sc.nextInt();
                                System.out.print("\nEnter year: ");
                                int year = sc.nextInt();
    
                                Date newBirthday = new Date(day, month, year);
                                
                                client.setBirthday(newBirthday);
                                System.out.println("\n");
                            }
                            
                            if (profileOption == 6) {
                                int pin;
                                System.out.print("Enter new pin: ");
                                pin = sc.nextInt();
                                client.setMbWayPin(pin);
                                System.out.println("\n");
                            }
                            
                            if (profileOption == 7) {
                                int ccNumber;
                                System.out.print("Enter new credit card number: ");
                                ccNumber = sc.nextInt();
                                client.setMbWayPin(ccNumber);
                                System.out.println("\n");
                            }
                            
                            if (profileOption == 8) {
                                System.out.println("Enter new expiration date:");
                                System.out.print("Enter day: ");
                                int day = sc.nextInt();
                                System.out.print("\nEnter month: ");
                                int month = sc.nextInt();
                                System.out.print("\nEnter year: ");
                                int year = sc.nextInt();
        
                                Date newExprirationDate = new Date(day, month, year);
                                
                                client.setExpirationDate(newExprirationDate);
                                System.out.println("\n");
    
                            }
                            
                            if (profileOption == 9) {
                                int cvv;
                                System.out.print("Enter new CVV: ");
                                cvv = sc.nextInt();
                                client.setCreditCardCVV(cvv);
                                System.out.println("\n");
                            }
                        }
    
                        // 2. See purchase history
                        if (subMenuOption == 2) {
                            FormatText.separationLine();
                            System.out.println("\n");
                            
                            client.showPurchaseHistory();
                            
                            FormatText.separationLine();
                            System.out.println("\n");
                        }
    
                        // 3. Go back
                        if (subMenuOption == 3) {
                            break;
                        }
                
                    }

                }
            
                // 2. Shop
                if (menuOption == 2) {
                    while (true) {
                        FormatText.separationLine();
                        System.out.println("\n");
                        
                        System.out.println(FormatText.alignCenterText("1.          Buy           "));
                        System.out.println(FormatText.alignCenterText("2. Show available products"));
                        System.out.println(FormatText.alignCenterText("3.         Go back        "));
                        
                        int subMenuOption;
                        System.out.println("\n");
                        System.out.print("Enter option: ");
                        subMenuOption = sc.nextInt();
                        System.out.println("\n");
                        
                        // 1. Buy
                        if (subMenuOption == 1) {
                            while (true) {
                                FormatText.separationLine();
                                System.out.println();

                                System.out.println(FormatText.alignCenterText("1.   Add to shopping cart  "));
                                System.out.println(FormatText.alignCenterText("2. Remove fromshopping cart"));
                                System.out.println(FormatText.alignCenterText("3.   Clear shopping cart   "));
                                System.out.println(FormatText.alignCenterText("4.    Check out and pay    "));
                                System.out.println(FormatText.alignCenterText("5.         Go back         "));
                                
                                
                                int buyMenuOption;
                                System.out.println("\n");
                                System.out.print("Enter option: ");
                                buyMenuOption = sc.nextInt();
                                System.out.println("\n");
    
                                // Add a product to the shopping cart
                                if (buyMenuOption == 1) {
                                    Product product = new Product();
                                    String productName;
                                    int amount;
                                    sc.nextLine();
                                    System.out.print("Enter the name of the desired product: ");            
                                    productName = sc.nextLine();
                                    sc.nextLine();
                                    System.out.print("Enter the desired amount: ");            
                                    amount = sc.nextInt();
                                    
                                    // Gets the product from the supermarket stock
                                    if((product = dataBaseManager.getProduct(productName)) == null) {
                                        System.out.println("Product out of stock.\nPlease try again.");
                                    }
                                    
                                    // Verifies if there is enough stock for the amount the client wants
                                    if((product = dataBaseManager.getProduct(productName)) != null) {
                                        product = dataBaseManager.verifyStock(product, amount);
                                        client.addToShoppingCart(product, amount);
                                    }
                                    
    
                                }
    
                                // Remove products from the shopping cart
                                if (buyMenuOption == 2) {
                                    Product product = new Product();
                                    String productName;
                                    int amount;
                                    sc.nextLine();
                                    System.out.print("Enter the name of the product you want to remove: ");
                                    productName = sc.nextLine();
                                    sc.nextLine();
                                    System.out.print("Enter the amount you want to remove: ");
                                    amount = sc.nextInt();
    
                                    if((product = client.getProductFromShoppingCart(productName)) == null) {
                                        System.out.println("This product isn´t in your shopping cart.\nPlease try again.");
                                    }
                                    
                                    if((product = client.getProductFromShoppingCart(productName)) != null) {
                                        product = client.verifyStock(product, amount);
                                        client.removeProductFromShoppingCart(product);                                        
                                    }
    
                                }
                                
                                // Clear shopping cart
                                if (buyMenuOption == 5) {
                                    client.clearShoppingCart();
                                }

                                // Checkout and pay the items in the shopping cart
                                if (buyMenuOption == 4) {
                                    Purchase newPurchase = new Purchase();

                                    if (dataBaseManager.createNewPurchase(client, date) != null) {
                                        FormatText.intermidietLine();
                                        System.out.println();
                                        System.out.print("Your total is: " + newPurchase.getPurchasePrice());
                                        while (true) {
                                            System.out.println(FormatText.alignCenterText("Select your desired payment method:"));
                                            System.out.println(FormatText.alignCenterText("1.    MbWay   ")); 
                                            System.out.println(FormatText.alignCenterText("2. Credit Card"));  
                                            int paymentOption= sc.nextInt();
                                            
                                            // If is payment by MBWay
                                            if (paymentOption == 1) {
                                                System.out.print("Phone number: ");
                                                System.out.println();
                                                int phoneNumber = sc.nextInt();
                                                System.out.print("Pin: ");
                                                System.out.println();
                                                int pin = sc.nextInt();

                                                
                                                if (client.acceptMbWayPayment(phoneNumber, pin)) {
                                                    System.out.println(FormatText.alignCenterText("Payment accepted."));
                                                    System.out.println();
                                                    client.addToPurchaseHistory(newPurchase);
                                                    break;
                                                }
                                                else {
                                                    System.out.println(FormatText.alignCenterText("Payment not accepted."));
                                                    System.out.println(FormatText.alignCenterText("1. Try again"));
                                                    System.out.println(FormatText.alignCenterText("2.  Go back "));
                                                    System.out.println();
                                                    System.out.print("\nEnter the option you disire: ");
                                                    int option = sc.nextInt();
                                                    System.out.println();
                                                    if (option == 2) {
                                                        break;
                                                    }
                                                }
                                                
                                            }

                                            // If is payment by credit card
                                            if (paymentOption == 2) {

                                                // Verify credit card information
                                                if (paymentOption == 2) {
                                                    System.out.print("Credit card number: ");
                                                    int ccNumber = sc.nextInt();
                                                    System.out.println();

                                                    System.out.println("Expiration date:");
                                                    System.out.print("Day -> ");
                                                    int day = sc.nextInt();
                                                    System.out.print("\nMonth -> ");
                                                    int month = sc.nextInt();
                                                    System.out.print("\nYear -> ");
                                                    int year = sc.nextInt();
                                                    System.out.println();
                                                    
                                                    Date expirationDate = new Date(day, month, year);
                                                    
                                                    System.out.print("CVV: ");
                                                    int cvv = sc.nextInt();
                                                    System.out.println(); 
                                                    
                                                    if (client.acceptCreditCardPayment(ccNumber, expirationDate, cvv)) {
                                                        System.out.println(FormatText.alignCenterText("Payment accepted."));
                                                        System.out.println();
                                                        client.addToPurchaseHistory(newPurchase);
                                                        break;
                                                    }
                                                    else {
                                                        System.out.println(FormatText.alignCenterText("Payment not accepted."));
                                                        System.out.println(FormatText.alignCenterText("1. Try again"));
                                                        System.out.println(FormatText.alignCenterText("2.  Go back "));
                                                        System.out.println();
                                                        System.out.print("\nEnter the option you disire: ");
                                                        int option = sc.nextInt();
                                                        System.out.println();
                                                        if (option == 2) {
                                                            break;
                                                        }
                                                    }
                                                }    
                                            }
                                        }
                                    
                                        System.out.println(FormatText.alignCenterText("Thank you for choosing us!"));
                                        System.out.println();
                                        client.clearShoppingCart();
                                    }
                                    else {
                                        System.out.println("Error concluding purchase. Please try again.");
                                        System.out.println();
                                    }

                                }

                                // Go back
                                if (buyMenuOption == 5) {
                                    break;
                                }

                            }


                        }
                        
                        // 2. Show available products
                        if (subMenuOption == 2) {
                            FormatText.separationLine();
                            System.out.println("\n");
                            dataBaseManager.showAvailableProducts();
                        }
    
                        // 3. Go Back
                        if (subMenuOption == 3) {
                            break;
                        }

                    }

                }

                // 3. Log out
                if (menuOption == 3) {
                    break;
                }


                // 4. Quit
                if (menuOption == 4) {
                    sc.close();
                    return;
                }
            }

        } 
    }



}   
