package promotion;
import product.*;
import date.Date;

public class PayLess extends Promotion {
    public PayLess() {}

    public PayLess(Date startDate, Date endDate) {
        super(startDate, endDate);
        this.promotionType = "Pay less";
    }

    public float priceCalculator(Product product){
        float discount = 0.05f;
        float finalPrice = 0;
        for (int i = 0; i < product.getStock(); i++ ){
            if (product.getStock() == 1){
                finalPrice = product.getUnitPrice();
            }
            else{
                finalPrice = product.getUnitPrice() - (i * discount);
            }
        }
        return finalPrice;
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague menos";
    }

}