package client;
import java.lang.NumberFormatException;
import java.lang.String;
import java.util.ArrayList;
import date.Date;
import product.*;


public class Client {
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
    // To keep the clients shopping history an ArrayList of Sales is needed,
    // this allows the client to keep track of every purchase he has ever made
    private ArrayList<Purchase> purchaseHistory;  

    public Client() {
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
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
    }

    public Client(String name, String address, String email, int phoneNumber, Date birthday, Boolean frequent, int mbWayPin, int creditCardNumber, Date creditCardDate, int creditCardCVV) {
        this.frequent = frequent;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.frequent = false;
        this.mbWayPin = mbWayPin;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = creditCardDate;
        this.creditCardCVV = creditCardCVV;
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
    }

    public Client(String name, String address, String email, int phoneNumber, Date birthday, Boolean frequent, int mbWayPin) {
        this.frequent = frequent;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.frequent = false;
        this.mbWayPin = mbWayPin;
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
    }

    public Client(String name, String address, String email, int phoneNumber, Date birthday, Boolean frequent, int creditCardNumber, Date creditCardDate, int creditCardCVV) {
        this.frequent = frequent;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.frequent = false;
        this.creditCardNumber = creditCardNumber;
        this.expirationDate = creditCardDate;
        this.creditCardCVV = creditCardCVV;
        this.shoppingCart = new ArrayList<>();
        this.purchaseHistory = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(int phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public boolean isFrequent() {
        return frequent;
    }

    public void setFrequent(boolean frequent) {
        this.frequent = frequent;
    }

    public int getMbWayPin() {
        return mbWayPin;
    }

    public void setMbWayPin(int pin) {
        this.mbWayPin = pin;
    }

    public int getCreditCardNumber() {
        return creditCardNumber;
    }

    public void setCreditCardNumber(int creditCardNumber) {
        this.creditCardNumber = creditCardNumber;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date date) {
        this.expirationDate = date;
    }

    public int getCreditCardCVV() {
        return creditCardCVV;
    }

    public void setCreditCardCVV(int cvv) {
        this.creditCardCVV = cvv;
    }

    public ArrayList<Product> getShoppingCart() {
        return shoppingCart;
    }

    public void setShoppingCart(ArrayList<Product> shoppingCart) {
        this.shoppingCart = shoppingCart;
    }

    public ArrayList<Purchase> getPurchaseHistory() {
        return purchaseHistory;
    }

    public void setPurchaseHistory(ArrayList<Purchase> purchaseHistory) {
        this.purchaseHistory = purchaseHistory;
    }


    public void addToShoppingCart(Product product, int amount) {
        product.setStock(amount);
        this.shoppingCart.add(product);
    }

    public void addToPurchaseHistory(Purchase purchase) {
        this.purchaseHistory.add(purchase);
    }

    public String toString() {
        return "Name: " + name + "\nAddress: " + address + "\nEmail: " + email + "\nPhone number: " + phoneNumber + "\nBirthday: " + birthday + "\nFrequent: " + frequent + "\nMBWay pin: " + mbWayPin + "\nCredit card number: " + creditCardNumber + "\nExpiration date: " + expirationDate.toString() + "\nCVV: " + creditCardCVV;
    }

    public void showPurchaseHistory() {
        int count = 0;
        for (Purchase purchase : purchaseHistory) {
            System.out.print(count + ". ");
            purchase.showPurchase();
            System.out.println();
        }
    }

    public Product verifyStock(Product product, int amount) {
        for (Product productInCart : shoppingCart) {
            if (product.getIdentifier() == productInCart.getIdentifier()) {
                // It's impossible to remove more items from the cart than those that are in the cart 
                if ((productInCart.getStock() - product.getStock()) < 0) {
                    product.setStock(productInCart.getStock());
                }
            }
        }
        return product;
    }


    public Product getProductFromShoppingCart(String productName) {
        for (Product product : shoppingCart) {
            if (product.getName().equals(productName)) {
                return product;
            }
        }
        return null;
    }

    public void removeProductFromShoppingCart(Product product) {
        for (Product productInCart : shoppingCart) {
            if (product.getIdentifier() == productInCart.getIdentifier()) {
                shoppingCart.remove(productInCart);
            }
        }
    }

    public void clearShoppingCart() {
        for (Product product : shoppingCart) {
            shoppingCart.remove(product);
        }
    }

   
     /**
      * Separates the string so we can create a new client
      * @param line - all the information of one client
      * @return - returns a new Client
      */
    public static Client separateClientInfo(String line) {
        Client newClient = new Client();
        String[] clientAtributes = {"name", "address", "email", "phoneNumber", "birthday", "frequent", "mbwaypin", "ccnumber", "ccdate", "cvv", "pHist"};
        
        String words = "";
        int atrib = 0;
        int index = 0;
        // client info
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (clientAtributes[atrib].equals("name")) {
                    newClient.setName(words);
                }
                if (clientAtributes[atrib].equals("address")) {
                    newClient.setAddress(words);
                }
                if (clientAtributes[atrib].equals("email")) {
                    newClient.setEmail(words);
                }
                if (clientAtributes[atrib].equals("phoneNumber")) {
                    int phNum;
                    try {
                        phNum = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        phNum = -1;
                    }
                    newClient.setPhoneNumber(phNum);
                }
                if (clientAtributes[atrib].equals("birthday")) {
                    Date date = Date.convertStringToDate(words);
                    newClient.setBirthday(date);
                }
                if (clientAtributes[atrib].equals("frequent")){
                    if (words.equals("true")) {
                        newClient.setFrequent(true);
                    }
                    else if (words.equals("false")) {
                        newClient.setFrequent(false);
                    }
                }
                
                if (clientAtributes[atrib].equals("mbwaypin")) {
                    int mbwaypin;
                    try {
                        mbwaypin = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        mbwaypin = -1;
                    }
                    newClient.setPhoneNumber(mbwaypin);
                }
                
                if (clientAtributes[atrib].equals("ccnumber")) {
                    int ccnumber;
                    try {
                        ccnumber = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        ccnumber = -1;
                    }
                    newClient.setPhoneNumber(ccnumber);
                }
                
                if (clientAtributes[atrib].equals("ccdate")) {
                    Date date = Date.convertStringToDate(words);
                    newClient.setExpirationDate(date);
                }
                
                if (clientAtributes[atrib].equals("cvv")) {
                    int cvv;
                    try {
                        cvv = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        cvv = -1;
                    }
                    newClient.setPhoneNumber(cvv);
                }
                if (clientAtributes[atrib].equals("pHist")) {
                    newClient.addToPurchaseHistory(Purchase.serparatePurchaseInfo(words));
                    --atrib;
                }
                
                if (line.charAt(i) == ':') {
                    index = i;
                    break;
                }
                
                
                ++atrib; 
                words = "";
            }
            
            else {
                words += line.charAt(i);
            }
        } 

        words = "";
        // purchase history
        for (int i = index + 1; i < line.length(); ++i) {
            // more than one purchase
            if (line.charAt(i) == ':' || line.charAt(i) == '\n') {
                newClient.addToPurchaseHistory(Purchase.serparatePurchaseInfo(words));
                words = "";
            }
            else {
                words += line.charAt(i);
            }
            
        }
        
        return newClient;
    }
    
    // Verifies that the payment is accepted 
    // returns false if not
    public boolean acceptMbWayPayment(int phoneNumber, int pin) {
        return this.phoneNumber == phoneNumber && this.mbWayPin == pin;
    }         


    public boolean acceptCreditCardPayment(int creditCardNumber, Date expirationDate, int cvv) {
        return this.creditCardNumber == creditCardNumber && this.expirationDate.equals(expirationDate) && this.creditCardCVV == cvv;
    }
    


}