import database.DataBaseManager;
import database.ReadFiles;
import userinterface.FormatText;
import userinterface.UserInterface;
import date.Date;


/**
 * Class Main - runs the application a manages when the files are read or written
 * and the date to use when the app is ran
 */
public class Main {
    
    /** 
     * Main method()
     * @param args - no arguments
     */
    public static void main(String[] args) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        UserInterface ui = new UserInterface();

        Date date = ui.getAppDate();
        
        
        // fazer parte da leitura dos ficheiros 
        // verificar se existe um .obj file, se houver ler esse se nao ler o .txt file
        String objFile = "database.obj";
        
        // If there is no .obj file then the program has to read the clients and products from .txt files
        // Every time we close the program a .obj file is updated or created if there isn´t one, so the only
        // time the program is going to read a .txt file is the first time it's oppened 



    
       
        dataBaseManager = ReadFiles.importFromObjectFile(dataBaseManager, objFile);
        if (dataBaseManager == null) {
            dataBaseManager = ReadFiles.importFromTextFile();
            if (dataBaseManager== null) {
                System.out.println("Error importing from text file");
                return;
            }
        } 


        FormatText.separationLine();
        System.out.println("\n");
        
        //dataBaseManager.showAllClients();
        //FormatText.separationLine();
        
        dataBaseManager.showAvailableProducts();
        FormatText.separationLine();
        
        //dataBaseManager.showAllPurchases();
        //FormatText.separationLine();

        
        ui.menu(dataBaseManager, date, objFile);

        
        if (!ReadFiles.exportToObjectFile(dataBaseManager, objFile)) {
            System.out.println("Error exporting to object file");
        }

        else {
            return;
        }
        
    }   
}
