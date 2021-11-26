package promotion;
import product.Product;

public class Promotion {
    protected String promotionType;

    public Promotion() {}

    public Promotion(String promotionType) {
        this.promotionType = promotionType;
    }

    public float priceCalculator(Product product) {
        return product.getUnitPrice();
    }
}
