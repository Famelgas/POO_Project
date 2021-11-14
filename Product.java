public class Product {
    protected int identifier;
    protected String name;
    protected float unitPrice;
    protected int stock;

    public Product() {}

    public Produtct(int identifier, String name, float unitPrice, int stock) {
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

}
