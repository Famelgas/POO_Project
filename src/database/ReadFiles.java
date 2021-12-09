package database;
import java.io.*;
import java.util.Scanner;

/**
 * Class ReadFiles - manages all the interactions with files
 */
public class ReadFiles {
    /**
     * Imports every client, product and purhcase from the corresponding .txt files to the corresponding ArrayList
     */
    public static DataBaseManager importFromTextFile() {
        DataBaseManager dataBaseManager = new DataBaseManager();
        
        dataBaseManager = importClientsFromTextFile(dataBaseManager);
        if (dataBaseManager == null) {
            return null;
        }
        
        dataBaseManager = importProductsFromTextFile(dataBaseManager);
        if (dataBaseManager == null) {
            return null;
        }

        dataBaseManager = importPurchasesFromTextFile(dataBaseManager);
        if (dataBaseManager == null) {
            return null;
        }

        return dataBaseManager;
    }

    
    /**
     * Imports every client from the Clients.txt file to clientList 
     * @param dataBaseManager - dataBaseManager
     * @return DataBaseManager - new dataBaseManager with clients
     */
    private static DataBaseManager importClientsFromTextFile(DataBaseManager dataBaseManager) {
        File file = new File("Clients.txt");

        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);
                
                String line = null;
                Scanner lineSc;
                while ((line = buffRead.readLine()) != null) {
                    lineSc = new Scanner(line);
                    if (line.charAt(0) != '#') {
                        dataBaseManager.addToClientList(lineSc);
                    }
                    
                }
                
                buffRead.close();
                
            } 
            catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
                return null;
            } 
            catch (IOException ioe) {
                System.out.println("Error reading specified file");
                return null;
            }
            
            
        } 
        else {
            System.out.println("Error - Products.txt file not found\nPlease try again.");
            return null;
        }
        
        return dataBaseManager;
    }
    
    
    
    
    /**
     * Imports every product from the Products.txt file to productList
     * @param dataBaseManager - dataBaseManager
     * @return DataBaseManager - new dataBaseManager with products
     */
    private static DataBaseManager importProductsFromTextFile(DataBaseManager dataBaseManager) {
        File file = new File("Products.txt");
        
        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);
                
                String line = null;
                Scanner lineSc;
                while ((line = buffRead.readLine()) != null) {
                    lineSc = new Scanner(line);
                    if (line.charAt(0) != '#') {
                        dataBaseManager.addToProductList(lineSc);
                    }
                    
                }
                
                buffRead.close();

            } 
            catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
                return null;
            } 
            catch (IOException ioe) {
                System.out.println("Error reading specified file");
                return null;
            }


        } 
        else {
            System.out.println("Error - Products.txt file not found\nPlease try again.");
            return null;
        }

        return dataBaseManager;
    }


    
    /**
     * Imports every purhcase from the Purchases.txt file to the purhcaseList ArrayList
     * @param dataBaseManager
     * @return DataBaseManager
     */
    public static DataBaseManager importPurchasesFromTextFile(DataBaseManager dataBaseManager) {
        File file = new File("Purchases.txt");

        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);

                String line = null;
                Scanner lineSc;
                while ((line = buffRead.readLine()) != null) {
                    lineSc = new Scanner(line);
                    if (line.charAt(0) != '#') {
                        dataBaseManager.addToPurchaseList(lineSc);
                    }

                }

                buffRead.close();

            } catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
                return null;
            } catch (IOException ioe) {
                System.out.println("Error reading specified file");
                return null;
            }

        } else {
            System.out.println("Error - Purchases.txt file not found\nPlease try again.");
            return null;
        }

        return dataBaseManager;
    }


    /**
     * Imports every client, product and purchase from data.obj file to the corresponding ArrayList
     * 
     * @param fileName - .obj file to import from
     */
    public static DataBaseManager importFromObjectFile(DataBaseManager dataBaseManager, String fileName) {
        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            try {
                FileInputStream inputStream = new FileInputStream(file);
                ObjectInputStream objectInputStream = new ObjectInputStream(inputStream);

                try {
                    dataBaseManager = (DataBaseManager) objectInputStream.readObject();
                } catch (ClassNotFoundException cnf) {
                    System.out.println("Error reading client list from .obj file");
                }

                objectInputStream.close();
                return dataBaseManager;

            } catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
                return null;
            } catch (IOException ioe) {
                System.out.println("Error reading specified file");
                return null;
            }
        }

        else {
            return null;
        }
    }

    /**
     * Writes every client and product in the corresponding .obj files. If a file
     * doesn't exist creates a new one
     * 
     * @param clientFileName  - .obj client file
     * @param productFileName - .obj product file
     */
    public static boolean exportToObjectFile(DataBaseManager dataBaseManager, String fileName) {
        // Write every client in the ArrayList in the Clients.obj file
        File clientFile = new File(fileName);

        try {
            clientFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error creating new .obj file");
            return false;
        }

        if (clientFile.exists() && clientFile.isFile()) {
            try {
                FileOutputStream outputStream = new FileOutputStream(fileName, true);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(dataBaseManager);
                objectOutputStream.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
                return false;
            } catch (IOException ioe) {
                System.out.println("Error writing specified file");
                return false;
            }
        }
        return true;
    }

}
