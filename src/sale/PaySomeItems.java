package sale;

public class PaySomeItems extends Sale {
    public PaySomeItems() {}

    public PaySomeItems(String promotionType) {
        super(promotionType);
    }

    public float priceCalculator(int numberPurchased,float unitPrice){
        float finalPrice = 0;
        for(int i = 0; i < numberPurchased; i++){
            if(i%4 != 0){
                finalPrice = finalPrice + unitPrice;
            }
        }

        return finalPrice;
    }

}
