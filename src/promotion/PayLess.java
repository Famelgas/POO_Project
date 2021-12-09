package promotion;
import java.util.ArrayList;
import product.*;
import date.Date;

public class PayLess extends Promotion {
    /**
     * PayLess's constructor
     */
    public PayLess() {}

    /**
     * PayLess's constructor
     */
    public PayLess(Date startDate, Date endDate) {
        super(startDate, endDate);
        this.promotionType = "Pay less";
    }

    
    /**
     * Calculates the pruchase price
     * 
     * @param product - product to buy
     * @return float - returns price
     */
    public float priceCalculator(Product product){
        float discount = 0.05f;
        float finalPrice = 0;
        float tempPrice = 0;
        ArrayList<Float> descountedPrices = new ArrayList<>();
        if (product.getAmountToBuy() == 1){
            finalPrice = product.getUnitPrice();
        }
        else {
            int temp = 0;
            for (int i = 0; i < product.getAmountToBuy(); ++i) {
                for (Float price : descountedPrices) {
                    System.out.println(price);
                    tempPrice += price;
                }
                if (tempPrice >= (product.getUnitPrice() * product.getAmountToBuy()) / 2) {
                    descountedPrices.add(product.getUnitPrice() - (product.getUnitPrice() * (i * discount)));   
                    ++temp;
                }
                else {
                    descountedPrices.add(product.getUnitPrice() - (product.getUnitPrice() * ((temp - 1) * discount)));
                }
            }
        }
        for (Float price : descountedPrices) {
            System.out.println(price);
            finalPrice += price;
        }

        return finalPrice;
    }

    
    /**
     * Override String.toString()
     * 
     * @return String - converted string
     */
    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague menos";
    }

}