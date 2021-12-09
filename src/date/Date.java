package date;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.time.LocalDateTime;
import date.Date;

/**
 * Cass Date - manages date related methods
 */
public class Date implements Serializable{
    private int day;
    private int month;
    private int year;

    /**
     * Date's constructor
     */
    public Date() {}
    
    /**
     * Date's constructor
     * @param day - day
     * @param month - month
     * @param year - year
     */
    public Date (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    
    /** 
     * Day getter
     * @return int - day
     */
    public int getDay() {
        return day;
    }

    
    /** 
     * Day setter
     * @param day - day to be set
     */
    public void setDay(int day) {
        this.day = day;
    }

    
    /**
     * Month getter
     * @return int - month
     */
    public int getMonth() {
        return month;
    }

    
    /**
     * Month setter
     * @param month - month to be set
     */
    public void setMonth(int month) {
        this.month = month;
    }

    
    /**
     * Year getter
     * @return int - year
     */
    public int getYear() {
        return year;
    }

    
    /**
     * Year setter
     * @param year - year to be set
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    
    
    /**
     * Converts a string to a date 
     * @param strDate - Date string
     * @return Date - return a new date
     */
    public static Date convertStringToDate(String strDate) {
        Date date = new Date();
        String numStr = "";
        int atrib = 1;        
        
        for (int i = 0; i < strDate.length(); ++i) {
            if (!Character.isDigit(strDate.charAt(i))) {
                int num;
                try {
                    num = Integer.parseInt(numStr);
                } catch (NumberFormatException nfe) {
                    num = -1;
                }
                switch (atrib) {
                    case 1 -> date.setDay(num);
                    case 2 -> date.setMonth(num);
                    case 3 -> date.setYear(num);
                    default -> {
                        date.setDay(-1);
                        date.setMonth(-1);
                        date.setYear(-1);
                    }
                }
                ++atrib;
                numStr = "";
            }   
            else if (i + 1 == strDate.length()) {
                numStr += strDate.charAt(i);
                int num;
                try {
                    num = Integer.parseInt(numStr);
                } catch (NumberFormatException nfe) {
                    num = -1;
                }
                date.setYear(num);
            }
            else {
                numStr += strDate.charAt(i);
            }
        }
        
        return date;
    }
    
    
    
    /** 
     * @return Date
     */
    public static Date getLocalDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String strDate = dtf.format(now);
        return convertStringToDate(strDate);
    }
    
    
    
    
    /** 
     * @return String
     */
    public String toString() {
        return day + "/" + month + "/" + year; 
    }

    
    /** 
     * @param dateToVerify - date to verify
     * @return boolean
     */
    public boolean equals(Date dateToVerify) {
        return this.day == dateToVerify.getDay() && this.month == dateToVerify.getMonth() && this.year == dateToVerify.getYear();
    } 

    
    /** 
     * @param date - date 
     * @return int - 1 if the given date is bigger, 0 if they are equal and -1 if the given date is lower
     */
    public int compareDates(Date date) {
        if (this.day < date.getDay() && this.month < date.getMonth() && this.year < date.getYear()) {
            return -1;
        }
        if (this.day > date.getDay() && this.month > date.getMonth() && this.year > date.getYear()) {
            return 1;
        }
        return 0;
    }

}
