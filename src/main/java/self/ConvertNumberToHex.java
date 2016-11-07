package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer, write an algorithm to convert it to hexadecimal.
 * For negative integer, two’s complement method is used.
 * Note:
 * All letters in hexadecimal (a-f) must be in lowercase.
 * The hexadecimal string must not contain extra leading 0s.
 * If the number is zero, it is represented by a single zero character '0';
 * otherwise, the first character in the hexadecimal string will not be the zero character.
 * The given number is guaranteed to fit within the range of a 32-bit signed integer.
 * You must not use any method provided by the library which converts/formats the number to hex directly.
 */
public class ConvertNumberToHex {
    private static char[] HEX_MAP = new char[]{
            '0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'
    };
    // n bits. Time: O(n) Space: O(1)
    public String toHex(int num) {
        if (num == 0) return "0";
        StringBuilder sb = new StringBuilder();
        while (num != 0) {
            char hexChar = HEX_MAP[num & 15];
            sb.append(hexChar);
            num >>>= 4;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        ConvertNumberToHex instance = new ConvertNumberToHex();
        System.out.println(instance.toHex(26));
        System.out.println(instance.toHex(-1));
    }
}
