import java.io.*;
import java.util.ArrayList;
import client.Client;
import product.*;

public class DataBaseManager {
    // Imported client list from text file
    private ArrayList<Client> clientList;
    // Imported supermarket protuct stock form text file 
    private ArrayList<Product> productList;

    public DataBaseManager() {
       clientList = new ArrayList<>();
       productList = new ArrayList<>(); 
    }
    
    // Import all the data from the text file to the corresponding ArrayLists
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
            } catch (ClassNotFoundException cnf) {
                System.out.println("Error - class not found");
            }
        }
    
        else {
            System.out.println("File doesn't exist");
        }

    }

    public void exportToObjectFile() {
        
    }

}
