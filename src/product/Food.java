package product;
import java.lang.String;
import java.util.Scanner;


/**
 * Class Food - extends Product: food products
 */
public class Food extends Product {
    private int caloriesPer100G;
    private float fatPercent;
    
    public Food() {
        this.productType = "Food";
    }
    
    public Food(int caloriesPer100G, float fatPercent) {
        this.caloriesPer100G = caloriesPer100G;
        this.fatPercent = fatPercent;
        this.productType = "Food";
    }
    
    
    /**
     * CaloriesPer100G getter
     * @return int - returns caloriesPer100G
     */
    public int getCaloriesPer100G() {
        return caloriesPer100G;
    }
    
    
    /**
     * CaloriesPer100G - setter
     * @param caloriesPer100G - caloriesPer100G to be set
     */
    public void setCaloriesPer100G(int caloriesPer100G) {
        this.caloriesPer100G = caloriesPer100G;
    }
    
    
    /**
     * FatPercent getter
     * @return float - returns fatPercent
     */
    public float getFatPercent() {
        return fatPercent;
    }
    
    
    /**
     * FatPercent setter
     * @param fatPercent - fatPercent to be set
     */
    public void setFatPercent(float fatPercent) {
        this.fatPercent = fatPercent;
    }
    
    
    /**
     * Override String.toString()
     * @return String - converted string
     */
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nCalories per 100g: " + caloriesPer100G + "\nFat percentage: " + fatPercent;
    }


    
    /**
     * Separates the line read from the text file into the food's atributes
     * @param line - line read from the text file
     * @return - returns a new Food
     */
    public Product separateProductInfo(Scanner lineSc) {
        Food product = new Food();
        lineSc.useDelimiter("\\s*;\\s*");

        product.setIdentifier(lineSc.nextInt());
        product.setName(lineSc.next());
        product.setUnitPrice(lineSc.nextFloat());
        product.setStock(lineSc.nextInt());
        product.setCaloriesPer100G(lineSc.nextInt());
        product.setFatPercent(lineSc.nextFloat());

        product.setPromotion(product.getProductPromotion(lineSc.next(), lineSc.next(), lineSc.next()));

        return product;
    }
}
