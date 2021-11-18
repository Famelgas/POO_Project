package sale;
import product.*;

public class PayLess extends Sale {
    public PayLess() {}

    public PayLess(String promotionType) {
        super(promotionType); 
    }

    public float calculatePrice(Product product, int quantity) {
        unitPrice = product.getPrice();
        return unitPrice * quantity; 
    }

}
