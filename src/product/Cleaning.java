package product;
import java.lang.String;
import java.util.Scanner;

/**
 * Class Cleaning - extends Product: cleaning products
 */
public class Cleaning extends Product {
    private int toxicityLevel;
    
    /**
     * Clieaing's constructor
     */
    public Cleaning() {
        this.productType = "Cleaning";
    }
    
    /**
     * Clieaing's constructor
     */
    public Cleaning(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
        this.productType = "Cleaning";
    }

    
    /**
     * Toxicity level getter 
     * @return int - returns toxicityLevel
     */
    public int getToxicityLevel() {
        return toxicityLevel;
    }

    
    /** 
     * Toxicity level setter
     * @param toxicityLevel - toxicityLevel to be set
     */
    public void setToxicityLevel(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }

    
    /** 
     * Override String.toString()
     * @return String - converted string 
     */
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nToxicity level: " + toxicityLevel;
    }
    
    
    
    /**
     * Separates the line read from the text file into the cleaning's atributes
     * @param line - line read from the text file
     * @return - returns a new Cleaning
     */
    public Product separateProductInfo(Scanner lineSc) {
        Cleaning product = new Cleaning();
        
        lineSc.useDelimiter("\\s*;\\s*");

        product.setIdentifier(lineSc.nextInt());
        product.setName(lineSc.next());
        product.setUnitPrice(lineSc.nextFloat());
        product.setStock(lineSc.nextInt());
        product.setToxicityLevel(lineSc.nextInt());
        
        product.setPromotion(product.getProductPromotion(lineSc.next(), lineSc.next(), lineSc.next()));
        
        return product;
    }
}
