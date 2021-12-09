package product;
import java.io.Serializable;
import java.lang.String;
import java.util.Scanner;
import promotion.*;
import date.Date;

/**
 * Class Product - manages methods that manipulate or are related to products
 */
public class Product implements Serializable {
    protected String productType; 
    protected int identifier;
    protected String name;
    protected float unitPrice;
    protected int stock;
    protected int amountToBuy;
    // falta fazer getter e setter da promotion
    // perguntar a prof se pode ou nao ser abstrata
    protected Promotion promotion;

    /**
     * Product's constructor
     */
    public Product() {}

    /**
     * Product's constructor
     * 
     * @param productType - productType
     * @param identifier - identifier
     * @param name - name
     * @param unitPrice - unitPrice
     * @param stock - stock
     */
    public Product(String productType, int identifier, String name, float unitPrice, int stock) {
        this.productType = productType;
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        
    }

    
    /**
     * ProductType getter
     * 
     * @return String - returns productType
     */
    public String getProductType() {
        return productType;
    }

    
    /**
     * ProductType setter
     * 
     * @param productType - productType to be set
     */
    public void setProductType(String productType) {
        this.productType = productType;
    }

    
    /**
     * Identifier getter
     * 
     * @return int - returns identifier
     */
    public int getIdentifier() {
        return identifier;
    }

    
    /**
     * Identifier setter
     * 
     * @param identifier - identifier to be set
     */
    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    
    /**
     * Name getter
     * 
     * @return String - returns name
     */
    public String getName() {
        return name;
    }

    
    /**
     * Name setter
     * 
     * @param name - name to be set
     */
    public void setName(String name) {
        this.name = name;
    }

    
    /**
     * UnitPrice getter
     * 
     * @return float - returns unitPrice
     */
    public float getUnitPrice() {
        return unitPrice;
    }

    
    /**
     * UnitPrice setter
     * 
     * @param unitPrice - unitPrice to be set
     */
    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    
    /**
     * Stock getter
     * 
     * @return int - returns stock
     */
    public int getStock() {
        return stock;
    }

    
    /**
     * Stock setter
     * 
     * @param stock - stock to be set
     */
    public void setStock(int stock) {
        this.stock = stock;
    }

    
    /**
     * AmountToBuy getter
     * 
     * @return - returns amountToBuy
     */
    public int getAmountToBuy() {
        return amountToBuy;
    }


    /**
     * AmountToBuy
     * 
     * @param amountToBuy - amountToBuy to be set
     */
    public void setAmountToBuy(int amountToBuy) {
        this.amountToBuy = amountToBuy;
    }

    
    /**
     * Promotion getter
     * 
     * @return Promotion - returns promotion
     */
    public Promotion getPromotion() {
        return promotion;
    }

    
    /**
     * Promotion setter
     * 
     * @param promotion - promotion to be set
     */
    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    
    /**
     * Override String.toString()
     * 
     * @return String - converted string
     */
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString();
    }

    
    /** 
     * Gets the promotion type of product
     * @param promoType - promotion type
     * @param strStartDate - starting date
     * @param strEndDate - ending date
     * @return Promotion - retuns a new Promotion
     */
    public Promotion getProductPromotion(String promoType, String strStartDate, String strEndDate) {
        Promotion promotion = switch (promoType) {
            case "No promotion" -> new NoPromotion();
            case "Pay less" -> new PayLess(Date.convertStringToDate(strStartDate), Date.convertStringToDate(strEndDate));
            case "Pay some items" -> new PaySomeItems(Date.convertStringToDate(strStartDate), Date.convertStringToDate(strEndDate));
            default -> new Promotion();
        };
        return promotion;   
    }



    
    /** 
     * Gets the product type
     * @param lineSc - line read from text file
     * @return Product - returns a new Product
     */
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

    
    /**
     * Separates the line read from the text file into the product's atributes
     * @param lineSc - line read from the text file
     * @return - returns a new Product
     */
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
