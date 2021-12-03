package promotion;
import product.*;

public class NoPromotion extends Promotion {
    public NoPromotion() {
        this.promotionType = "No promotion";
    }

    public float priceCalculator(Product product) {
        float unitPrice = product.getUnitPrice();
        int numberOfProducts = product.getStock();
        return unitPrice * numberOfProducts;
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Nenhuma promoção disponível";
    }
}
