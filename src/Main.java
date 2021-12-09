import database.DataBaseManager;
import database.ReadFiles;
import userinterface.UserInterface;
import date.Date;
import database.FormatText;


// !!!!!!!!!!!!!!
// Perguntar a prof se temos que ler sempre o ficheiro de texto dos produtos pra podermos
// adicionar manualmente mais produtos ao stock do supermercado ou se fazemos uma funçao 
// para o utilizador poder adicionar manualmente produtos ao stock, o que nao faz sentido
// !!!!!!!!!!!!!!





public class Main {
    
    /** 
     * @param args
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

        
        ui.menu(dataBaseManager, date);

        
        if (!ReadFiles.exportToObjectFile(dataBaseManager, objFile)) {
            System.out.println("Error exporting to object file");
        }

        else {
            return;
        }
        
    }   
}
