import database.DataBaseManager;
import database.ReadFiles;
import userinterface.UserInterface;



// !!!!!!!!!!!!!!
// Perguntar a prof se temos que ler sempre o ficheiro de texto dos produtos pra podermos
// adicionar manualmente mais produtos ao stock do supermercado ou se fazemos uma funçao 
// para o utilizador poder adicionar manualmente produtos ao stock, o que nao faz sentido
// !!!!!!!!!!!!!!





public class Main {
    public static void main(String[] args) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        UserInterface ui = new UserInterface();


        
        
        // fazer parte da leitura dos ficheiros 
        // verificar se existe um .obj file, se houver ler esse se nao ler o .txt file
        String objFile = "database.obj";
        
        // If there is no .obj file then the program has to read the clients and products from .txt files
        // Every time we close the program a .obj file is updated or created if there isn´t one, so the only
        // time the program is going to read a .txt file is the first time it's oppened 



    
        // If any produdcts were added to the supermarket stock (Products.txt) the program need to 
        // reload files 
        // boolean reload - false: no reload; true: reload files
        boolean reloadTextFiles = false;
        if (reloadTextFiles) {
            if (ReadFiles.importFromTextFile() == null) {
                System.out.println("Error importing from text file");
                return;
            }
            else {
                dataBaseManager = ReadFiles.importFromTextFile();
                if (!ReadFiles.reloadFiles(objFile)) {
                    System.out.println("Error deleting .obj file");
                }
            }
            reloadTextFiles = false;
        }
        else {
            if (ReadFiles.importFromObjectFile(dataBaseManager, objFile) == null) {
                if (ReadFiles.importFromTextFile() == null) {
                    System.out.println("Error importing from text file");
                    return;
                }
                else {
                    dataBaseManager = ReadFiles.importFromTextFile();
                }
            } 
    
            else {
                dataBaseManager = ReadFiles.importFromObjectFile(dataBaseManager, objFile);
            }
        }



        
        ui.menu(dataBaseManager);

        
        if (!ReadFiles.exportToObjectFile(dataBaseManager, objFile)) {
            System.out.println("Error exporting to object file");
        }

        else {
            return;
        }
        
    }   
}
