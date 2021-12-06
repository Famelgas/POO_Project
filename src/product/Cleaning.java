package product;
import java.lang.NumberFormatException;
import java.lang.String;
import promotion.*;

// tirei a parte das promoçoes, falta implementar isso 



public class Cleaning extends Product {
    private int toxicityLevel;
    
    public Cleaning() {}

    public Cleaning(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }

    public int getToxicityLevel() {
        return toxicityLevel;
    }

    public void setToxicityLevel(int toxicityLevel) {
        this.toxicityLevel = toxicityLevel;
    }

    public String toString() {
        return "Type: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nToxicity level: " + toxicityLevel;
    }
    
    
    public Cleaning separateProductInfo(String line) {
        System.out.println(line);
        Cleaning newProduct = new Cleaning();
        String[] atributes = {"type", "identifier", "name", "unitPrice", "stock", "toxicityLevel", "promoType"};
        int atrib = 0;
        line = line.strip();
        String[] words = line.split("[;:]+");
        
        for (int i = 0; i < words.length; ++i) {
            
            if (atributes[atrib].equals("type")) {
                newProduct.setProductType("Cleaning");
                ++atrib;
            }
            
            if (atributes[atrib].equals("identifier")) {
                int ident;
                try {
                    ident = Integer.parseInt(words[i]);
                }
                catch (NumberFormatException nfe) {
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
                }
                catch (NumberFormatException nfe) {
                    price = -1;
                }
                newProduct.setUnitPrice(price);
                ++atrib;
            }
            
            if (atributes[atrib].equals("stock")) {
                int stock;
                try {
                    stock = Integer.parseInt(words[i]);
                }
                catch (NumberFormatException nfe) {
                    stock = -1;
                }
                newProduct.setStock(stock);
                ++atrib;
            }
            
            if (atributes[atrib].equals("toxicityLevel")) {
                int level;
                try {
                    level = Integer.parseInt(words[i]);
                }
                catch (NumberFormatException nfe) {
                    level = -1;
                }
                newProduct.setToxicityLevel(level);
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
