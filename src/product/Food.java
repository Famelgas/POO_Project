package product;
import java.lang.NumberFormatException;
import java.lang.String;
import promotion.*;


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


    public Food separateProductInfo(String line) {
        Food newProduct = new Food();
        String[] atributes = {"type", "identifier", "name", "unitPrice", "stock", "caloriesPer100G", "fatPercent"};
        int atrib = 0;
        String[] words = line.split("[;:]+");

        for (int i = 0; i < words.length; ++i) {

            if (atributes[atrib].equals("type")) {
                newProduct.setProductType("Food");
                ++atrib;
            }

            if (atributes[atrib].equals("identifier")) {
                int ident;
                try {
                    ident = Integer.parseInt(words[i]);
                } catch (NumberFormatException nfe) {
                    ident = -1;
                }
                newProduct.setIdentifier(ident);
                ++atrib;
            }

            if (atributes[atrib].equals("name")) {
                newProduct.setName(words[i]);
                ++atrib;
            }

            if (atributes[atrib].equals("unitPrice")) {
                float price;
                try {
                    price = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    price = -1;
                }
                newProduct.setUnitPrice(price);
                ++atrib;
            }

            if (atributes[atrib].equals("stock")) {
                int stock;
                try {
                    stock = Integer.parseInt(words[i]);
                } catch (NumberFormatException nfe) {
                    stock = -1;
                }
                newProduct.setStock(stock);
                ++atrib;
            }

            if (atributes[atrib].equals("caloriesPer100G")) {
                int calories;
                try {
                    calories = Integer.parseInt(words[i]);
                } catch (NumberFormatException nfe) {
                    calories = -1;
                }
                newProduct.setCaloriesPer100G(calories);
            }

            if (atributes[atrib].equals("fatPercent")) {
                float fatPercent;
                try {
                    fatPercent = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    fatPercent = -1;
                }
                newProduct.setFatPercent(fatPercent);
                ++atrib;
            }

            if (atributes[atrib].equals("promoType")) {
                Promotion promotion = newProduct.getProductPromotion(words[i], words[i + 1], words[i + 2]);
                newProduct.setPromotion(promotion);
                break;
            }

        }

        return newProduct;
    }
}
