package product;
import java.lang.NumberFormatException;
import java.lang.String;


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


    public static Cleaning separateCleaningInfo(String line) {
        Cleaning newProduct = new Cleaning();
        String[] atributes = {"type", "identifier", "name", "unitPrice", "stock", "toxicityLevel"};
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
                    int level;
                    try {
                       level = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                       level = -1;
                    }
                    newProduct.setToxicityLevel(level);
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
