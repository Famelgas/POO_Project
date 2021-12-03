package promotion;
import product.*;


import date.Date;

public class PaySomeItems extends Promotion {
    public PaySomeItems() {}
    
    public PaySomeItems(Date startDate, Date endDate) {
        super(startDate, endDate);
        this.promotionType = "Pay some items";
    }

    // Pague 3 leve 4
    // verificar se funciona
    public float priceCalculator(Product product) {
        int numberOfProducts = product.getStock();
        float price = 0;
        if ((numberOfProducts % 4) == 0) {
            price = product.getUnitPrice() * numberOfProducts - (numberOfProducts / 4);
        }
        else {
            int descountedProducts = numberOfProducts - (numberOfProducts % 4);
            float descountedPrice = product.getUnitPrice() * descountedProducts - (descountedProducts / 4);
            price = descountedPrice + ((numberOfProducts % 4) * product.getUnitPrice());
        }
        
        return price;
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague 3 leve 4";
    }
}
