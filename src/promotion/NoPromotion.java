package promotion;
import product.*;

/**
 * Class NoPromotion - extends promotion: no promotion
 */
public class NoPromotion extends Promotion {
    /**
     * NoPromotion's constructor
     */
    public NoPromotion() {
        this.startDate = null;
        this.endDate = null;
        this.promotionType = "No promotion";
    }

    
    /**
     * Calculates the pruchase price
     * 
     * @param product - product to buy
     * @return float - returns price
     */
    public float priceCalculator(Product product) {
        return product.getUnitPrice() * product.getAmountToBuy();
    }

    
    /**
     * Override String.toString()
     * 
     * @return String - converted string
     */
    public String toString() {
        return "Nenhuma promoção disponível";
    }
}
