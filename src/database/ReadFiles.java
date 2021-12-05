package database;
import java.io.*;
import java.lang.SecurityException;
import date.Date;


public class ReadFiles {
    public ReadFiles() {}

    /**
     * Imports every client ou product from .txt file to the corresponding ArrayList
     * 
     * @param fileName - .txt file to import from
     */
    public static DataBaseManager importFromTextFile(Date date) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        
        if (importClientsFromTextFile(dataBaseManager, date) == null) {
            return null;
        }
        else {
            dataBaseManager = importClientsFromTextFile(dataBaseManager, date);
        }

        if (importProductsFromTextFile(dataBaseManager, date) == null) {
            return null;
        }
        else {
            dataBaseManager = importProductsFromTextFile(dataBaseManager, date);
        }

        return dataBaseManager;
    }

    private static DataBaseManager importClientsFromTextFile(DataBaseManager dataBaseManager, Date date) {
        String fileName = "Clients.txt";
        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);
                
                String line = null;
                while ((line = buffRead.readLine()) != null) {
                    if (line.charAt(0) != '#') {
                        dataBaseManager.addToClientList(line, date);
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
    
    
    
    private static DataBaseManager importProductsFromTextFile(DataBaseManager dataBaseManager, Date date) {
        String fileName = "Products.txt";
        File file = new File(fileName);
        
        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);
                
                String line = null;
                while ((line = buffRead.readLine()) != null) {
                    if (line.charAt(0) != '#') {
                        dataBaseManager.addToProductList(line, date);
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
            System.out.println("File doesn't exist");
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
