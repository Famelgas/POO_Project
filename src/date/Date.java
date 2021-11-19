package date;

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
    
    public void setDateAtributes(String numStr, int atrib) {
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

}
