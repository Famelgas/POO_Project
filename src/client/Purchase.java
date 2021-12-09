package client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import product.*;
import date.Date;

/**
 * Class Purchase - manages the method associated with making a purchase
 */
public class Purchase implements Serializable {
    private Date date;
    private int reference;
    private float purchasePrice;
    private int shippingPrice;
    private float totalPrice;
    private ArrayList<Product> purchasedProducts;

    /**
     * Purchases's constructor
     */
    public Purchase() {
        this.purchasedProducts = new ArrayList<>();
    }
    
    /**
     * Purchases's constructor
     * 
     * @param date - date
     */
    public Purchase(Date date) {
        this.purchasedProducts = new ArrayList<>();
        this.date = date;
    }  

    
    /**
     * Purchase date getter 
     * @return Date - returns purhcaseDate
     */
    public Date getPurchaseDate() {
        return date;
    }

    
    /** 
     * Purhcase date setter
     * @param date - purhcaseDate to be set
     */
    public void setPurchaseDate(Date date) {
        this.date = date;
    }

    
    /** 
     * Purchase reference getter
     * @return int - reference
     */
    public int getPurchaseReference() {
        return reference;
    }

    
    /** 
     * Purchase reference setter
     * @param reference - reference to be set
     */
    public void setPurchaseReference(int reference) {
        this.reference = reference;
    }

    
    /**
     * Purchase price getter 
     * @return float - returns purchasePrice
     */
    public float getPurchasePrice() {
        return purchasePrice;
    }


    /**
     * Puchase price setter 
     * @param purchasePrice - purchasePrice to be set
     */
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
   
    }
    

    /**
     * Shipping price getter 
     * @return float - returns shippingPrice
     */
    public float getShippingPrice() {
        return shippingPrice;
    }

    
    /** 
     * Shipping price setter
     * @param shippingPrice - shippingPrice to be set
     */
    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }
   
    
    /** 
     * Total price getter
     * @return float - returns totalPrice
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    
    /** 
     * Total Price getter
     * @param purchasePrice - purchasePrice 
     * @param shippingPrice - shippingPrice
     * @return float - returns totalPrice
     */
    public float getTotalPrice(float purchasePrice, int shippingPrice) {
        return purchasePrice + shippingPrice;
    }

    
    /** 
     * Total price setter
     * @param purchasePrice - purchasePrice
     * @param shippingPrice - shippingPrice
     */
    public void setTotalPrice(float purchasePrice, int shippingPrice) {
        this.totalPrice = purchasePrice + shippingPrice;
    }

    
    /** 
     * Total price setter
     * @param totalPrice - totalPrice to be set
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    /** 
     * Purhcased products getter
     * @return - returns purhcasedProducts
     */
    public ArrayList<Product> getPurchadeProducts() {
        return purchasedProducts;
    }

    
    /** 
     * Purchased products setter
     * @param purchasedProducts - purchasedProducts to be set
     */
    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    
    /** 
     * Add product to purchasedProducts
     * @param product - product to be added
     */
    public void addToPurchasedProducts(Product product) {
        purchasedProducts.add(product);
    }

    
    /** 
     * Raise purchase price
     * @param priceToRaise - amount to raise
     */
    public void raisePurchasePrice(float priceToRaise) {
        this.purchasePrice += priceToRaise;
    }

    
    /** 
     * Override String.toString()
     * @return String - converted string
     */
    public String toString() {
        return "Date: " + date + "\nReference: " + reference + "\nPurchase price: " + purchasePrice + "\nShipping price: " + shippingPrice + "\nTotal price: " + totalPrice + "\nPurchased roducts:\n" + purchasedProducts.toString().substring(1, purchasedProducts.toString().length() - 1);
    }

    /**
     * Separates purchase information for a client given by a .txt file
     * @param lineSc - purchase information
     * @return - returns a new Purchase;
     */
    public Purchase separatePurchaseInfo(Scanner lineSc) {
        Purchase purchase = new Purchase();
        lineSc.useDelimiter("\\s*:\\s*");

        purchase.setPurchaseDate(Date.convertStringToDate(lineSc.next()));
        purchase.setPurchaseReference(lineSc.nextInt());
        purchase.setPurchasePrice(lineSc.nextFloat());
        purchase.setShippingPrice(lineSc.nextInt());
        purchase.setTotalPrice(lineSc.nextFloat());

        while(lineSc.hasNext()) {
            Scanner tempLineSc = new Scanner(lineSc.next());
            Product newProduct = Product.getProductType(tempLineSc);
            newProduct = newProduct.separateProductInfo(tempLineSc);
            if (newProduct == null) {
                System.out.println("Error product object is null");
            }
            purchase.addToPurchasedProducts(newProduct);
            tempLineSc.close();
        }
        
        return purchase;
    }
 

    
    /** 
     * Creates a new purchase reference
     * @return int - reference: 8 digit int
     */
    public static int createReference() {
        Random rand = new Random();
        int ref = 10000000 + rand.nextInt(999999999);
        return ref;
    }


    
    /** 
     * Calculates the shipping price
     * @param client - client making the purchase
     * @param purchase - purchase being made
     * @return int - shippingPrice
     */
    public int calculateShippingPrice(Client client, Purchase purchase) {
        int shippingPrice = 0;

        if (client.getFrequent()) {
            if (purchase.getPurchasePrice() <= 40) {
                shippingPrice = 15;
            }
        }

        else {
            shippingPrice = 20;
        }

        for (Product product : purchase.getPurchadeProducts()) {
            if (product.getProductType().equals("Furniture")) {
                shippingPrice += 10;
            }
        }
        return shippingPrice;
    }

}
