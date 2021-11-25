package purchase;
import product.*;

public class NoPromotion extends Promotion{
    public NoPromotion() {}

    public NoPromotion(String promotionType) {
        super(promotionType);
    }

    public float priceCalculator(Product product) {
        float unitPrice = product.getUnitPrice();
        int numberOfProducts = product.getStock();
        return unitPrice * numberOfProducts;
    }
}
