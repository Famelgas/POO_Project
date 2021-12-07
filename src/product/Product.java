package product;
import java.io.Serializable;
import java.lang.String;
import java.util.Scanner;
import promotion.*;
import date.Date;

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

    public Promotion getProductPromotion(String promoType, String strStartDate, String strEndDate) {
        Promotion promotion = switch (promoType) {
            case "No promotion" -> new NoPromotion();
            case "Pay less" -> new PayLess(Date.convertStringToDate(strStartDate), Date.convertStringToDate(strEndDate));
            case "Pay some items" -> new PaySomeItems(Date.convertStringToDate(strStartDate), Date.convertStringToDate(strEndDate));
            default -> new Promotion();
        };
        return promotion;   
    }



    public static Product getProductType(Scanner lineSc) {
        lineSc.useDelimiter("\\s*;\\s*");
        String productType = lineSc.next();
        
        if (productType.equals("Cleaning")) {
            return new Cleaning();
        }

        if (productType.equals("Food")) {
            return new Food();
        }

        if (productType.equals("Furniture")) {
            return new Furniture();
        }

        return null;
    }

    // Separates the string so we can create a new product
    public Product separateProductInfo(Scanner lineSc) {
        Product product = new Product();
        lineSc.useDelimiter("\\s*;\\s*");

        product.setIdentifier(lineSc.nextInt());
        product.setName(lineSc.next());
        product.setUnitPrice(lineSc.nextFloat());
        product.setStock(lineSc.nextInt());

        product.setPromotion(product.getProductPromotion(lineSc.next(), lineSc.next(), lineSc.next()));

        return product;
    }
}
