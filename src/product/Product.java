package product;
import java.io.Serializable;
import java.lang.String;
import promotion.*;
import date.Date;

public class Product implements Serializable {
    protected String productType; 
    protected int identifier;
    protected String name;
    protected float unitPrice;
    protected int stock;
    // falta fazer getter e setter da promotion
    // perguntar a prof se pode ou nao ser abstrata
    protected Promotion promotion;

    public Product() {}

    public Product(String productType, int identifier, String name, float unitPrice, int stock) {
        this.productType = productType;
        this.identifier = identifier;
        this.name = name;
        this.unitPrice = unitPrice;
        this.stock = stock;
        
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public int getIdentifier() {
        return identifier;
    }

    public void setIdentifier(int identifier) {
        this.identifier = identifier;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public float getUnitPrice() {
        return unitPrice;
    }

    public void setUnitPrice(float unitPrice) {
        this.unitPrice = unitPrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    public Promotion getPromotion() {
        return promotion;
    }

    public void setPromotion(Promotion promotion) {
        this.promotion = promotion;
    }

    public String toString() {
        return "Type: " + productType + "\nIdentifier: " + identifier + "\nName: " + name + "\nPrice per unit: " + unitPrice + "\nStock: " + stock + "\nPromotion: " + promotion.toString();
    }

    public Promotion getProductPromotion(String promoType, String strStartDate, String strEndDate) {
        Promotion promotion = switch (promoType) {
            case "No promotion" -> new NoPromotion();
            case "Pay less" -> new PayLess(Date.convertStringToDate(strStartDate), Date.convertStringToDate(strEndDate));
            case "Pay some items" -> new PaySomeItems(Date.convertStringToDate(strStartDate), Date.convertStringToDate(strEndDate));
            default -> new Promotion();
        };
        return promotion;   
    }



    public static Product getProductType(String line) {
        String[] productType = { "Cleaning", "Food", "Furniture" };
        String words = "";

        for (int i = 0; i < line.length(); ++i) {
            if (line.charAt(i) == ';' || line.charAt(i) == '\n') {
                if (productType[0].equals(words)) {
                    return new Cleaning();
                }
                if (productType[1].equals(words)) {
                    return new Food();
                }
                if (productType[2].equals(words)) {
                    return new Furniture();
                }
            }

            else {
                words += line.charAt(i);
            }
        }

        return null;
    }

    // Separates the string so we can create a new product
    public Product separateProductInfo(String line) {
        Product newProduct = new Product();
        String[] atributes = {"type", "identifier", "name", "unitPrice", "stock", "promoType", "startDate", "endDate"};
        int atrib = 0;
        String[] words = line.split("[;:]+");

        for (int i = 0; i < words.length; ++i) {

            if (atributes[atrib].equals("type")) {
                newProduct.setProductType("Cleaning");
                ++atrib;
            }

            if (atributes[atrib].equals("identifier")) {
                int ident;
                try {
                    ident = Integer.parseInt(words[i]);
                } catch (NumberFormatException nfe) {
                    ident = -1;
                }
                newProduct.setIdentifier(ident);
                ++atrib;
            }

            if (atributes[atrib].equals("name")) {
                newProduct.setName(words[i]);
                ++atrib;
            }

            if (atributes[atrib].equals("unitPrice")) {
                float price;
                try {
                    price = Float.parseFloat(words[i]);
                } catch (NumberFormatException nfe) {
                    price = -1;
                }
                newProduct.setUnitPrice(price);
                ++atrib;
            }

            if (atributes[atrib].equals("stock")) {
                int stock;
                try {
                    stock = Integer.parseInt(words[i]);
                } catch (NumberFormatException nfe) {
                    stock = -1;
                }
                newProduct.setStock(stock);
                ++atrib;
            }

            if (atributes[atrib].equals("promoType")) {
                Promotion promotion = newProduct.getProductPromotion(words[i], words[i + 1], words[i + 2]);
                newProduct.setPromotion(promotion);
                break;
            }

        }

        return newProduct;
    }
}
