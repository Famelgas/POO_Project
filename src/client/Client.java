package client;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import database.FormatText;
import database.DataBaseManager;
import date.Date;
import product.*;


import java.util.Scanner;

/**
 * Class Client, has the atributes and methods that affect every client object.
 */
public class Client implements Serializable {
    private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private Date birthday;
    private boolean frequent;
    private int mbWayPin;
    private int creditCardNumber;
    private Date expirationDate;
    private int creditCardCVV;
    private ArrayList<Product> shoppingCart;
    // ArrayList with the reference numbers of every purchase made by the client
    private ArrayList<Integer> purchaseHistory;  

    /**
     * Client's constructor
     */
    public Client() {
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
        this.mbWayPin = 0;
        this.creditCardNumber = 0;
        this.expirationDate = new Date(00, 00, 0000);
        this.creditCardCVV = 0;
    }
    
    /**
     * Client's constructor
     * 
     * @param name - name 
     * @param address - address
     * @param email - email
     * @param phoneNumber - phoneNumber
     * @param birthday - birthday date
     * @param frequent - frequent
     */
    public Client(String name, String address, String email, int phoneNumber, Date birthday, Boolean frequent) {
        this.frequent = frequent;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.frequent = false;
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
        this.mbWayPin = 0;
        this.creditCardNumber = 0;
        this.expirationDate = new Date(00, 00, 0000);
        this.creditCardCVV = 0;
    }

    
    /** 
     * Name getter
     * @return String - returns name
     */
    public String getName() {
        return name;
    }

    
    /** 
     * Name setter
     * @param name - new name to be set 
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * Addrees getter
     * @return String - returns address
     */
    public String getAddress() {
        return address;
    }

    
    /** 
     * Address setter
     * @param address - new address to be set
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /** 
     * Email getter
     * @return String - returns email
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * Email setter
     * @param email - new email to be set
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * Phone number getter
     * @return int - returns phoneNumber
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    
    /** 
     * Phone number setter
     * @param phoneNumber - new phoneNumber to be set
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * Birthday date getter
     * @return Date - returns birthday
     */
    public Date getBirthday() {
        return birthday;
    }

    
    /** 
     * Birthday date setter
     * @param birthday - new birthDate to be set 
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
    /** 
     * Frequent getter
     * @return boolean - returns true if the client is frequent and false if the client isn't frequent
     */
    public boolean getFrequent() {
        return frequent;
    }

    
    /** 
     * Frequent setter
     * @param frequent - true if the client is frequent and false if the client isn´t frequent
     */
    public void setFrequent(boolean frequent) {
        this.frequent = frequent;
    }

    
    /** 
     * MbWay getter
     * @return int - return mbWayPin
     */
    public int getMbWayPin() {
        return mbWayPin;
    }

    
    /** 
     * MbWay setter
     * @param pin - New mbWayPin to be set
     */
    public void setMbWayPin(int pin) {
        this.mbWayPin = pin;
    }

    
    /**
     * Creditcard number getter
     * @return int - returns creditCardNumber
     */
    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    
    /**
     * CreditCard number setter
     * 
     * @param creditCardNumber - new creditCardNumber to be set 
     */
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    
    /** 
     * Expiration date getter
     * @return Date - return expirationDate
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    
    /** 
     * Expiration date
     * @param date - new expirationDate to be set
     */
    public void setExpirationDate(Date date) {
        this.expirationDate = date;
    }

    
    /**
     * CVV getter 
     * @return int - returns creditCardCVV
     */
    public int getCreditCardCVV() {
        return creditCardCVV;
    }

    
    /** 
     * CVV setter
     * @param cvv - new creditCardCVV to be set
     */
    public void setCreditCardCVV(int cvv) {
        this.creditCardCVV = cvv;
    }

    
    /** 
     * Shopping cart getter
     * @return - returns shoppingCart
     */
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    
    /** 
     * Shopping cart setter
     * @param shoppingCart - new shoppingCart to be set
     */
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    
    /** 
     * Purchase reference history 
     * @return - returns ArrayList of references to the purhcases made before
     */
    public ArrayList<Integer> getPurchaseHistory() {
        return purchaseHistory;
    }

    
    /**
     * Purchase history setter
     * 
     * @param purchaseHistory - new ArrayList of references to be set
     */
    public void setPurchaseHistory(ArrayList<Integer> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


    
    /** 
     * Add product to the shoppingCart
     * @param product - product to be added
     */
    public void addToShoppingCart(Product product) {
        this.shoppingCart.add(product);
    }

    
    /** 
     * Add reference to the purhcaseHistory
     * @param reference - reference to be added
     */
    public void addToPurchaseHistory(int reference) {
        this.purchaseHistory.add(reference);
    }

    
    /** 
     * Override String.toString()
     * @return String - converted string
     */
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nEmail: " + email + "\nPhone number: " + phoneNumber + "\nBirthday: " + birthday + "\nFrequent: " + frequent + "\nMBWay pin: " + mbWayPin + "\nCredit card number: " + creditCardNumber + "\nExpiration date: " + expirationDate.toString() + "\nCVV: " + creditCardCVV;
    }

    
    /**
     * Show the products in the shoppingCart
     */
    public void showShoppingCart() {
        int count = 0;
        for (Product product : shoppingCart) {
            System.out.println();
            System.out.println(product);
            System.out.println("Amount to buy: " + product.getAmountToBuy());
            System.out.println();

            if (count < shoppingCart.size() - 1) {
                FormatText.intermidietLine();
            }
            ++count;
        }
    }


    
    /** 
     * Shows the purchases associated with the references in the purchaseHistory
     * @param dataBaseManager - dataBaseManager
     */
    public void showPurchaseHistory(DataBaseManager dataBaseManager) {
        int count = 0;
        for (Integer reference : purchaseHistory) {
            for (Purchase purchase : dataBaseManager.getPurchaseList()) {
                if (reference == purchase.getPurchaseReference()) {
                    System.out.println();
                    System.out.println(purchase);
                    System.out.println();

                    if (count < purchaseHistory.size() - 1) {
                        FormatText.intermidietLine();
                    }
                    ++count;
                }
            }
        }
    }



    
    /** 
     * Verifies if the cart has enough of the items the client wants to remove  
     * @param product - product to be removed
     * @param amount - amount to be removed
     * @return Product - null if the client wants to remove more items than those that are
     * in the shoppingCart
     */
    public Product verifyCartStock(Product product, int amount) {
        for (Product productInCart : shoppingCart) {
            if (product.getIdentifier() == productInCart.getIdentifier()) {
                // It's impossible to remove more items from the cart than those that are in the cart 
                if (productInCart.getAmountToBuy() < amount) {
                    System.out.println("You can´t remove that many items.");
                    return null;
                }
            }
        }
        return product;
    }


    
    /** 
     * Gets the product with the same name entered from the shoppingCart
     * @param productName - name of the product
     * @return Product - product 
     */
    public Product getProductFromShoppingCart(String productName) {
        for (Product product : shoppingCart) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    
    /**
     * Removes item from the shoppingCart 
     * @param product - product to be removed
     */
    public void removeProductFromShoppingCart(Product product) {
        int i = 0;
        for (Product productInCart : shoppingCart) {
            if (product.getIdentifier() == productInCart.getIdentifier()) {
                shoppingCart.remove(i);
            }
            ++i;
        }
    }

    
    /**
     * Clears the shoppingCart 
     * @return - new shoppingCart
     */
    public ArrayList<Product> clearShoppingCart() {
        return new ArrayList<>();
    }

   
     /**
      * Separates the line read from the text file into the client's atributes
      * @param lineSc - line read from the text file
      * @return - returns a new Client
      */
    public Client separateClientInfo(Scanner lineSc) {
        Client client = new Client();
        
        lineSc.useDelimiter("\\s*;\\s*");
        
        client.setName(lineSc.next());
        client.setAddress(lineSc.next());
        client.setEmail(lineSc.next());
        client.setPhoneNumber(lineSc.nextInt());

        
        client.setBirthday(Date.convertStringToDate(lineSc.next()));

        client.setFrequent(Boolean.parseBoolean(lineSc.next()));

        while (lineSc.hasNextInt()) {
            client.addToPurchaseHistory(lineSc.nextInt());
        }
        

        //System.out.println(client);
        return client;
    }
    
    
    /** 
     * Accept MbWay payment
     * @param phoneNumber - client's phone number
     * @param pin - client's MbWay pin
     * @return boolean - true if payment was accepted and false if the payment was decleined 
     */
    public boolean acceptMbWayPayment(int phoneNumber, int pin) {
        return this.phoneNumber == phoneNumber && this.mbWayPin == pin;
    }         


    
    /**
     * Accept Credit card payment
     * @param creditCardNumber - client's credit card number
     * @param expirationDate - client's credit card expiration date
     * @param cvv - client's credit card cvv
     * @return boolean - true if payment was accepted and false if the payment was decleined
     */
    public boolean acceptCreditCardPayment(int creditCardNumber, Date expirationDate, int cvv) {
        return this.creditCardNumber == creditCardNumber && this.expirationDate.equals(expirationDate) && this.creditCardCVV == cvv;
    }
    


}