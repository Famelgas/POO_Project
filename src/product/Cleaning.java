package product;
import java.lang.NumberFormatException;
import java.lang.String;
import promotion.*;
import date.Date;

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
    
    
    public Cleaning separateCleaningInfo(String line, Date date) {
        Cleaning newProduct = new Cleaning();
        String[] atributes = {"type", "identifier", "name", "unitPrice", "stock", "toxicityLevel"};
        Promotion promotion = new Promotion();
        String words = "";
        int atrib = 0;
        int i;
        
        
        for (i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n' || line.charAt(i) == ':') {
                if (line.charAt(i) == ':') {
                    promotion = Promotion.getProductPromotion(line, i + 1, date);
                    break;
                }
                
                if (atributes[atrib].equals("type")) {
                    newProduct.setProductType(words);
                    ++atrib;
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
                    ++atrib;
                }

                if (atributes[atrib].equals("name")) {
                    newProduct.setName(words);
                    ++atrib;
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
                    ++atrib;
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
                    ++atrib;
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

                System.out.println(words);

                words = "";
            }
            
            
            else {
                words += line.charAt(i);
            }
        }
        
        
        atrib = 0;
        words = "";

        promotion = Promotion.getProductPromotion(line, i, date);
        
        newProduct.setPromotion(promotion);

        return newProduct;
    }
}
