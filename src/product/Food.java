package product;
import java.lang.NumberFormatException;
import java.lang.String;


// tirei a parte das promoçoes, falta implementar isso 


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
    
    public String toString() {
        return "Type: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nCalories per 100g: " + caloriesPer100G + "\nFat percentage: " + fatPercent;
    }


    public static Food separateFoodInfo(String line) {
        Food newProduct = new Food();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "caloriesPer100G", "fatPercent"};
        String words = "";
        int atrib = 0;
        
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (atributes[atrib].equals("type")) {
                    newProduct.setProductType(words);
                }                 
                if (atributes[atrib].equals("identifier")) {
                    int ident;
                    try {
                        ident = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        ident = -1;
                    }
                    newProduct.setIdentifier(ident);
                }
                if (atributes[atrib].equals("name")) {
                    newProduct.setName(words);
                }
                if (atributes[atrib].equals("unitPrice")) {
                    int price;
                    try {
                        price = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        price = -1;
                    }
                    newProduct.setUnitPrice(price);
                }
                if (atributes[atrib].equals("stock")) {
                    int stock;
                    try {
                        stock = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        stock = -1;
                    }
                    newProduct.setStock(stock);
                }
                if (atributes[atrib].equals("toxicityLevel")) {
                    int cal;
                    try {
                       cal = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                       cal = -1;
                    }
                    newProduct.setCaloriesPer100G(cal);
                }
                if (atributes[atrib].equals("fatPercent")) {
                    float fat;
                    try {
                       fat = Float.parseFloat(words);
                    }
                    catch (NumberFormatException nfe) {
                       fat = -1;
                    }
                    newProduct.setFatPercent(fat);
                }
                
                ++atrib; 
                words = "";
            }

            else {
                words += line.charAt(i);
            }
        }

        return newProduct;
    }
}
