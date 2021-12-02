package promotion;
import product.*;
import date.Date;

public class NoPromotion extends Promotion{
    public NoPromotion() {}

    public NoPromotion(Date startDate, Date endDate, String promotionType) {
        super(startDate, endDate, promotionType);
    }

    public float priceCalculator(Product product) {
        float unitPrice = product.getUnitPrice();
        int numberOfProducts = product.getStock();
        return unitPrice * numberOfProducts;
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "No promotion available";
    }
}
