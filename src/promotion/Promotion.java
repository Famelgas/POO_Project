package promotion;
import java.io.Serializable;
import product.Product;
import date.Date;



public class Promotion implements Serializable {
    protected Date startDate;
    protected Date endDate;
    protected String promotionType;

    /**
     * Promotion's constructor
     */
    public Promotion() {}

    /**
     * Promotion's constructor
     */
    public Promotion(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promotionType = "No promotion";
    }
    
    
    /**
     * StartDate getter
     * 
     * @return Date returns startDate
     */
    public Date getStartDate() {
        return startDate;
    }

    
    /**
     * StartDate setter
     * 
     * @param startDate - startDate to be set
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
    /**
     * EndDate getter
     * 
     * @return Date - returns endDate
     */
    public Date getEndDate() {
        return endDate;
    }

    
    /**
     * EndDate setter
     * 
     * @param endDate - endDate to be set
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    /**
     * PromotionType getter
     * 
     * @return String - returns promotionType
     */
    public String getPromotionType() {
        return promotionType;
    }

    
    /**
     * PromotionType setter
     * 
     * @param promotionType - promotionType to be set
     */
    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }


    
    /** 
     * Calculates the pruchase price
     * @param product - product to buy
     * @return float - returns price
     */
    public float priceCalculator(Product product) {
        return product.getUnitPrice();
    }

    
    /**
     * Override String.toString()
     * 
     * @return String - converted string
     */
    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + promotionType;
    }


    
    /** 
     * Verifies if the promotion is still valid
     * @param date - date to be used 
     * @return boolean - true if date is between startDate and endDate and false if not
     */
    public boolean verifyPromotion(Date date) {
        if (date.compareDates(startDate) < 0 || date.compareDates(endDate) > 0) {
            return false;
        }
        return true;
    }

}
