import java.util.ArrayList; 

public class DataBaseManager {
    // Imported client list from text file
    ArrayList<Client> clientList;
    // Imported supermarket protuct stock form text file 
    ArrayList<Product> productList;

    public ManageDataBase() {
       clientList = new ArrayList<>();
       productList = new ArrayList<>(); 
    }
    
    // Import all the data from the text file to the corresponding ArrayLists
    public static void importFromTextFile(String fileName) {
        File file = new File(fileName);
        
        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferReader(fileRead);
                
                String line;
                while ((line = buffRead.readLine) != null) {
                    if (fileName == "Clients.txt") {
                        insertInClientList(line);
                    }
                    if (fileName == "Products.txt") {
                        intserInProductList(line);
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
   
    private static void insertInClientList(String line) {
        
    }
    
    private static void insertInProductList(String line) {

    }
}
