package userinterface;

/**
 * Class FormatText - methods to manipulate the text written in the terminal
 */
public class FormatText {
    /** 
     * Alings the text to the center 
     * @param string - string to be written
     * @return String - aligned string
     */
    public static String alignCenterText(String string) {
        String newString = "";
        for (int i = 0; i < ((80 - string.length()) / 2); ++i) {
            newString += " ";
        }
        return newString + string;
    }

    /**
     * Makes a separation line
     */
    public static void separationLine() {
        System.out.print("x");
        for (int i = 0; i < 79; ++i) {
            System.out.print("-");
        }
        System.out.println("x");
    }

    /**
     * Makes a intermidiet line
     */
    public static void intermidietLine() {
        for (int i = 0; i < 79; ++i) {
            System.out.print("-");
        }
    }
}
