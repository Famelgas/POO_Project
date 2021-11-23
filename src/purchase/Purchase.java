package purchase;
import java.lang.Math;

public class Purchase{
    // Each sale can be normal or have two types of promotion
    private String promotionType;
    
    public Purchase() {}
    
    public Purchase(String promotionType) {
        this.promotionType = promotionType;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotion) {
        this.promotionType = promotion;
    }

    public Purchase createNewSale() {
        Purchase newSale;
        // generate a promotion randomly
        // for now I'm using math.random but it can change
        int promType = (int) (Math.random() * ((101 - 0) + 101));
        
        if (promType > 85 && promType <= 90) {
            newSale = new PayLess("pay less");
        }

        if (promType > 90 && promType <= 100) {
            newSale = new PaySomeItems("pay 3 take 4");
        }

        newSale = new Purchase("none");

        return newSale;
    }
    
    public float priceCalculator(int numberPurchased, float unitPrice){
        return unitPrice * numberPurchased;
    }


}
