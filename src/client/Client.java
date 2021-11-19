package client;

public class Client {
    private String name;
    private String address;
    private String email;
    private int phoneNumber;
    private Date birthday;
    private boolean frequent; 

    public Client() {}

    public Client(String name, String address, String email, int phoneNumber, Date birthday) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.frequent = false;
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

    // Creates a new a account for a new client, this means creating a new Client
    // and writing his information in the data base to enable login
    public void createAccount(String name, String address, String email, int phoneNumber, Date birthday) {
        // Add email to text file
        addClientToDataBase(newClient);

    }
   

    private static void addClientToDataBase(Client newClient) {
       // write in file  
    }
    
    


}


