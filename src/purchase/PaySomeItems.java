package purchase;
import product.*;

public class PaySomeItems extends Promotion {
    public PaySomeItems() {}
    
    public PaySomeItems(String promotionType) {
        super(promotionType);
    }

    // Pague 3 leve 4
    // verificar se funciona
    public float priceCalculator(Product product) {
        int numberOfProducts = product.getStock();
        float price = 0;
        if ((numberOfProducts % 4) == 0) {
            price = product.getUnitPrice() * numberOfProducts - (numberOfProducts / 4);
        }
        else {
            int descountedProducts = numberOfProducts - (numberOfProducts % 4);
            float descountedPrice = product.getUnitPrice() * descountedProducts - (descountedProducts / 4);
            price = descountedPrice + ((numberOfProducts % 4) * product.getUnitPrice());
        }
        
        return price;
    }

}
