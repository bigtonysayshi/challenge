package self;

/**
 * The string "PAYPALISHIRING" is written in a zigzag pattern on a given number of rows like this:
 * (you may want to display this pattern in a fixed font for better legibility)
 * And then read line by line: "PAHNAPLSIIGYIR"
 * Write the code that will take a string and make this conversion given a number of rows:
 * string convert(string text, int nRows);
 * convert("PAYPALISHIRING", 3) should return "PAHNAPLSIIGYIR".
 */
public class ZigZagConversion {
    public String convert(String s, int numRows) {
        if (s == null || s.isEmpty() || numRows == 0) return "";
        if (numRows == 1) return s;
        int len = s.length();
        StringBuilder sb = new StringBuilder();
        for (int j = 0; 2*j*(numRows-1) < len; j++) {
            sb.append(s.charAt(2*j*(numRows-1)));
        }
        for (int i = 2; i <= numRows-1; i++) {
            for (int j = 0; 2*j*(numRows-1)+i-1 < len; j++) {
                sb.append(s.charAt(2*j*(numRows-1)+i-1));
                if (2*(j+1)*(numRows-1) - i + 1 < len) {
                    sb.append(s.charAt(2*(j+1)*(numRows-1) - i + 1));
                }
            }
        }
        for (int j = 0; 2*j*(numRows-1)+numRows-1 < len; j++) {
            sb.append(s.charAt(2*j*(numRows-1)+numRows-1));
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ZigZagConversion instance = new ZigZagConversion();
        System.out.println(instance.convert("PAYPALISHIRING", 3));
        System.out.println(instance.convert("PAYPALISHIRING", 4));
        System.out.println(instance.convert("PAYPALISHIRING", 2));

    }
}
