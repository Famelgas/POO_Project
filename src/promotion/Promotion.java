package promotion;
import java.io.Serializable;
import product.Product;
import date.Date;



public class Promotion implements Serializable {
    protected Date startDate;
    protected Date endDate;
    protected String promotionType;

    public Promotion() {}

    public Promotion(Date startDate, Date endDate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.promotionType = "No promotion";
    }
    
    
    /** 
     * @return Date
     */
    public Date getStartDate() {
        return startDate;
    }

    
    /** 
     * @param startDate
     */
    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    
    /** 
     * @return Date
     */
    public Date getEndDate() {
        return endDate;
    }

    
    /** 
     * @param endDate
     */
    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    
    /** 
     * @return String
     */
    public String getPromotionType() {
        return promotionType;
    }

    
    /** 
     * @param promotionType
     */
    public void setPromotionType(String promotionType) {
        this.promotionType = promotionType;
    }


    
    /** 
     * @param product
     * @return float
     */
    public float priceCalculator(Product product) {
        return product.getUnitPrice();
    }

    
    /** 
     * @return String
     */
    public String toString() {
        return "\nStarting date: " + startDate + "\nEnding date: " + endDate + "\nPromotion type: " + promotionType;
    }


    
    /** 
     * @param date
     * @return boolean
     */
    public boolean verifyPromotion(Date date) {
        if (date.compareDates(startDate) < 0 || date.compareDates(endDate) > 0) {
            return false;
        }
        return true;
    }

}
