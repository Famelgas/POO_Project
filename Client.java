public class Client {
    protected String name;
    protected String address;
    protected String email;
    protected int phoneNumber;
    protected Date birthday;
    
    public Client() {}

    public Client(String name, String address, String email, int phoneNumber, Date birthday) {
        this.name = name;
        this.address = address;
        this.email = email;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
    }

}

