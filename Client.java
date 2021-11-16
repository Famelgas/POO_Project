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
   

    // Creates a new a account for a new client, this means creating a new Client
    // and writing his information in the data base to enable login
    public Client createAccount(String name, String address, String email, int phoneNumber, Date birthday) {
        Client newClient = new Client(name, address, email, phoneNumber, birthday);
        
        // Add email and user name to text file
        addClientToDataBase(newClient);

        return newClient;
    }
   

    private static void addClientToDataBase(Client newClient) {
       // write in file  
    }

}


