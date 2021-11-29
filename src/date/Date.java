package date;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import java.time.LocalDate;

public class Date {
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
    
    private void setDateAtributes(String numStr, int atrib) {
        int num;
        try {
            num = Integer.parseInt(numStr);
        }
        catch (NumberFormatException nfe) {
            num = -1;
        }  
        switch (atrib) {
            case 1 -> setDay(num);
            case 2 -> setMonth(num);
            case 3 -> setYear(num);
            default -> { setDay(-1);    
                         setMonth(-1);
                         setYear(-1);
            }
        }
    }

    public String toString() {
        return day + "/" + month + "/" + year; 
    }


    public static Date convertStringToDate(String strDate) {
        Date date = new Date();
        String numStr = "";
        int atrib = 1;        

        for (int i = 0; i < strDate.length(); ++i) {
            if (!Character.isDigit(strDate.charAt(i))) {
                date.setDateAtributes(numStr, atrib);
                ++atrib;
            }
            if (i + 1 == strDate.length()) {
                numStr += strDate.charAt(i);
                date.setDateAtributes(numStr, atrib);
            }
            numStr += strDate.charAt(i);
        }

        return date;
    }

    public Date getUsersDate(Scanner sc) {
        System.out.println("Enter the pretended date:");
        int month;
        int year;
        
        System.out.println("Enter the day:");
        day = sc.nextInt();
        
        System.out.println("Enter the month:");
        month = sc.nextInt();
        
        System.out.println("Enter the year:");
        year = sc.nextInt();
        
        
        return new Date(day, month, year);
    }

    public Date getActualDate() {
        LocalDate localDate = LocalDate.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        String formattedDate = localDate.format(formatter);
        return convertStringToDate(formattedDate);
    }
}
