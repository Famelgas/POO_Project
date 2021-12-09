package database;

public class FormatText {
    public FormatText() {}

    
    /** 
     * @param string
     * @return String
     */
    public static String alignCenterText(String string) {
        String newString = "";
        for (int i = 0; i < ((80 - string.length()) / 2); ++i) {
            newString += " ";
        }
        return newString + string;
    }

    public static void separationLine() {
        System.out.print("x");
        for (int i = 0; i < 79; ++i) {
            System.out.print("-");
        }
        System.out.println("x");
    }

    public static void intermidietLine() {
        for (int i = 0; i < 79; ++i) {
            System.out.print("-");
        }
    }
}
