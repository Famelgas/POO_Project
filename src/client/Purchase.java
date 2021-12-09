package client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;
import product.*;
import date.Date;

// revise class Purchase: pra mantermos um historico de compras do cliente
// temos que ter um arraylist das compras que ele ja fez, a minha questao e 
// como guardar a informaçao dos items comprados, podemos usar a class Purchase
// pra isso, usando um arraylist de Products, e guardando um arraylist de Purchases 
// em cada client. Porem vamos ter que mudar um bocado a estrutura das compras e 
// promoções
// acho que as promoções nao deviam herdar class nenhuma, simplesmente em cada produto
// ter um atributo promoçao, e assim poderiamos usar esta classe para manter o historico.
// ate porque nao faz sentido ter esta classe pras promoçoes, pq uma compra normal 
// simplesmente nao tem promoçao.




// falar com a professora sobre a inicializaçao de arraylists nos construtores das classes
// deve ser inicializado sempre? apesar de poder criar uma nova compra sem adicionar 
// produto nenhum previamente tenho sempre que ser capaz de adicionar mais a frente se eu quiser


public class Purchase implements Serializable {
    private Date date;
    private int reference;
    private float purchasePrice;
    private int shippingPrice;
    private float totalPrice;
    private ArrayList<Product> purchasedProducts;


    public Purchase() {
        this.purchasedProducts = new ArrayList<>();
    }
    
    public Purchase(Date date) {
        this.purchasedProducts = new ArrayList<>();
        this.date = date;
    }  

    
    /** 
     * @return Date
     */
    public Date getPurchaseDate() {
        return date;
    }

    
    /** 
     * @param date
     */
    public void setPurchaseDate(Date date) {
        this.date = date;
    }

    
    /** 
     * @return int
     */
    public int getPurchaseReference() {
        return reference;
    }

    
    /** 
     * @param reference
     */
    public void setPurchaseReference(int reference) {
        this.reference = reference;
    }

    
    /** 
     * @return float
     */
    public float getPurchasePrice() {
        return purchasePrice;
    }

    
    /** 
     * @param purchasePrice
     */
    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
   
    }
    
    /** 
     * @return float
     */
    public float getShippingPrice() {
        return shippingPrice;
    }

    
    /** 
     * @param shippingPrice
     */
    public void setShippingPrice(int shippingPrice) {
        this.shippingPrice = shippingPrice;
    }
   
    
    /** 
     * @return float
     */
    public float getTotalPrice() {
        return totalPrice;
    }

    
    /** 
     * @param purchasePrice
     * @param shippingPrice
     * @return float
     */
    public float getTotalPrice(float purchasePrice, int shippingPrice) {
        return purchasePrice + shippingPrice;
    }

    
    /** 
     * @param purchasePrice
     * @param shippingPrice
     */
    public void setTotalPrice(float purchasePrice, int shippingPrice) {
        this.totalPrice = purchasePrice + shippingPrice;
    }

    
    /** 
     * @param totalPrice
     */
    public void setTotalPrice(float totalPrice) {
        this.totalPrice = totalPrice;
    }

    
    /** 
     * @return ArrayList<Product>
     */
    public ArrayList<Product> getPurchadeProducts() {
        return purchasedProducts;
    }

    
    /** 
     * @param purchasedProducts
     */
    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    
    /** 
     * @param product
     */
    public void addToPurchasedProducts(Product product) {
        purchasedProducts.add(product);
    }

    
    /** 
     * @param priceToRaise
     */
    public void raisePurchasePrice(float priceToRaise) {
        this.purchasePrice += priceToRaise;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "Date: " + date + "\nReference: " + reference + "\nPurchase price: " + purchasePrice + "\nShipping price: " + shippingPrice + "\nTotal price: " + totalPrice + "\nPurchased roducts:\n" + purchasedProducts.toString().substring(1, purchasedProducts.toString().length() - 1);
    }

    /**
     * Separates purchase information for a client given by a .txt file
     * @param line - purchase information
     * @return - return a new Purchase;
     */
    public Purchase separatePurchaseInfo(Scanner lineSc) {
        Purchase purchase = new Purchase();
        lineSc.useDelimiter("\\s*:\\s*");

        purchase.setPurchaseDate(Date.convertStringToDate(lineSc.next()));
        purchase.setPurchaseReference(lineSc.nextInt());
        purchase.setPurchasePrice(lineSc.nextFloat());
        purchase.setShippingPrice(lineSc.nextInt());
        purchase.setTotalPrice(lineSc.nextFloat());

        while(lineSc.hasNext()) {
            Scanner tempLineSc = new Scanner(lineSc.next());
            Product newProduct = Product.getProductType(tempLineSc);
            newProduct = newProduct.separateProductInfo(tempLineSc);
            if (newProduct == null) {
                System.out.println("Error product object is null");
            }
            purchase.addToPurchasedProducts(newProduct);
            tempLineSc.close();
        }
        
        return purchase;
    }
 

    
    /** 
     * @return int
     */
    public static int createReference() {
        Random rand = new Random();
        int ref = 10000000 + rand.nextInt(999999999);
        return ref;
    }


    
    /** 
     * @param client
     * @param purchase
     * @return int
     */
    public int calculateShippingPrice(Client client, Purchase purchase) {
        int shippingPrice = 0;

        if (client.getFrequent()) {
            if (purchase.getPurchasePrice() <= 40) {
                shippingPrice = 15;
            }
        }

        else {
            shippingPrice = 20;
        }

        for (Product product : purchase.getPurchadeProducts()) {
            if (product.getProductType().equals("Furniture")) {
                shippingPrice += 10;
            }
        }
        return shippingPrice;
    }

}
