import java.io.*;
import java.util.ArrayList;
import java.lang.String;
import java.lang.NumberFormatException;
import java.lang.Character;
import client.Client;
import date.Date;
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
                
                String line;
                while ((line = buffRead.readLine()) != null) {
                    // If it's the clients file then every line is a client so 
                    // we can add a new client to de ArrayList for every line
                    if (fileName == "Clients.txt") {
                        clientList.add(separateClientInfo(line));
                    }
                    if (fileName == "Products.txt") {
                        productList.add(separateProductInfo(line));
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
  


    // Separates the string so we can create a new client
    public static Client separateClientInfo(String line) {
        Client newClient = new Client();
        String[] clientAtributes = {"name", "address", "email", "phoneNumber", "birthday", "frequent"};
        int atrib = 0;
        String words = "";

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
                if (clientAtributes[atrib].equals("name")) {
                    newClient.setName(words);
                }
                if (clientAtributes[atrib].equals("address")) {
                    newClient.setAddress(words);
                }
                if (clientAtributes[atrib].equals("email")) {
                    newClient.setEmail(words);
                }
                if (clientAtributes[atrib].equals("phoneNumber")) {
                    int phNum;
                    try {
                        phNum = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        phNum = -1;
                    }
                    newClient.setPhoneNumber(phNum);
                }
                if (clientAtributes[atrib].equals("birthday")) {
                    Date date = convertToDate(words);
                    newClient.setBirthday(date);
                }
                if (clientAtributes[atrib].equals("frequent")){
                    if (words.equals("true")) {
                        newClient.setFrequent(true);
                    }
                    else if (words.equals("false")) {
                        newClient.setFrequent(false);
                    }
                } 
                
                ++atrib; 
                words = "";
            }

            else {
                words += line.charAt(i);
            }
        } 
        
        return newClient;
    }

    // Separates the string so we can create a new product
    private static Product separateProductInfo(String line) {
        String[] productType = {"cleaning" , "food", "furniture"};
        String words = "";
        int type = 0;

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
                if (productType[type].equals("cleaning")) {
                    return separateCleaningInfo(line);                    
                }    
                if (productType[type].equals("food")) {
                    return separateFoodInfo(line);
                }
                if (productType[type].equals("furniture")) {
                    return separateFurnitureInfo(line);
                }
            }

            else {
                words += line.charAt(i);
            }
        }

        return new Product();
    }

    private static Cleaning separateCleaningInfo(String line) {
        Cleaning newProduct = new Cleaning();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "promotion", "toxicityLevel"};
        String words = "";
        int atrib = 0;
        
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
                if (atributes[atrib].equals("identifier")) {
                    int ident;
                    try {
                        ident = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        ident = -1;
                    }
                    newProduct.setIdentifier(ident);
                }
                if (atributes[atrib].equals("name")) {
                    newProduct.setName(words);
                }
                if (atributes[atrib].equals("unitPrice")) {
                    int price;
                    try {
                        price = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        price = -1;
                    }
                    newProduct.setUnitPrice(price);
                }
                if (atributes[atrib].equals("stoc")) {
                    int stock;
                    try {
                        stock = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        stock = -1;
                    }
                    newProduct.setStock(stock);
                }
                if (atributes[atrib].equals("promotion")) {
                    newProduct.setPromotion(words);
                }
                if (atributes[atrib].equals("toxicityLevel")) {
                    int level;
                    try {
                       level = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                       level = -1;
                    }
                    newProduct.setToxicityLevel(level);
                }
                
                ++atrib; 
                words = "";
            }

            else {
                words += line.charAt(i);
            }
        }

        return newProduct;
    }

    private static Food separateFoodInfo(String line) {
        Food newProduct = new Food();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "promotion", "caloriesPer100G", "fatPercent"};

        return newProduct;
    }

    private static Furniture separateFurnitureInfo(String line) {
        Furniture newProduct = new Furniture();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "promotion", "height", "width", "depth", "wight"};

        return newProduct;
    }




    private static Date convertToDate(String strDate) {
        Date date = new Date();
        String numStr = "";
        int atrib = 1;        

        for (int i = 0; i < strDate.length(); ++i) {
            if (!Character.isDigit(strDate.charAt(i))) {
                date.setDateAtributes(numStr, atrib);
                ++atrib;
            }
            if (i + 1 == strDate.length()) {
                numStr += strDate.charAt(i);
                date.setDateAtributes(numStr, atrib);
            }
            numStr += strDate.charAt(i);
        }

        return date;
    }


}
