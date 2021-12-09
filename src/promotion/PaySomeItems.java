package promotion;
import product.*;


import date.Date;

public class PaySomeItems extends Promotion {
    /**
     * PaySomeItems's constructor
     */
    public PaySomeItems() {}
    
    /**
     * PaySomeItems's constructor
     */
    public PaySomeItems(Date startDate, Date endDate) {
        super(startDate, endDate);
        this.promotionType = "Pay some items";
    }

    
    /**
     * Calculates the pruchase price
     * 
     * @param product - product to buy
     * @return float - returns price
     */
    public float priceCalculator(Product product) {
        float price = 0;
        if (product.getAmountToBuy() <= 3) {
            price = product.getUnitPrice() * product.getAmountToBuy();
        }
        else {
            if ((product.getAmountToBuy() % 4) == 0) {
                price += product.getUnitPrice() * (product.getAmountToBuy() - (product.getAmountToBuy() / 4));
            }
            else {
                int noDescount = product.getAmountToBuy() % 4;
                int descountedProducts = product.getAmountToBuy() - noDescount;
                price += product.getUnitPrice() * (descountedProducts - (descountedProducts / 4));
                price += product.getUnitPrice() * noDescount;
            }
        }
        
        return price;
    }

    
    /**
     * Override String.toString()
     * 
     * @return String - converted string
     */
    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague 3 leve 4";
    }
}
