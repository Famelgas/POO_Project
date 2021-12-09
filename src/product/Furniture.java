package product;
import java.lang.String;
import java.util.Scanner;

/**
 * Class Furniture - extends Product: furniture products
 */
public class Furniture extends Product {
    private float height;
    private float width;
    private float depth;
    private float weight;

    /**
     * Furnitures's constructor
     */
    public Furniture() {
        this.productType = "Furniture";
    }

    /**
     * Furnitures's constructor
     * 
     * @param height - height
     * @param width - width
     * @param depth - depth
     * @param weight - weights
     */
    public Furniture(float height, float width, float depth, float weight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.productType = "Furniture";
    }

    
    /**
     * Height getter
     * 
     * @return float - returns height
     */
    public float getHeight() {
        return height;
    }

    
    /**
     * Height setters
     * 
     * @param height - height to be set
     */
    public void setHeight(float height) {
        this.height = height;
    }

    
    /**
     * Width getter
     * 
     * @return float - returns width
     */
    public float getWidth() {
        return width;
    }

    
    /**
     * Width setter
     * 
     * @param width - width to be set
     */
    public void setWidth(float width) {
        this.width = width;
    }

    
    /**
     * Depth getter
     * 
     * @return float - returns depth
     */
    public float getDepth() {
        return depth;
    }

    
    /**
     * Depth setter
     * 
     * @param depth - to be set 
     */
    public void setDepth(float depth) {
        this.depth = depth;
    }

    
    /**
     * Weight getter
     * 
     * @return float - returns weight
     */
    public float getWeight() {
        return weight;
    }

    
    /**
     * Weight setter
     * 
     * @param weight - weight to be set
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    
    /**
     * Override String.toString()
     * 
     * @return String - converted string
     */
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nHeight: " + height + "\nWidth" + width + "\nDepth: " + depth + "\nWeight: " + weight;
    }


    /**
     * Separates the line read from the text file into the furniture's atributes
     * @param lineSc - line read from the text file
     * @return - returns a new Furniture
     */
    public Product separateProductInfo(Scanner lineSc) {
        Furniture product = new Furniture();
        lineSc.useDelimiter("\\s*;\\s*");

        product.setIdentifier(lineSc.nextInt());
        product.setName(lineSc.next());
        product.setUnitPrice(lineSc.nextFloat());
        product.setStock(lineSc.nextInt());
        product.setHeight(lineSc.nextFloat());
        product.setWidth(lineSc.nextFloat());
        product.setDepth(lineSc.nextFloat());
        product.setWeight(lineSc.nextFloat());

        product.setPromotion(product.getProductPromotion(lineSc.next(), lineSc.next(), lineSc.next()));

        return product;
    }
}
