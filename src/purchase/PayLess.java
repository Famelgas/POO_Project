package purchase;
import product.*;

public class PayLess extends Promotion {
    public PayLess() {}
    
    public PayLess(String promotionType) {
        super(promotionType);
    }


    public float priceCalculator(Product product) {
        float finalPrice = 0;
        int numberOfProducts = product.getStock();
    
        


        return finalPrice;
    }

}
