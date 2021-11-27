import java.sql.DatabaseMetaData;
import java.text.Format;
import java.util.Scanner;
import database.DataBaseManager;
import database.FormatText;
import database.ReadFiles;
import client.Client;
import date.Date;

public class OnlineShoppingManager {
    public static void main(String[] args) {
        Client client = new Client();
        DataBaseManager dataBaseManager = new DataBaseManager();
        ReadFiles readFiles = new ReadFiles();
        FormatText formatText = new FormatText();


        
        
        // fazer parte da leitura dos ficheiros 
        // verificar se existe um .obj file, se houver ler esse se nao ler o .txt file
        int fileOption = 0;
        String objFile = "database.obj";
        
        if ((dataBaseManager = readFiles.importFromObjectFile(dataBaseManager, objFile)) == null) {
            int option = 0; 
            String clientsFile = "Clients.txt";
            String productsFile = "Products.txt";
            Scanner sc = new Scanner(System.in);
            while (option == 0) {
                if ((dataBaseManager = readFiles.importFromTextFile(dataBaseManager, clientsFile)) == null) {
                    System.out.println(formatText.alignCenterText("No Client.txt file found, please enter a valid Client file."));
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
                
                if ((dataBaseManager = readFiles.importFromTextFile(dataBaseManager, productsFile)) == null) {
                    System.out.println(formatText.alignCenterText("No Products.txt file found, please enter a valid Client file."));
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
            }
            sc.close();
        } 


        
        // inventar um nome pra loja
        
        System.out.println(formatText.alignCenterText("Welcome to the Online Shopping"));
        System.out.println("\n");
        formatText.separationLine();
        Scanner sc = new Scanner(System.in);
        

        // App menus, first the login menu comes up and once the client has entered the shop menu apears
        while(true) {
            
            // Login menu
            while (true) {
                int preMenuOption = 0;
                System.out.println("\n");
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
                System.out.println(formatText.alignCenterText("3.     Quit    "));
                
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
    
                            client.showProfile();
                            
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
    
                        System.out.println(formatText.alignCenterText("1.         Buy            "));
                        System.out.println(formatText.alignCenterText("2. Show available products"));
                        
                        int subMenuOption;
                        System.out.println("\n");
                        System.out.print("Enter option you desire: ");
                        subMenuOption = sc.nextInt();
                        System.out.println("\n");
    
                        // 1. Buy
                        if (subMenuOption == 1) {
    
                        }
    
                        // 2. Show available products
                        if (subMenuOption == 2) {
    
                        }
    
                        // 3. Go Back
                        if (subMenuOption == 2) {
                            break;
                        }

                    }

                }

                // 3. Quit
                if (menuOption == 3) {
                    sc.close();
                    readFiles.exportToObjectFile(dataBaseManager, objFile);
                    return;
                }
            }

        }     

        // no fim do programa escrever sempre tudo no ficheiro de novo antes do programa terminar

    }   
}
