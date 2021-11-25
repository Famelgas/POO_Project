package purchase;
import java.util.ArrayList;
import java.util.ArrayList;
import product.*;

public class PayLess extends Promotion {
    public PayLess() {}
    
    public PayLess(String promotionType) {
        super(promotionType);
    }

    public double priceCalculator(Product product){
        ArrayList <Double> array;
        double discount = 0.05;
        double finalPrice = 0;
        for (int i = 0; i < product.getStock(); i++ ){
            if (product.getStock() == 1){
                finalPrice = product.getUnitPrice();
            }
            else{
                double discountedProduct = product.getUnitPrice() - (i*discount);
                array.add(discountedProduct);
            }
        }
        for (Double discountedProduct : array) {
            finalPrice += discountedProduct;
        }
        return finalPrice;
    }
        
    

}
