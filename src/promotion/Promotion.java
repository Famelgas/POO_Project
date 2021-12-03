package promotion;
import product.Product;

import java.io.Serializable;

import date.Date;

public class Promotion implements Serializable {
    protected Date startDate;
    protected Date endDate;
    protected String promotionType;

    public Promotion() {}

    public Promotion(Date startDate, Date endDate, String promotionType) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promotionType = promotionType;
    }
    
    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getPromotionType() {
        return promotionType;
    }

    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }


    public float priceCalculator(Product product) {
        return product.getUnitPrice();
    }

    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + promotionType;
    }
}
