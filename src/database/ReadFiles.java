package database;
import java.io.*;
import java.lang.SecurityException;
import date.Date;
import java.util.Scanner;


public class ReadFiles {
    public ReadFiles() {}

    /**
     * Imports every client ou product from .txt file to the corresponding ArrayList
     * 
     * @param fileName - .txt file to import from
     */
    public static DataBaseManager importFromTextFile(Date date) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        
        dataBaseManager = importClientsFromTextFile(dataBaseManager);
        if (dataBaseManager == null) {
            return null;
        }
        
        dataBaseManager = importProductsFromTextFile(dataBaseManager);
        if (dataBaseManager == null) {
            return null;
        }

        return dataBaseManager;
    }

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
     * Imports every client or object from .obj file to the corresponding ArrayList
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


    public static boolean reloadFiles(String objFile) {
        File file = new File(objFile);
        try {
            if (!file.delete()) {
                return false;
            }
            return true;
        }
        catch (SecurityException se) {
            return false;
        }
    }


}
