package client;
import java.lang.NumberFormatException;
import java.lang.String;
import java.util.ArrayList;
import date.Date;
import purchase.Purchase;

public class Client {
    private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private Date birthday;
    private boolean frequent;
    // To keep the clients shopping history an ArrayList of Sales is needed,
    // this allows the client to keep track of every purchase he has ever made
    private ArrayList<Purchase> clientPurchases;  

    public Client() {}

    public Client(String name, String address, String email, int phoneNumber, Date birthday, Boolean frequent) {
        this.frequent = frequent;
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.frequent = false;
        this.clientPurchases = new ArrayList<>();
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
                    Date date = Date.convertToDate(words);
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
    
    


}


