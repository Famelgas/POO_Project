package product;
import java.lang.NumberFormatException;
import java.lang.String;
import promotion.*;

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


    public Furniture separateProductInfo(String line) {
        System.out.println(line);
        Furniture newProduct = new Furniture();
        String[] atributes = {"type", "identifier", "name", "unitPrice", "stock", "height", "width", "depth", "weight", "promoType"};
        int atrib = 0;
        line = line.strip();
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

            if (atributes[atrib].equals("height")) {
                float height;
                try {
                    height = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    height = -1;
                }
                newProduct.setHeight(height);
            }

            if (atributes[atrib].equals("width")) {
                float width;
                try {
                    width = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    width = -1;
                }
                newProduct.setWidth(width);
            }

            if (atributes[atrib].equals("depth")) {
                float depth;
                try {
                    depth = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    depth = -1;
                }
                newProduct.setDepth(depth);
            }

            if (atributes[atrib].equals("weight")) {
                float weight;
                try {
                    weight = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    weight = -1;
                }
                newProduct.setWeight(weight);
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
