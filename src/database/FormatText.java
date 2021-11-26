package database;

public class FormatText {
    public FormatText() {}

    public void alignCenterText(String string) {
        for (int i = 0; i < ((80 - string.length()) / 2); ++i) {
            System.out.print(" ");
        }
    }

    public void alignRightText(String string) {
        for (int i = 0; i < (80 - string.length()); ++i) {
            System.out.print(" ");
        }
    }
}
