public class Sale {
    // Each sale can be normal or have two types of promotion
    private String promotionType;
    
    public Sale() {}
    
    public Sale(String type) {
        this.promotionType = promotionType;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }
}
