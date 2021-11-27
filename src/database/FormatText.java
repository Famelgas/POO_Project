package database;

public class FormatText {
    public FormatText() {}

    public String alignCenterText(String string) {
        String newString = "";
        for (int i = 0; i < ((80 - string.length()) / 2); ++i) {
            newString += " ";
        }
        return newString + string;
    }

    public String  alignRightText(String string) {
        String newString = "";
        for (int i = 0; i < (80 - string.length()); ++i) {
            newString += " ";
        }
        return newString + string;
    }

    public void separationLine() {
        System.out.print("x");
        for (int i = 0; i < 79; ++i) {
            System.out.print("-");
        }
        System.out.println("x");
    }
}
