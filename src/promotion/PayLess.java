package promotion;
import java.util.ArrayList;
import product.*;
import date.Date;

public class PayLess extends Promotion {
    public PayLess() {}

    public PayLess(Date startDate, Date endDate) {
        super(startDate, endDate);
        this.promotionType = "Pay less";
    }

    
    /** 
     * @param product
     * @return float
     */
    public float priceCalculator(Product product){
        float discount = 0.05f;
        float finalPrice = 0;
        ArrayList<Float> descountedPrices = new ArrayList<>();
        if (product.getStock() == 1){
            finalPrice = product.getUnitPrice();
        }
        else {
            for (int i = 0; i < product.getStock(); i++ ){
                descountedPrices.add(product.getUnitPrice() - (product.getUnitPrice() * (i * discount)));   
            }
        }
        for (Float price : descountedPrices) {
            System.out.println(price);
            finalPrice += price;
        }

        return finalPrice;
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague menos";
    }

}