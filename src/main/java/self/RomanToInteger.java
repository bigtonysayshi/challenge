package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a roman numeral, convert it to an integer.
 * Input is guaranteed to be within the range from 1 to 3999.
 */
public class RomanToInteger {
    private static final Map<Character, Integer> VALUE_MAP = new HashMap<Character, Integer>();
    static {
        VALUE_MAP.put('I', 1);
        VALUE_MAP.put('V', 5);
        VALUE_MAP.put('X', 10);
        VALUE_MAP.put('L', 50);
        VALUE_MAP.put('C', 100);
        VALUE_MAP.put('D', 500);
        VALUE_MAP.put('M', 1000);
    }

    // Time: O(n) Space: O(1)
    public int romanToInt(String s) {
        int value = 0;
        for (int i = 0; i < s.length(); i++) {
            int currentVal = VALUE_MAP.get(s.charAt(i));
            if (i == s.length() - 1) {
                value += currentVal;
            } else {
                int nextVal = VALUE_MAP.get(s.charAt(i + 1));
                if (currentVal < nextVal) {
                    value -= currentVal;
                } else {
                    value += currentVal;
                }
            }
        }
        return value;
    }

    public static void main(String[] args){
        RomanToInteger instance = new RomanToInteger();
        System.out.println(instance.romanToInt("II"));
        System.out.println(instance.romanToInt("VI"));
        System.out.println(instance.romanToInt("XXVI"));
        System.out.println(instance.romanToInt("XLIX"));

    }
}
