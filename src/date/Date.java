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

    public int getDay() {
        return day;
    }

    public void setDay(int day) {
        this.day = day;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }
    
    
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
    
    
    public static Date getLocalDate() {
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDateTime now = LocalDateTime.now();
        String strDate = dtf.format(now);
        return convertStringToDate(strDate);
    }
    
    
    
    public String toString() {
        return day + "/" + month + "/" + year; 
    }

    public boolean equals(Date dateToVerify) {
        return this.day == dateToVerify.getDay() && this.month == dateToVerify.getMonth() && this.year == dateToVerify.getYear();
    } 

}
