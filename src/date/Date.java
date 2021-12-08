package date;
import java.time.format.DateTimeFormatter;
import java.io.Serializable;
import java.time.LocalDateTime;
import date.Date;

public class Date implements Serializable{
    private int day;
    private int month;
    private int year;

    public Date() {}

    public Date (int day, int month, int year) {
        this.day = day;
        this.month = month;
        this.year = year;
    }

    
    /** 
     * @return int
     */
    public int getDay() {
        return day;
    }

    
    /** 
     * @param day
     */
    public void setDay(int day) {
        this.day = day;
    }

    
    /** 
     * @return int
     */
    public int getMonth() {
        return month;
    }

    
    /** 
     * @param month
     */
    public void setMonth(int month) {
        this.month = month;
    }

    
    /** 
     * @return int
     */
    public int getYear() {
        return year;
    }

    
    /** 
     * @param year
     */
    public void setYear(int year) {
        this.year = year;
    }
    
    
    
    /** 
     * @param strDate
     * @return Date
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
     * @param dateToVerify
     * @return boolean
     */
    public boolean equals(Date dateToVerify) {
        return this.day == dateToVerify.getDay() && this.month == dateToVerify.getMonth() && this.year == dateToVerify.getYear();
    } 

    
    /** 
     * @param date
     * @return int
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
