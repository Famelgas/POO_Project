package database;
import java.io.*;

public class ReadFiles {
    /**
     * Imports every client ou product from .txt file to the corresponding ArrayList
     * 
     * @param fileName - .txt file to import from
     */
    public void importFromTextFile(DataBaseManager dataBaseManager, String fileName) {
        File file = new File(fileName);

        if (file.exists() && file.isFile()) {
            try {
                FileReader fileRead = new FileReader(file);
                BufferedReader buffRead = new BufferedReader(fileRead);
                
                String line = "";
                if (fileName.equals("Clients.txt")) {
                    while ((line = buffRead.readLine()) != null) {
                        // If it's the clients file then every line is a client so
                        // we can add a new client to de ArrayList for every line
                        dataBaseManager.addToClientList(line);
                        
                        
                    }
                }
                if (fileName.equals("Products.txt")) {
                    while ((line = buffRead.readLine()) != null) {
                        // If it's the clients file then every line is a client so
                        // we can add a new client to de ArrayList for every line
                        dataBaseManager.addToProductList(line);
                        
                    }
                }

                buffRead.close();
            } catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
            } catch (IOException ioe) {
                System.out.println("Error reading specified file");
            }
        } else {
            System.out.println("File doesn't exist");
        }
    }

    /**
     * Imports every client or object from .obj file to the corresponding ArrayList
     * 
     * @param fileName - .obj file to import from
     */
    public DataBaseManager importFromObjectFile(String fileName, DataBaseManager dataBaseManager) {
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
            } catch (FileNotFoundException fnf) {
                System.out.println("Error opening specified file");
            } catch (IOException ioe) {
                System.out.println("Error reading specified file");
            }
        }

        else {
            System.out.println("File doesn't exist");
        }

        return dataBaseManager;
    }

    /**
     * Writes every client and product in the corresponding .obj files. If a file
     * doesn't exist creates a new one
     * 
     * @param clientFileName  - .obj client file
     * @param productFileName - .obj product file
     */
    public void exportToObjectFile(String fileName, DataBaseManager dataBaseManager) {
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
