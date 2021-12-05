package promotion;
import product.*;

public class NoPromotion extends Promotion {
    public NoPromotion() {
        this.startDate = null;
        this.endDate = null;
        this.promotionType = "No promotion";
    }

    public float priceCalculator(Product product) {
        float unitPrice = product.getUnitPrice();
        int numberOfProducts = product.getStock();
        return unitPrice * numberOfProducts;
    }

    public String toString() {
        return "Nenhuma promoção disponível";
    }
}
