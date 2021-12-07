package promotion;
import product.*;

public class NoPromotion extends Promotion {
    public NoPromotion() {
        this.startDate = null;
        this.endDate = null;
        this.promotionType = "No promotion";
    }

    public float priceCalculator(Product product) {
        return product.getUnitPrice() * product.getStock();
    }

    public String toString() {
        return "Nenhuma promoção disponível";
    }
}
