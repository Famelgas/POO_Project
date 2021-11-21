package product;
import java.lang.NumberFormatException;
import java.lang.String;


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


    public static Furniture separateFurnitureInfo(String line) {
        Furniture newProduct = new Furniture();
        String[] atributes = {"identifier", "name", "unitPrice", "stock", "promotion", "height", "width", "depth", "weight"};
        String words = "";
        int atrib = 0;
        
        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == '/' || line.charAt(i) == '\n') {
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
                if (atributes[atrib].equals("promotion")) {
                    newProduct.setPromotion(words);
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
