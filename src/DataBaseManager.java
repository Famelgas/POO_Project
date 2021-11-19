import java.io.*;
import java.util.ArrayList;
import java.lang.String;
import java.lang.NumberFormatException;
import client.*;
import product.*;
import sale.*;

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
                BufferedReader buffRead = new BufferReader(fileRead);
                
                String line;
                while ((line = buffRead.readLine()) != null) {
                    // If it's the clients file then every line is a client so 
                    // we can add a new client to de ArrayList for every line
                    if (fileName == "Clients.txt") {
                        Client newClient = new Client();
                        separateClientInfo(newClient, line);
                        clientList.add(newClient);
                    }
                    if (fileName == "Products.txt") {
                        Product newProduct = new Product();
                        separateProductInfo(newProduct, line);
                        productList.add(newProduct);
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
            System.out.prinln("File doesn't exist");
        }
    }
  
    private void addClient() {}

    private void addProduct() {}


    // Separates the string so we can create a new client
    public static void separateClientInfo(Client newClient, String line) {
        String[] clientAtributes = {"name", "address", "email", "phoneNumber", "birthday", "frequent"};
        int atrib = 0;
        String words = "";
        for (int i = 0; j < line.length(); ++i) {
            if (line.charAt(i) == "/" || line.charAt(i) == "\n") {
                if (clientAtributes[atrib].equals("name")) {
                    setName(words);
                }
                if (clientAtributes[atrib].equals("address")) {
                    setAddress(words);
                }
                if (clientAtributes[atrib].equals("email")) {
                    setEmail(words);
                }
                if (clientAtributes[atrib].equals("phoneNumber")) {
                    int phNum;
                    try {
                       phNum = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                       phNum = -1;
                    }
                    setPhoneNumber(phNum);
                }
                if (clientAtributes[atrib].equals("birthday")) {
                    Date date = convertToDate(words);
                    setDate(date);
                }
                if (clientAtributes[atrib].equals("frequent")){
                    if (words.equals("true")) {
                        setFrequent(true);
                    }
                    else if (words.equals(false)) {
                        setFrequent(false);
                    }
                } 
                
                atrib++; 
                words = "";
            }

            else {
                words += line.charAt(i);
            }
        } 

    }

    // Separates the string so we can create a new product
    private static void separateProductInfo(Product newProduct, String line) {}
}
