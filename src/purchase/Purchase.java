package purchase;
import java.util.ArrayList;
import product.*;


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
    private ArrayList<Product> purchasedProducts;


    public Purchase() {
        this.purchasedProducts = new ArrayList<>();
    }
    
    public Purchase(Product product) {
        this.purchasedProducts = new ArrayList<>();
        purchasedProducts.add(product);
    }

    public void addToPurchasedProducts(Product product) {
        purchasedProducts.add(product);
    }

}
