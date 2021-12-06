package client;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Random;
import product.*;
import date.Date;
import database.FormatText;

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
    private ArrayList<Product> purchasedProducts;


    public Purchase() {
        this.purchasedProducts = new ArrayList<>();
    }
    
    public Purchase(Date date) {
        this.purchasedProducts = new ArrayList<>();
        this.date = date;
    }  

    public Date getPurchaseDate() {
        return date;
    }

    public void setPurchaseDate(Date date) {
        this.date = date;
    }

    public int getPurchaseReference() {
        return reference;
    }

    public void setPurchaseReference(int reference) {
        this.reference = reference;
    }

    public float getPurchasePrice() {
        return purchasePrice;
    }

    public void setPurchasePrice(float purchasePrice) {
        this.purchasePrice = purchasePrice;
    }

    public ArrayList<Product> getPurchadeProducts() {
        return purchasedProducts;
    }

    public void setPurchasedProducts(ArrayList<Product> purchasedProducts) {
        this.purchasedProducts = purchasedProducts;
    }

    public void addToPurchasedProducts(Product product) {
        purchasedProducts.add(product);
    }

    public void raisePurchasePrice(float priceToRaise) {
        this.purchasePrice += priceToRaise;
    }

    public void showPurchase() {
        System.out.println("Purchase date: " + date + "\nReference: " + reference + "\nTotal payed: " + purchasePrice);
        FormatText.intermidietLine();
        for (Product product : purchasedProducts) {
            System.out.println(product);
            FormatText.intermidietLine();
        } 
    }

    /**
     * Separates purchase information for a client given by a .txt file
     * @param line - purchase information
     * @return - return a new Purchase;
     */
    public static Purchase serparatePurchaseInfo(String line) {
        Purchase purchase = new Purchase();
        String[] purchaseAtributes = {"date", "reference", "price", "products"};
        int atrib = 0;
        line = line.strip();
        String words[] = line.split("[;:]+");

        for (int i = 0; i < words.length; ++i) {
            if (purchaseAtributes[atrib].equals("date")) {
                Date date = Date.convertStringToDate(words[i]);
                purchase.setPurchaseDate(date);
                ++atrib;
            }

            if (purchaseAtributes[atrib].equals("reference")) {
                int ref;
                try {
                    ref = Integer.parseInt(words[i]);
                } catch (NumberFormatException nfe) {
                    ref = -1;
                }
                purchase.setPurchaseReference(ref);
                ++atrib;
            }
            
            if (purchaseAtributes[atrib].equals("price")) {
                float price;
                try {
                    price = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    price = -1;
                }
                purchase.setPurchasePrice(price);
                ++atrib;
            }

            if (purchaseAtributes[atrib].equals("products")) {
                if (words[i].equals("Cleaning") || words[i].equals("Food") || words[i].equals("Furniture")) {
                    int infoNum = 1;
                    while (!words[i + 1].equals("Cleaning") || !words[i + 1].equals("Food") || !words[i + 1].equals("Furniture") || (i + 1) != words.length) {
                        ++infoNum;
                    }
                    String productInfo = "";
                    for (int j = 0; j < infoNum; ++j) {
                        productInfo = productInfo + words[i] + ";";
                    }

                    Product product = Product.getProductType(line);
                    
                    purchase.addToPurchasedProducts(product.separateProductInfo(productInfo));
                }

            }
        }
        
        
        return purchase;
    }
 

    public static int createReference() {
        Random rand = new Random();
        int ref = 10000000 + rand.nextInt(999999999);
        return ref;
    }
    

}
