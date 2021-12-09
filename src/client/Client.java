package client;
import java.io.Serializable;
import java.lang.String;
import java.util.ArrayList;
import database.FormatText;
import database.DataBaseManager;
import date.Date;
import product.*;


import java.util.Scanner;


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

    public Client() {
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
        this.mbWayPin = 0;
        this.creditCardNumber = 0;
        this.expirationDate = new Date(00, 00, 0000);
        this.creditCardCVV = 0;
    }

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
     * @return String
     */
    public String getName() {
        return name;
    }

    
    /** 
     * @param name
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /** 
     * @return String
     */
    public String getAddress() {
        return address;
    }

    
    /** 
     * @param address
     */
    public void setAddress(String address) {
        this.address = address;
    }

    
    /** 
     * @return String
     */
    public String getEmail() {
        return email;
    }

    
    /** 
     * @param email
     */
    public void setEmail(String email) {
        this.email = email;
    }

    
    /** 
     * @return int
     */
    public int getPhoneNumber() {
        return phoneNumber;
    }

    
    /** 
     * @param phoneNumber
     */
    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    
    /** 
     * @return Date
     */
    public Date getBirthday() {
        return birthday;
    }

    
    /** 
     * @param birthday
     */
    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    
    /** 
     * @return boolean
     */
    public boolean isFrequent() {
        return frequent;
    }

    
    /** 
     * @param frequent
     */
    public void setFrequent(boolean frequent) {
        this.frequent = frequent;
    }

    
    /** 
     * @return int
     */
    public int getMbWayPin() {
        return mbWayPin;
    }

    
    /** 
     * @param pin
     */
    public void setMbWayPin(int pin) {
        this.mbWayPin = pin;
    }

    
    /** 
     * @return int
     */
    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    
    /** 
     * @param creditCardNumber
     */
    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    
    /** 
     * @return Date
     */
    public Date getExpirationDate() {
        return expirationDate;
    }

    
    /** 
     * @param date
     */
    public void setExpirationDate(Date date) {
        this.expirationDate = date;
    }

    
    /** 
     * @return int
     */
    public int getCreditCardCVV() {
        return creditCardCVV;
    }

    
    /** 
     * @param cvv
     */
    public void setCreditCardCVV(int cvv) {
        this.creditCardCVV = cvv;
    }

    
    /** 
     * @return ArrayList<Product>
     */
    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    
    /** 
     * @param shoppingCart
     */
    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    
    /** 
     * @return ArrayList<Integer>
     */
    public ArrayList<Integer> getPurchaseHistory() {
        return purchaseHistory;
    }

    
    /** 
     * @param purchaseHistory
     */
    public void setPurchaseHistory(ArrayList<Integer> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


    
    /** 
     * @param product
     * @param amount
     */
    public void addToShoppingCart(Product product) {
        this.shoppingCart.add(product);
    }

    
    /** 
     * @param reference
     */
    public void addToPurchaseHistory(int reference) {
        this.purchaseHistory.add(reference);
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nEmail: " + email + "\nPhone number: " + phoneNumber + "\nBirthday: " + birthday + "\nFrequent: " + frequent + "\nMBWay pin: " + mbWayPin + "\nCredit card number: " + creditCardNumber + "\nExpiration date: " + expirationDate.toString() + "\nCVV: " + creditCardCVV;
    }

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
     * @param dataBaseManager
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
     * @param product
     * @param amount
     * @return Product
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
     * @param productName
     * @return Product
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
     * @param product
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
     * @return ArrayList<Product>
     */
    public ArrayList<Product> clearShoppingCart() {
        return new ArrayList<>();
    }

   
     /**
      * Separates the string so we can create a new client
      * @param line - all the information of one client
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
     * @param phoneNumber
     * @param pin
     * @return boolean
     */
    // Verifies that the payment is accepted 
    // returns false if not
    public boolean acceptMbWayPayment(int phoneNumber, int pin) {
        return this.phoneNumber == phoneNumber && this.mbWayPin == pin;
    }         


    
    /** 
     * @param creditCardNumber
     * @param expirationDate
     * @param cvv
     * @return boolean
     */
    public boolean acceptCreditCardPayment(int creditCardNumber, Date expirationDate, int cvv) {
        return this.creditCardNumber == creditCardNumber && this.expirationDate.equals(expirationDate) && this.creditCardCVV == cvv;
    }
    


}