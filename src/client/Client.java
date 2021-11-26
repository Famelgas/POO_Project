package client;
import java.lang.NumberFormatException;
import java.lang.String;
import java.util.ArrayList;
import java.util.Scanner;
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

    public void addToShoppingCart(Product product, int numberOfProducts) {
        product.setStock(numberOfProducts);
        this.shoppingCart.add(product);
    }

    public void addToPurchaseHistory(Purchase purchase) {
        this.purchaseHistory.add(purchase);
    }
   
    // Separates the string so we can create a new client
    public static Client separateClientInfo(String line) {
        Client newClient = new Client();
        String[] clientAtributes = {"name", "address", "email", "phoneNumber", "birthday", "frequent"};
        int atrib = 0;
        String words = "";

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
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
                
                ++atrib; 
                words = "";
            }

            else {
                words += line.charAt(i);
            }
        } 
        
        return newClient;
    }

    public boolean acceptPayment() {
        Scanner sc = new Scanner(System.in);
        int option;
        System.out.println("Select your desired payment method:");
        System.out.println("1. MbWay\n 2. Credit Card");    
        option = sc.nextInt();

        while(option != 1 && option != 2) {
            System.out.println("Invalid option. Please try again.");
            option = sc.nextInt();    
        }
        
        if (option == 1) {
            while (true) {
                System.out.print("Phone number: ");
                int phoneNumber = sc.nextInt();
                System.out.println();
                if (this.phoneNumber == phoneNumber) {
                    System.out.print("PIN: ");
                    int pin = sc.nextInt(); 
                    System.out.println();
                    
                    if (this.mbWayPin == pin) {
                        sc.close();
                        return true;
                    }
                    else {
                        sc.close();
                        return false;
                    }
                }
                else {
                    System.out.println("Wrong phone number.");
                    System.out.println("Do you want to try again?\n 1. Yes\n2. No");
                    if (option == 2) {
                        sc.close();
                        return false;
                    }
                }   
            }
        }
        if (option == 2) {
            System.out.print("Credit card number: ");
            int ccNumber = sc.nextInt();
            System.out.println();

            System.out.println("Expiration date:");
            System.out.print("Day -> ");
            int day = sc.nextInt();
            System.out.print("\nMonth -> ");
            int month = sc.nextInt();
            System.out.print("\nYear -> ");
            int year = sc.nextInt();
            System.out.println();
            
            Date expDate = new Date(day, month, year);
            
            System.out.print("CVV: ");
            int cvv = sc.nextInt();
            System.out.println(); 
            
            
            if (this.creditCardNumber == ccNumber && this.expirationDate == expDate && this.creditCardCVV == cvv) {
                sc.close();
                return true;
            }
            else {
                System.out.println("The credit card isn´t valid. Please register a valid card in your profile and try again.");
                sc.close();
                return false;
            }
        }
        
        sc.close();
        return true;
    }         
    


}