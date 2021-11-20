package product;
import java.lang.NumberFormatException;
import java.lang.String;

public class Food extends Product {
    private int caloriesPer100G;
    private float fatPercent;

    public Food() {}
    
    public Food(int caloriesPer100G, float fatPercent) {
       this.caloriesPer100G = caloriesPer100G;
       this.fatPercent = fatPercent;
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


    public static Food separateFoodInfo(String line) {
        Food newProduct = new Food();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "promotion", "caloriesPer100G", "fatPercent"};

        return newProduct;
    }
}
