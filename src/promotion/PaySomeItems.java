package promotion;
import product.*;


import date.Date;

public class PaySomeItems extends Promotion {
    public PaySomeItems() {}
    
    public PaySomeItems(Date startDate, Date endDate) {
        super(startDate, endDate);
        this.promotionType = "Pay some items";
    }

    
    /** 
     * @param product
     * @return float
     */
    // Pague 3 leve 4
    // verificar se funciona
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
     * @return String
     */
    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague 3 leve 4";
    }
}
