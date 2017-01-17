package self;

/**
 * Given a positive integer, return its corresponding column title as appear in an Excel sheet.
 */
public class ExcelSheetColumnTitle {
    // Time: O(logn) Space: O(1)
    public String convertToTitle(int n) {
        StringBuilder sb = new StringBuilder();
        addChar(n, sb);
        return sb.toString();
    }

    private void addChar(int n, StringBuilder sb) {
        if (n <= 0) return;
        addChar((n-1) / 26, sb);
        sb.append((char)('A' + ((n-1) % 26)));
    }

    public static void main(String[] args){
        ExcelSheetColumnTitle instance = new ExcelSheetColumnTitle();
        System.out.println(instance.convertToTitle(1));
        System.out.println(instance.convertToTitle(26));
        System.out.println(instance.convertToTitle(28));
        System.out.println(instance.convertToTitle(226));
    }
}
