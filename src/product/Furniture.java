package product;
import java.lang.String;
import java.util.Scanner;

public class Furniture extends Product {
    private float height;
    private float width;
    private float depth;
    private float weight;

    public Furniture() {
        this.productType = "Furniture";
    }

    public Furniture(float height, float width, float depth, float weight) {
        this.height = height;
        this.width = width;
        this.depth = depth;
        this.weight = weight;
        this.productType = "Furniture";
    }

    
    /** 
     * @return float
     */
    public float getHeight() {
        return height;
    }

    
    /** 
     * @param height
     */
    public void setHeight(float height) {
        this.height = height;
    }

    
    /** 
     * @return float
     */
    public float getWidth() {
        return width;
    }

    
    /** 
     * @param width
     */
    public void setWidth(float width) {
        this.width = width;
    }

    
    /** 
     * @return float
     */
    public float getDepth() {
        return depth;
    }

    
    /** 
     * @param depth
     */
    public void setDepth(float depth) {
        this.depth = depth;
    }

    
    /** 
     * @return float
     */
    public float getWeight() {
        return weight;
    }

    
    /** 
     * @param weight
     */
    public void setWeight(float weight) {
        this.weight = weight;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "\nType: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString() + "\nHeight: " + height + "\nWidth" + width + "\nDepth: " + depth + "\nWeight: " + weight;
    }


    
    /** 
     * @param lineSc
     * @return Product
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
