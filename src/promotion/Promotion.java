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

    public Promotion getProductPromotion(String line, int i, Date date) {
        Promotion promotion = new Promotion();
        String[] promoAtributes = {"promoType", "startDate", "endDate"};
        // by default the product has no promotion
        Date startDate = new Date(); 
        Date endDate = new Date();
        String words = ""; 
        int atrib = 0;

        for (++i; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (promoAtributes[atrib].equals("promoType")) {
                    if (words.equals("No promotion")) {
                        return new NoPromotion();
                    }
                    if (words.equals("Pay less")) {
                        promotion = new PayLess();
                        ++atrib;
                    }
                    if (words.equals("Pay some items")) {
                        promotion = new PaySomeItems();
                        ++atrib;
                    }
                }
    
                if (promoAtributes[atrib].equals("startDate")) {
                    startDate = Date.convertStringToDate(words);
                    promotion.setStartDate(startDate);
                    ++atrib;
                }
    
                if (promoAtributes[atrib].equals("endDate")) {
                    endDate = Date.convertStringToDate(words);
                    promotion.setEndDate(endDate);
                }

                words = "";
            }

            else {
                words += line.charAt(i);
            }

        }

        return promotion;
    }
}
