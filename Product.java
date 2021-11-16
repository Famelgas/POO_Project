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

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
}
