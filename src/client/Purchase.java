package client;
import java.util.ArrayList;
import product.*;
import date.*;
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


public class Purchase{
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
        Purchase newPurchase = new Purchase();
        String[] purchaseAtributes = {"date", "reference", "price", "products"};
        int atrib = 0;
        String words = "";

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (purchaseAtributes[atrib].equals("date")) {
                    newPurchase.setPurchaseDate(Date.convertStringToDate(words));
                }
                if (purchaseAtributes[atrib].equals("reference")) {
                    int reference;
                    try {
                        reference = Integer.parseInt(words);
                    }
                    catch (NumberFormatException nfe) {
                        reference = -1;
                    }
                    newPurchase.setPurchaseReference(reference);
                }
                if (purchaseAtributes[atrib].equals("products")) {
                    Product newProduct = Product.separateProductInfo(words);
                    newPurchase.addToPurchasedProducts(newProduct);
                    --atrib;
                }
                
                words = "";
                ++atrib;
            }

            else {
                words += line.charAt(i);
            }
        }
        
        return newPurchase;
    }
 
    

}
