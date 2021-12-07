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
        float price = 0;
        System.out.println(product.getStock() + " " + product.getUnitPrice());
        if ((product.getStock() % 4) == 0) {
            price += product.getUnitPrice() * product.getStock() - (product.getStock() / 4);
        }
        else {
            int descountedProducts = product.getStock() - (product.getStock() % 4);
            float descountedPrice = product.getUnitPrice() * descountedProducts - (descountedProducts / 4);
            price += descountedPrice + ((product.getStock() % 4) * product.getUnitPrice());
        }
        
        System.out.println(price);
        
        return price;
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague 3 leve 4";
    }
}
