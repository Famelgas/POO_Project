package product;
import java.lang.NumberFormatException;
import java.lang.String;
import promotion.*;
import date.Date;

public class Furniture extends Product {
    private float height;
    private float width;
    private float depth;
    private float weight;

    public Furniture() {}

    public Furniture(float height, float width, float depth, float weight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
    }

    public float getHeight() {
        return height;
    }

    public void setHeight(float height) {
        this.height = height;
    }

    public float getWidth() {
        return width;
    }

    public void setWidth(float width) {
        this.width = width;
    }

    public float getDepth() {
        return depth;
    }

    public void setDepth(float depth) {
        this.depth = depth;
    }

    public float getWeight() {
        return weight;
    }

    public void setWeight(float weight) {
        this.weight = weight;
    }

    public String toString() {
        return "Type: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nHeight: " + height + "\nWidth" + width + "\nDepth: " + depth + "\nWeight: " + weight;
    }


    public Furniture separateProductInfo(String line, Date date) {
        Furniture newProduct = new Furniture();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "height", "width", "depth", "weight"};
        Promotion promotion = new NoPromotion();
        String words = "";
        String promoWords = "";
        boolean promo = false;
        int atrib = 0;
        int i;
        
        for (i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (line.charAt(i) == ':') {
                    promo = true;
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

                if (atributes[atrib].equals("height")) {
                    float height;
                    try {
                        height = Float.parseFloat(words);
                    }
                    catch (NumberFormatException nfe) {
                       height = -1;
                    }
                    newProduct.setHeight(height);
                    ++atrib;
                }
                
                if (atributes[atrib].equals("width")) {
                    float width;
                    try {
                        width = Float.parseFloat(words);
                    }
                    catch (NumberFormatException nfe) {
                       width = -1;
                    }
                    newProduct.setWidth(width);
                    ++atrib;
                }
                
                if (atributes[atrib].equals("depth")) {
                    float depth;
                    try {
                        depth = Float.parseFloat(words);
                    }
                    catch (NumberFormatException nfe) {
                       depth = -1;
                    }
                    newProduct.setDepth(depth);
                    ++atrib;
                }
                
                if (atributes[atrib].equals("weight")) {
                    float weight;
                    try {
                        weight = Float.parseFloat(words);
                    }
                    catch (NumberFormatException nfe) {
                       weight = -1;
                    }
                    newProduct.setWeight(weight);
                }

                words = "";
            }

            else {
                if (!promo) {
                    words += line.charAt(i);
                } else {
                    promoWords += line.charAt(i);
                }
            }
        }
        
        promotion = Promotion.getProductPromotion(promoWords, date);

        newProduct.setPromotion(promotion);
        return newProduct;
    }
}
