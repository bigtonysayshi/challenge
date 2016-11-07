package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given two non-negative numbers num1 and num2 represented as string,
 * return the sum of num1 and num2.
 * Note:
 * The length of both num1 and num2 is < 5100.
 * Both num1 and num2 contains only digits 0-9.
 * Both num1 and num2 does not contain any leading zero.
 * You must not use any built-in BigInteger library or convert the inputs to integer directly.
 */
public class AddStrings {
    private static Map<Character, Integer> DIGIT_MAP = new HashMap<Character, Integer>();

    static {
        DIGIT_MAP.put('0', 0);
        DIGIT_MAP.put('1', 1);
        DIGIT_MAP.put('2', 2);
        DIGIT_MAP.put('3', 3);
        DIGIT_MAP.put('4', 4);
        DIGIT_MAP.put('5', 5);
        DIGIT_MAP.put('6', 6);
        DIGIT_MAP.put('7', 7);
        DIGIT_MAP.put('8', 8);
        DIGIT_MAP.put('9', 9);
    }

    // Time: O(n) Space: O(1)
    public String addStrings(String num1, String num2) {
        char[] longerInput = num1.length() > num2.length() ? num1.toCharArray() : num2.toCharArray();
        char[] shorterInput = num1.length() > num2.length() ? num2.toCharArray() : num1.toCharArray();
        int longInputLen = longerInput.length, shortInputLen = shorterInput.length;
        int carry = 0;

        for (int i = 0; i < longInputLen && (i < shortInputLen || carry != 0); i++) {
            int longInputDigit = DIGIT_MAP.get(longerInput[longInputLen - 1 - i]);
            int shortInputDigit = i < shortInputLen ?
                    DIGIT_MAP.get(shorterInput[shortInputLen - 1 - i]) : 0;
            int digitSum = longInputDigit + shortInputDigit + carry;
            int newDigit = digitSum % 10;
            carry = digitSum >= 10 ? 1 : 0;
            longerInput[longInputLen - 1 - i] = Integer.toString(newDigit).charAt(0);
        }
        if (carry != 0) {
            return "1" + String.valueOf(longerInput);
        }
        return String.valueOf(longerInput);
    }

    // Time: O(n) Space: O(1). Clean solution.
    public String addStrings2(String num1, String num2) {
        StringBuilder sb = new StringBuilder();
        int carry = 0;
        for(int i = num1.length() - 1, j = num2.length() - 1; i >= 0 || j >= 0 || carry == 1; i--, j--){
            int x = i < 0 ? 0 : num1.charAt(i) - '0';
            int y = j < 0 ? 0 : num2.charAt(j) - '0';
            sb.append((x + y + carry) % 10);
            carry = (x + y + carry) / 10;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddStrings instance = new AddStrings();
        System.out.println(instance.addStrings("1", "9"));
        System.out.println(instance.addStrings("6913259244", "71103343"));
    }
}
