package product;
import promotion.*;

import java.io.Serializable;
import java.lang.String;

public class Product implements Serializable {
    protected String productType; 
    protected int identifier;
    protected String name;
    protected float unitPrice;
    protected int stock;
    // falta fazer getter e setter da promotion
    // perguntar a prof se pode ou nao ser abstrata
    protected Promotion promotion;

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

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String toString() {
        return "Type: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString();
    }


    // Separates the string so we can create a new product
    public static Product separateProductInfo(String line) {
        String[] productType = {"Cleaning" , "Food", "Furniture"};
        String words = "";

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (productType[0].equals(words)) {
                    return Cleaning.separateCleaningInfo(line);                    
                }    
                if (productType[1].equals(words)) {
                    return Food.separateFoodInfo(line);
                }
                if (productType[2].equals(words)) {
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
