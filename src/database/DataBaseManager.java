package database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import client.*;
import product.*;
import date.Date;
import promotion.*;

/**
 * Class DataBaseManager - manages data related to files, clients and products from the supermarket
 */
public class DataBaseManager implements Serializable {
    // Imported client list from text file
    private ArrayList<Client> clientList;
    // Imported supermarket protuct stock form text file 
    private ArrayList<Product> productList;
    
    private ArrayList<Purchase> purchaseList;

    
    /**
     * DataBaseManager constuctor
     */
    public DataBaseManager() {
       clientList = new ArrayList<>();
       productList = new ArrayList<>(); 
       purchaseList = new ArrayList<>();
    }
    
    
    /**
     * Client list getter 
     * @return - return clientList
     */
    public ArrayList<Client> getClientList() {
        return clientList;
    }
    
    
    /** 
     * Client list setter
     * @param clientList - clientList to be set
     */
    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }    

    
    /** 
     * Products list getter
     * @return - returns productList
     */
    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    
    /** 
     * Product list setter
     * @param productList - productList to be set
     */
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }    

    
    /** 
     * Purchase list getter
     * @return returns purchaseList
     */
    public ArrayList<Purchase> getPurchaseList() {
        return purchaseList;
    }
    
    
    /** 
     * Purchase list setter
     * @param purchaseList - purchaseList to be set
     */
    public void setPurchaseList(ArrayList<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }    

    /**
     * Adds a new client account to the shop's database
     * @param lineSc - Line read from the .txt file
     */
    public void addToClientList(Scanner lineSc) {
        Client client = new Client();
        client = client.separateClientInfo(lineSc);
        if (client == null) {
            System.out.println("Error client object is null");
        }   
        clientList.add(client);
    }

    /**
     * Adds a new Product to the shop's stock 
     * @param lineSc - Line read from the .txt file
     */
    public void addToProductList(Scanner lineSc) {
        Product newProduct = Product.getProductType(lineSc);
        newProduct = newProduct.separateProductInfo(lineSc);
        if (newProduct == null) {
            System.out.println("Error product object is null");
        }
        productList.add(newProduct);
    }
    
    
    /**
     * Adds a new Purhcase to the shop's stock
     * 
     * @param lineSc - Line read from the .txt file
     */
    public void addToPurchaseList(Scanner lineSc) {
        Purchase newPurchase = new Purchase();
        newPurchase = newPurchase.separatePurchaseInfo(lineSc);
        if (newPurchase == null) {
            System.out.println("Error product object is null");
        }
        purchaseList.add(newPurchase);

    }

    
    /**
     * Adds a given purchase to the shop's stock 
     * @param purchase - pruchase to be added
     */
    public void addPurchase(Purchase purchase) {
        purchaseList.add(purchase);
    }




    /** -----------------------------------------Class Methods------------------------------------------------- */ 


    /** ---------------------------------------Client associated----------------------------------------------- */
    
    /**
     * Allows a client to login into the online shop, if the client 
     * doesn´t have an account yet returns null
     * @param email - client's email
     * @return - returns the client, if found, if not returns null
     */
    public Client login(String email) {
        for (Client client : this.clientList) {
            if (client.getEmail().equals(email)) {
                return client;
            }
        }
        return null;
    }

     /**
      * 
      * Creates a new client and adds the client to the clientList where it can be
      * managed or written into an object file
      * 
      * @param name - name 
      * @param address - address
      * @param email - email 
      * @param phoneNumber - phone number
      * @param birthday - birthday date
      * @return - null if email isn't valid or if there was an error
      */
    public Client createAccount(String name, String address, String email, int phoneNumber, Date birthday) {
        Client newClient;
        if (!verifyEmail(email)) {
            newClient = null;
        }

        else {
            newClient = new Client(name, address, email, phoneNumber, birthday, false);
            clientList.add(newClient);
        }
        
        return newClient;
    }

    /**
     * Shows all the clients int the database
     */
    public void showAllClients() {
        int count = 0;
        for (Client client: clientList) {
            System.out.println("\n");
            System.out.println(client);
            System.out.println();

            if (count < clientList.size() - 1) {
                FormatText.intermidietLine();
            }
            ++count;
        }
    }

    /**
     * Verifies if the email has as '@' and at least one '.' and not in the fist charecter
     * @param email - email to verify
     * @return - true if email is valid and false if it's not valid
     */
    private static boolean verifyEmail(String email) {
        if (email.charAt(0) == '@' || email.charAt(0) == '.') {
            return false;
        }
        int at = 0;
        int dot = 0;
        for (int i = 0; i < email.length(); ++i) {
            if (email.charAt(i) == '@') {
                ++at;
            }
            if (email.charAt(i) == '.') {
                ++dot;
            }
        }
        if (at != 1 || dot < 1) {
            return false;
        }
        
        return true;
    }
    


    /** --------------------------------------Product associated---------------------------------------------- */
    
    
    
    
    /**
     * Gets a product from the productList
     * @param productName - productName
     * @return - null if there is no product with the given name
     */
    public Product getProduct(String productName) {
        Product newProduct;
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                newProduct = product;
                return newProduct;
            }
        }
        return null;
    }
    
    
    /**
     * Shows all available products
     */
    public void showAvailableProducts() {
        int count = 0;
        for (Product product : productList) {
            System.out.println();
            System.out.println(product);
            System.out.println();

            if (count < productList.size() - 1) {
                FormatText.intermidietLine();
            }
            ++count;
        }
    }


    /**
     * Verifies that the shop has enough stock from the client to add the products to his shopping cart
     * @param product - product the client wants
     * @param amount - amount the client wants
     * @return Product - null if there isn't enough stock 
     */
    public Product verifyShopStock(Product product, int amount) {
        System.out.println(product.getStock());
        for (Product productInStock : getProductList()) {
            if (product.getIdentifier() == productInStock.getIdentifier()) {
                if (productInStock.getStock() == 0) {
                    System.out.println("Product out of stock.");
                    return null;
                }

                if (amount > productInStock.getStock()) {
                    System.out.println("Not enough stock. Please try again.");
                    return null;
                }
            }
        }
        product.setAmountToBuy(amount);

        return product;
    }
    

    
    
    /** --------------------------------------Purchase associated---------------------------------------------- */



    
    /**
     * Creates a new purchase
     * @param client - client buying the product
     * @param date - date
     * @return - true if the purchase is succesful false if theres is a problem
     */
    public Purchase createNewPurchase(Client client, Date date) {
        Purchase newPurchase = new Purchase(date);
        
        newPurchase.setPurchaseReference(Purchase.createReference());
        float purchasePrice = 0;

        // Serching through the client's shopping cart
        for (Product productToBuy : client.getShoppingCart()) {
            // Serching through the store's stock 
            for (Product productInStock : productList) {
                if (productToBuy.getIdentifier() == productInStock.getIdentifier()) {
                    Promotion promotion = productToBuy.getPromotion();
                    
                    purchasePrice +=  promotion.priceCalculator(productToBuy);
                    
                    newPurchase.addToPurchasedProducts(productToBuy);          
                    newPurchase.raisePurchasePrice(purchasePrice);
                }
                
            }
            
        }
        
        newPurchase.setPurchasePrice(purchasePrice);

        newPurchase.setTotalPrice(newPurchase.getPurchasePrice(), newPurchase.calculateShippingPrice(client, newPurchase));
    
        return newPurchase;
    }

    /**
     * Shows every purchase in the database
     */
    public void showAllPurchases() {
        int count = 0;
        for (Purchase purchase : purchaseList) {
            System.out.println("\n");
            System.out.println(purchase);
            System.out.println();

            if (count < purchaseList.size() - 1) {
                FormatText.intermidietLine();
            }
            ++count;
        }
    }


    
    /** 
     * Lowers the shop's stock the amount bought by the client
     * @param client - client who made the purchase
     */
    public void resetStock(Client client) {
        for (Product productInStock : productList) {
            for (Product productToBuy : client.getShoppingCart()) {
                if (productInStock.getIdentifier() == productToBuy.getIdentifier()) {
                    productInStock.setStock(productInStock.getStock() - productToBuy.getAmountToBuy());
                }
            }
        }
    }


}   
