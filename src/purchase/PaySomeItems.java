package purchase;

public class PaySomeItems {
    public PaySomeItems() {}

    public float priceCalculator(int numberPurchased, float unitPrice){
        float finalPrice = 0;
        for(int i = 0; i < numberPurchased; i++){
            if(i % 4 != 0){
                finalPrice = finalPrice + unitPrice;
            }
        }

        return finalPrice;
    }

}
