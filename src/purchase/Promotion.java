package purchase;

public abstract class Promotion {
    protected String promotionType;

    public Promotion() {}

    public Promotion(String promotionType) {
        this.promotionType = promotionType;
    }
}
