package promotion;
import product.*;

public class NoPromotion extends Promotion {
    public NoPromotion() {
        this.startDate = null;
        this.endDate = null;
        this.promotionType = "No promotion";
    }

    
    /** 
     * @param product
     * @return float
     */
    public float priceCalculator(Product product) {
        return product.getUnitPrice() * product.getAmountToBuy();
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "Nenhuma promoção disponível";
    }
}
