package sale;
import product.*;

public class PayLess extends Sale {
    public PayLess() {}

    public PayLess(String promotionType) {
        super(promotionType); 
    }

    public float priceCalculator(int numberPurchased,float unitPrice){
        float finalPrice = 0;
        float discount = (100-(5*numberPurchased))/100;
        if (discount >= 50){
            discount = 50;
        }
        finalPrice = unitPrice*discount;
        return finalPrice;
    }

}
