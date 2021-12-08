package product;
import java.lang.String;
import java.util.Scanner;

// tirei a parte das promoçoes, falta implementar isso 



public class Cleaning extends Product {
    private int toxicityLevel;
    
    public Cleaning() {
        this.productType = "Cleaning";
    }
    
    public Cleaning(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
        this.productType = "Cleaning";
    }

    
    /** 
     * @return int
     */
    public int getToxicityLevel() {
        return toxicityLevel;
    }

    
    /** 
     * @param toxicityLevel
     */
    public void setToxicityLevel(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nToxicity level: " + toxicityLevel;
    }
    
    
    
    /** 
     * @param lineSc
     * @return Product
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
