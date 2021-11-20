package product;
import sale.*;
import java.lang.String;

public class Product {
    protected int identifier;
    protected String name;
    protected float unitPrice;
    protected int stock;
    protected Sale promotion;

    public Product() {}

    public Product(int identifier, String name, float unitPrice, int stock) {
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

    public Sale getPromotion() {
        return promotion;
    }

    public void setPromotion(String promotion) {
        this.promotion = new Sale(promotion); 
    }

    // Separates the string so we can create a new product
    public static Product separateProductInfo(String line) {
        String[] productType = {"cleaning" , "food", "furniture"};
        String words = "";
        int type = 0;

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
                if (productType[type].equals("cleaning")) {
                    return Cleaning.separateCleaningInfo(line);                    
                }    
                if (productType[type].equals("food")) {
                    return Food.separateFoodInfo(line);
                }
                if (productType[type].equals("furniture")) {
                    return Furniture.separateFurnitureInfo(line);
                }
            }

            else {
                words += line.charAt(i);
            }
        }

        return new Product();
    }
}
