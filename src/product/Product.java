package product;
import java.lang.String;

public class Product {
    protected String productType; 
    protected int identifier;
    protected String name;
    protected float unitPrice;
    protected int stock;

    public Product() {}

    public Product(String productType, int identifier, String name, float unitPrice, int stock) {
        this.productType = productType;
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
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


    // Separates the string so we can create a new product
    public static Product separateProductInfo(String line) {
        String[] productType = {"cleaning" , "food", "furniture"};
        String words = "";
        int type = 0;

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
                if (productType[type].equals(words)) {
                    return Cleaning.separateCleaningInfo(line);                    
                }    
                if (productType[type].equals(words)) {
                    return Food.separateFoodInfo(line);
                }
                if (productType[type].equals(words)) {
                    return Furniture.separateFurnitureInfo(line);
                }

                ++type;
            }

            else {
                words += line.charAt(i);
            }
        }

        return new Product();
    }
}
