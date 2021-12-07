package database;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Scanner;
import client.*;
import product.*;
import date.Date;
import promotion.*;

/**
 * Manages data related to files, clients and products from the supermarket
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
    
    public ArrayList<Client> getClientList() {
        return clientList;
    }
    
    public void setClientList(ArrayList<Client> clientList) {
        this.clientList = clientList;
    }    

    public ArrayList<Product> getProductList() {
        return productList;
    }
    
    public void setProductList(ArrayList<Product> productList) {
        this.productList = productList;
    }    

    public ArrayList<Purchase> getPurchaseList() {
        return purchaseList;
    }
    
    public void setPurchaseList(ArrayList<Purchase> purchaseList) {
        this.purchaseList = purchaseList;
    }    

    /**
     * Adds a new client account to the shop's database
     * @param line - Line read from the .txt file
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
     * @param line - Line read from the .txt file
     */
    public void addToProductList(Scanner lineSc) {
        Product newProduct = Product.getProductType(lineSc);
        newProduct = newProduct.separateProductInfo(lineSc);
        if (newProduct == null) {
            System.out.println("Error product object is null");
        }
        productList.add(newProduct);
    }

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
     * Creates a new client and adds the client to the clientList where it can be 
     * managed or written into an object file
     */
    public Client createAccount(String name, String address, String email, int phoneNumber, Date birthday) {
        Client newClient = new Client(name, address, email, phoneNumber, birthday, false);
        clientList.add(newClient);
        
        return newClient;
    }

    public void showAllClients() {
        for (Client client: this.clientList) {
            System.out.println();
            System.out.println(client);
            System.out.println();
            FormatText.intermidietLine();
        }
    }
    


    /** --------------------------------------Product associated---------------------------------------------- */
    


    /**
     * Buy a product from the online strore
     * @param client - client buying the product
     * @return - returns true if the purchase is succesful 
     *           returns false if theres is a problem
     */
    public Purchase createNewPurchase(Client client, Date date) {
        ArrayList<Product> shoppingCart = client.getShoppingCart();
        Purchase newPurchase = new Purchase(date);
        
        newPurchase.setPurchaseReference(Purchase.createReference());

        // Serching through the client's shopping cart
        for (Product productToBuy : shoppingCart) {
            // Serching through the store's stock 
            for (Product productInStock : productList) {
                if (productToBuy.getIdentifier() == productInStock.getIdentifier()) {
                    Promotion promotion = productToBuy.getPromotion();
                    float productsPrice = 0;
                    // If there is more items in stock then what the client wants to buy
                    if ((productInStock.getStock() - productToBuy.getStock()) > 0) {
                        productsPrice = promotion.priceCalculator(productToBuy);
                        productInStock.setStock(productInStock.getStock() - productToBuy.getStock());                    
                    }
                    
                    // If the client wants to buy all the items ore more then what the supermarket has
                    // then the product in stock is removed
                    if ((productInStock.getStock() - productToBuy.getStock()) <= 0) {
                        productToBuy.setStock(productInStock.getStock());
                        productsPrice = promotion.priceCalculator(productToBuy);
                        productList.remove(productInStock);
                    }
                    
                    newPurchase.addToPurchasedProducts(productToBuy);          
                    newPurchase.raisePurchasePrice(productsPrice);
                }
                
                else {
                    System.out.println("Product out of stock.");
                    return null;
                }
                
            } 
            
        }

        newPurchase.setTotalPrice(newPurchase.getPurchasePrice(), newPurchase.calculateShippingPrice(client, newPurchase));
    
        return newPurchase;
    }


    public Product getProduct(String productName) {
        for (Product product : productList) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public Product verifyStock(Product product, int amount) {
        for (Product productInStock : productList) {
            if (product.getIdentifier() == productInStock.getIdentifier()) {
                // If the client wants to add to the cart more items then what the supermarket has
                // then he can only buy the existing stock
                if ((productInStock.getStock() - product.getStock()) < 0) {
                    System.out.println("There are only " + productInStock.getStock() + " " + productInStock.getName() + " in stock, so only " + productInStock.getStock() + " were added to your shopping cart.");
                    product.setStock(productInStock.getStock());
                }
            }
        }
        return product;
    }


    public void showAvailableProducts() {
        for (Product product : productList) {
            System.out.println();
            System.out.println(product);
            System.out.println();
            FormatText.intermidietLine();
        }
    }


}   
