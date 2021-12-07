package product;
import java.lang.String;
import java.util.Scanner;


// tirei a parte das promoçoes, falta implementar isso 


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
    
    public int getCaloriesPer100G() {
        return caloriesPer100G;
    }
    
    public void setCaloriesPer100G(int caloriesPer100G) {
        this.caloriesPer100G = caloriesPer100G;
    }
    
    public float getFatPercent() {
        return fatPercent;
    }
    
    public void setFatPercent(float fatPercent) {
        this.fatPercent = fatPercent;
    }
    
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nCalories per 100g: " + caloriesPer100G + "\nFat percentage: " + fatPercent;
    }


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
