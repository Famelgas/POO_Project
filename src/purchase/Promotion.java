package purchase;
import product.Product;

public abstract class Promotion {
    protected String promotionType;

    public Promotion() {}

    public Promotion(String promotionType) {
        this.promotionType = promotionType;
    }

    public abstract float priceCalculator(Product product);
}
