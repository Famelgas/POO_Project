import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import client.Client;
import product.*;
import date.Date;

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
    
    /**
     * Imports every client ou product from .txt file to the corresponding ArrayList
     * @param fileName - .txt file to import from
     */
    public void importFromTextFile(String fileName) {
        File file = new File(fileName);
        
        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);
                
                String line = "";
                if (fileName.equals("Clients.txt")) {
                    while ((line = buffRead.readLine()) != null) {
                        // If it's the clients file then every line is a client so 
                        // we can add a new client to de ArrayList for every line
                        clientList.add(Client.separateClientInfo(line));
                    }
                }
                if (fileName.equals("Products.txt")) {
                    while ((line = buffRead.readLine()) != null) {
                        // If it's the clients file then every line is a client so 
                        // we can add a new client to de ArrayList for every line
                        productList.add(Product.separateProductInfo(line));
                    }
                }

                
                buffRead.close();
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
            }
            catch (IOException ioe) {
                System.out.println("Error reading specified file");
            }
        }
        else {
            System.out.println("File doesn't exist");
        }
    }
    
    /**
     * Imports every client or object from .obj file to the corresponding ArrayList
     * @param fileName - .obj file to import from
     */
    public void importFromObjectFile(String fileName) {
        File file = new File(fileName);
        
        if (file.exists() && file.isFile()) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);
                
                if (fileName.equals("Clients.obj")) {
                    Client newClient = (Client) objectInputStream.readObject();
                    clientList.add(newClient);
                }
                if (fileName.equals("Products.obj")) {
                    Product newProduct = (Product) objectInputStream.readObject();
                    productList.add(newProduct);
                
                }
                objectInputStream.close();  
            } 
            catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
            }
            catch (IOException ioe) {
                System.out.println("Error reading specified file");
            }
            catch (ClassNotFoundException cnf) {
                System.out.println("Error - class not found");
            }
        }
    
        else {
            System.out.println("File doesn't exist");
        }

    }

    /**
     * Writes every client and product in the corresponding .obj files. If a file doesn't exist
     * creates a new one
     * @param clientFileName - .obj client file 
     * @param productFileName - .obj product file
     */
    public void exportToObjectFile(String clientFileName, String productFileName) {
        // Write every client in the ArrayList in the Clients.obj file
        File clientFile = new File(clientFileName);

        try {
            clientFile.createNewFile();       
        }
        catch (IOException ioe) {
            System.out.println("Error creating new .obj file");
        }

        if (clientFile.exists() && clientFile.isFile()) {
            try {
                FileOutputStream outputStream = new FileOutputStream(clientFile, true);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                for (Client client: clientList) {
                    objectOutputStream.writeObject(client);
                } 
                objectOutputStream.close();
            }
            catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
            }
            catch (IOException ioe) {
                System.out.println("Error writing specified file");
            }
        }


        // Write every product in the ArrayList in the Products.obj file
        File productFile = new File(productFileName);

        try {
            productFile.createNewFile();       
        }
        catch (IOException ioe) {
            System.out.println("Error creating new .obj file");
        }

        try {
            FileOutputStream outputStream = new FileOutputStream(productFile, true);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
            for (Product product: productList) {
                objectOutputStream.writeObject(product);
            } 
            objectOutputStream.close();
        }
        catch (FileNotFoundException fnf) {
            System.out.println("Error opening specified file");
        }
        catch (IOException ioe) {
            System.out.println("Error writing specified file");
        }
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
        
        birthday = Date.convertToDate(strDate);
        
        sc.close();

        Client newClient = new Client(name, address, email, phoneNumber, birthday, false);
        clientList.add(newClient); 
    }

    public void buyProduct(Client client) {
        ArrayList<Product>

        for (Product product : productList) {
            if (product.getName.equals(productName)) {

            }
        }
    }

}
