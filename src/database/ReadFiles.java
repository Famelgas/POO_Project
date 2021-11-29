package database;
import java.io.*;
import java.util.Scanner;


public class ReadFiles {
    public ReadFiles() {}

    /**
     * Imports every client ou product from .txt file to the corresponding ArrayList
     * 
     * @param fileName - .txt file to import from
     */
    public static DataBaseManager importFromTextFile(Scanner sc) {
        DataBaseManager dataBaseManager = new DataBaseManager();
        
        if (importClientsFromTextFile(dataBaseManager, sc) == null) {
            return null;
        }
        else {
            dataBaseManager = importClientsFromTextFile(dataBaseManager, sc);
        }

        if (importProductsFromTextFile(dataBaseManager, sc) == null) {
            return null;
        }
        else {
            dataBaseManager = importProductsFromTextFile(dataBaseManager, sc);
        }

        return dataBaseManager;
    }

    private static DataBaseManager importClientsFromTextFile(DataBaseManager dataBaseManager, Scanner sc) {
        String fileName = "src/Clients.txt";
        File file = new File(fileName);

        while (true) {
            if (file.exists() && file.isFile()) {
                try {
                    FileReader fileRead = new FileReader(file);
                    BufferedReader buffRead = new BufferedReader(fileRead);
                    
                    String line = null;
                    while ((line = buffRead.readLine()) != null) {
                        // If it's the clients file then every line is a client so
                        // we can add a new client to de ArrayList for every line
                        dataBaseManager.addToClientList(line);
                        
                        
                    }
                    
                    buffRead.close();
                    break;
                    
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
                int option = 0; 
                System.out.println("Error - Client.txt file not found, please enter a valid Client file");
                System.out.println("Do you want to open another file?\n1. Enter new file\n2. Quit");
                option = sc.nextInt();
                if (option == 1) {
                    sc.nextLine();
                    System.out.print("Please enter the file name:");
                    fileName = sc.nextLine();
                    sc.nextLine();
                    option = 0;
                }
                
                if (option == 2) {
                    return null;
                }
            }
        }


        return dataBaseManager;
    }
    


    private static DataBaseManager importProductsFromTextFile(DataBaseManager dataBaseManager, Scanner sc) {
        String fileName = "src/Products.txt";
        File file = new File(fileName);

        while (true) {
            if (file.exists() && file.isFile()) {
                try {
                    FileReader fileRead = new FileReader(file);
                    BufferedReader buffRead = new BufferedReader(fileRead);
                    
                    String line = null;
                    while ((line = buffRead.readLine()) != null) {
                        // If it's the clients file then every line is a client so
                        // we can add a new client to de ArrayList for every line
                        dataBaseManager.addToProductList(line);
                        
                    }
    
                    buffRead.close();
                    break;
    
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
                int option = 0; 
                System.out.println("Error - Products.txt file not found, please enter a valid Product file");
                System.out.println("Do you want to open another file?\n1. Enter new file\n2. Quit");
                option = sc.nextInt();
                if (option == 1) {
                    sc.nextLine();
                    System.out.print("Please enter the file name:");
                    fileName = sc.nextLine();
                    sc.nextLine();
                    option = 0;
                }
                
                if (option == 2) {
                    return null;
                }   
            }
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

                if (fileName.equals("Clients.obj")) {
                    try {
                        dataBaseManager = (DataBaseManager) objectInputStream.readObject();
                    } catch (ClassNotFoundException cnf) {
                        System.out.println("Error reading client list from .obj file");
                    }
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
    public static void exportToObjectFile(DataBaseManager dataBaseManager, String fileName) {
        // Write every client in the ArrayList in the Clients.obj file
        File clientFile = new File(fileName);

        try {
            clientFile.createNewFile();
        } catch (IOException ioe) {
            System.out.println("Error creating new .obj file");
        }

        if (clientFile.exists() && clientFile.isFile()) {
            try {
                FileOutputStream outputStream = new FileOutputStream(fileName, true);
                ObjectOutputStream objectOutputStream = new ObjectOutputStream(outputStream);
                objectOutputStream.writeObject(dataBaseManager);
                objectOutputStream.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
            } catch (IOException ioe) {
                System.out.println("Error writing specified file");
            }
        }
    }

}
