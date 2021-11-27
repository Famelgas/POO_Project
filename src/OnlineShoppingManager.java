import java.util.Scanner;
import database.DataBaseManager;
import database.FormatText;
import database.ReadFiles;
import client.Client;
import date.Date;
import product.*;

public class OnlineShoppingManager {
    public static void main(String[] args) {
        Client client = new Client();
        DataBaseManager dataBaseManager = new DataBaseManager();
        ReadFiles readFiles = new ReadFiles();
        FormatText formatText = new FormatText();


        
        
        // fazer parte da leitura dos ficheiros 
        // verificar se existe um .obj file, se houver ler esse se nao ler o .txt file
        String objFile = "database.obj";
        
        // If there is no .obj file then the program has to read the clients and products from .txt files
        // Every time we close the program a .obj file is updated or created if there isn´t one, so the only
        // time the program is going to read a .txt file is the first time it's oppened 
        if ((dataBaseManager = readFiles.importFromObjectFile(dataBaseManager, objFile)) == null) {
            String clientsFile = "Clients.txt";
            String productsFile = "Products.txt";
            Scanner sc = new Scanner(System.in);
            
            // Verify if the Clients.txt file exists, if it doesn´t asks the user for another file
            while ((dataBaseManager = readFiles.importFromTextFile(dataBaseManager, clientsFile)) == null) {
                int option = 0; 
                System.out.println(formatText.alignCenterText("Error - Client.txt file not found, please enter a valid Client file."));
                System.out.println("Do you want to open another file?\n1. Enter new file\nQuit");
                option = sc.nextInt();
                if (option == 1) {
                    sc.nextLine();
                    System.out.print("Please enter the file name:");
                    clientsFile = sc.nextLine();
                    sc.nextLine();
                    option = 0;
                }
                
                if (option == 2) {
                    sc.close();
                    return;
                }
            }
            
            // Verify if the Products.txt file exists, if it doesn´t asks the user for another file
            while ((dataBaseManager = readFiles.importFromTextFile(dataBaseManager, productsFile)) == null) {
                int option = 0;
                System.out.println(formatText.alignCenterText("Error - Products.txt file not found, please enter a valid Client file."));
                System.out.println("Do you want to open another file?\n1. Enter new file\nQuit");
                option = sc.nextInt();
                if (option == 1) {
                    sc.nextLine();
                    System.out.print("Please enter the file name:");
                    clientsFile = sc.nextLine();
                    sc.nextLine();
                    option = 0;
                }
                
                if (option == 2) {
                    sc.close();
                    return;
                }
            }

            sc.close();
        } 


        
        // inventar um nome pra loja
        
        System.out.println(formatText.alignCenterText("Welcome to the Online Shopping"));
        System.out.println("\n");
        Scanner sc = new Scanner(System.in);
        
        
        // App menus, first the login menu comes up and once the client has entered the shop menu apears
        while(true) {
            
            // Login menu
            while (true) {
                formatText.separationLine();
                System.out.println("\n");

                int preMenuOption = 0;
                System.out.println(formatText.alignCenterText("1. Sign in"));
                System.out.println(formatText.alignCenterText("2. Sing up"));
                System.out.println(formatText.alignCenterText("3.  Quit"));

                System.out.println("\n");
                System.out.print("Enter option you desire: ");
                preMenuOption = sc.nextInt();
                System.out.println("\n");
                
                
                if(preMenuOption == 1){
                    sc.nextLine();
                    System.out.println(formatText.alignCenterText("Please enter you email:"));
                    String email = sc.nextLine();
                    client = dataBaseManager.login(email);
                    sc.nextLine();
                    
                    if (client == null) {
                        System.out.println("Email not found, please create a new acount.");
                        preMenuOption = 0;
                    }  

                    if (client != null) {
                        System.out.println(formatText.alignCenterText("Login successful!\n"));
                        break;
                    }
                }
                
                if (preMenuOption == 2) {
                    client = dataBaseManager.createAccount();
                    System.out.println(formatText.alignCenterText("Account created successfuly!\n"));
                    break;
                }

                if (preMenuOption == 3) {
                    sc.close();
                    readFiles.exportToObjectFile(dataBaseManager, objFile);
                    return;
                }
            }
            

            // Shop menu
            while (true) {
                int menuOption = 0;
                formatText.separationLine();
                System.out.println("\n");

                System.out.println(formatText.alignCenterText("1. View Profile"));
                System.out.println(formatText.alignCenterText("2.     Shop    "));
                System.out.println(formatText.alignCenterText("3.   Log out   "));
                System.out.println(formatText.alignCenterText("4.     Quit    "));
                
                System.out.println("\n");
                System.out.print("Enter option you desire: ");
                menuOption = sc.nextInt();
                System.out.println("\n");

                // 1. View Profile
                if (menuOption == 1) {
                    while (true) {
                        formatText.separationLine();
                        System.out.println("\n");
    
                        System.out.println(formatText.alignCenterText("1.    Edit profile     "));
                        System.out.println(formatText.alignCenterText("2. See purchase history"));
                        System.out.println(formatText.alignCenterText("2.      Go back        "));
                        
                        int subMenuOption;
                        System.out.println("\n");
                        System.out.print("Enter option you desire: ");
                        subMenuOption = sc.nextInt();
                        System.out.println("\n");
    
                        // 1. Edit profile
                        if (subMenuOption == 1) {
                            formatText.separationLine();
                            System.out.println("\n");
                            
                            // Shows the client info
                            System.out.println(client);
                            
                            System.out.println(formatText.alignCenterText("1. Change name"));
                            System.out.println(formatText.alignCenterText("2. Change address"));
                            System.out.println(formatText.alignCenterText("3. Change email"));
                            System.out.println(formatText.alignCenterText("4. Change phoneNumber"));
                            System.out.println(formatText.alignCenterText("5. Change birthday"));
                            System.out.println(formatText.alignCenterText("6. Change MBWay pin"));
                            System.out.println(formatText.alignCenterText("7. Change credit card number"));
                            System.out.println(formatText.alignCenterText("8. Change credit card expiration date"));
                            System.out.println(formatText.alignCenterText("9. Change credit card CVV"));
                            
                            int profileOption;
                            System.out.println("\n");
                            System.out.print("Enter option you desire: ");
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
    
                                Date newDate = new Date(day, month, year);
                                
                                client.setBirthday(newDate);
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
        
                                Date newDate = new Date(day, month, year);
                                
                                client.setExpirationDate(newDate);
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
                            formatText.separationLine();
                            System.out.println("\n");
                            
                            client.showPurchaseHistory();
                            
                            formatText.separationLine();
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
                        formatText.separationLine();
                        System.out.println("\n");
                        
                        System.out.println(formatText.alignCenterText("1.          Buy           "));
                        System.out.println(formatText.alignCenterText("2. Show available products"));
                        System.out.println(formatText.alignCenterText("3.         Go back        "));
                        
                        int subMenuOption;
                        System.out.println("\n");
                        System.out.print("Enter option you desire: ");
                        subMenuOption = sc.nextInt();
                        System.out.println("\n");
                        
                        // 1. Buy
                        if (subMenuOption == 1) {
                            while (true) {
                                formatText.separationLine();
                                System.out.println();

                                System.out.println(formatText.alignCenterText("1.   Add to shopping cart  "));
                                System.out.println(formatText.alignCenterText("2. Remove fromshopping cart"));
                                System.out.println(formatText.alignCenterText("3.   Clear shopping cart   "));
                                System.out.println(formatText.alignCenterText("4.    Check out and pay    "));
                                System.out.println(formatText.alignCenterText("5.         Go back         "));
                                
                                
                                int buyMenuOption;
                                System.out.println("\n");
                                System.out.print("Enter option you desire: ");
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
                                    if (!dataBaseManager.buyProducts(client)) {
                                        System.out.println("Error concluding purchase. Please try again.");
                                        System.out.println();
                                    }
                                    else {
                                        System.out.println(formatText.alignCenterText("Thank you for choosing us!"));
                                        System.out.println();
                                        client.clearShoppingCart();
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
                            formatText.separationLine();
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
                    readFiles.exportToObjectFile(dataBaseManager, objFile);
                    return;
                }
            }

        }     

        // no fim do programa escrever sempre tudo no ficheiro de novo antes do programa terminar

    }   
}