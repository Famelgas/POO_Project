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

    public float priceCalculator(Product product){
        ArrayList <Float> array = new ArrayList<>();
        float discount = 0.05f;
        float finalPrice = 0;
        for (int i = 0; i < product.getStock(); i++ ){
            if (product.getStock() == 1){
                finalPrice = product.getUnitPrice();
            }
            else{
                float discountedProduct = product.getUnitPrice() - (i*discount);
                array.add(discountedProduct);
            }
        }
        for (Float discountedProduct : array) {
            finalPrice += discountedProduct;
        }
        return finalPrice;
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + "Pague menos";
    }

}