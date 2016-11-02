package self;

/**
 * Given a column title as appear in an Excel sheet, return its corresponding column number.
 */
public class ExcelSheetColumnNumber {
    // n = chars in s. Time: O(n) Space: O(1)
    public int titleToNumber(String s) {
        int colNum = 0;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(s.length() - 1 - i);
            colNum += (c - 'A' + 1) * Math.pow(26, i);
        }
        return colNum;
    }

    public static void main(String[] args){
        ExcelSheetColumnNumber instance = new ExcelSheetColumnNumber();
        System.out.println(instance.titleToNumber("A"));
        System.out.println(instance.titleToNumber("Z"));
        System.out.println(instance.titleToNumber("AB"));
        System.out.println(instance.titleToNumber("BAB"));

    }
}
