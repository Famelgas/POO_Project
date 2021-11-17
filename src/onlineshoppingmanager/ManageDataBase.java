package onlineshoppingmanager;
import java.util.ArrayList; 

public class ManageDataBase {
    // Imported client list from text file
    ArrayList<Client> clientList;
    // Imported supermarket protuct stock form text file 
    ArrayList<Product> productList;

    public ManageDataBase() {
       clientList = new ArrayList<>();
       productList = new ArrayList<>(); 
    }
    
    // Import all the data from the text file to the corresponding ArrayLists
    public void importFromTextFile() {}
    
}
