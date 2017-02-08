package self;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given a non-empty string containing an out-of-order English representation of digits 0-9,
 * output the digits in ascending order.
 * Note:
 * Input contains only lowercase English letters.
 * Input is guaranteed to be valid and can be transformed to its original digits.
 * That means invalid inputs such as "abc" or "zerone" are not permitted.
 * Input length is less than 50,000.
 */
public class ReconstructOriginalDigitsFromEnglish {
    private static final String[] DIGITS = new String[] {
            "zero", "one", "two", "three", "four", "five", "six", "seven", "eight", "nine"
    };

    public String originalDigits(String s) {
        Map<Character, Integer> charCounts = new HashMap<>();
        for (int i = 0; i < s.length(); i++) {
            charCounts.put(s.charAt(i), charCounts.getOrDefault(s.charAt(i), 0) + 1);
        }
        return recover(charCounts, 0);
    }

    private String recover(Map<Character, Integer> charCounts, int digit) {
        if (digit > 9) {
            return charCounts.values().stream().filter(v -> v > 0).count() == 0 ?
                    "" : null;
        }
        String word = DIGITS[digit];
        Map<Character, Integer> freq = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            freq.put(word.charAt(i), freq.getOrDefault(word.charAt(i),0) + 1);
        }
        int maxCount = Integer.MAX_VALUE;
        for (char c : freq.keySet()) {
            maxCount = Math.min(maxCount, charCounts.getOrDefault(c, 0) / freq.get(c));
        }
        for (int i = maxCount; i > 0; i--) {
            Map<Character, Integer> charCountsCopy = new HashMap<>();
            charCountsCopy.putAll(charCounts);
            for (char c : freq.keySet()) {
                charCountsCopy.put(c, charCountsCopy.get(c) - freq.get(c) * i);
            }
            String res = recover(charCountsCopy, digit + 1);
            if (res != null) {
                StringBuilder sb = new StringBuilder();
                for (int j = 0; j < i; j++) {
                    sb.append(digit);
                }
                sb.append(res);
                return sb.toString();
            }
        }
        return charCounts.values().stream().filter(v -> v > 0).count() == 0 ?
                "" : recover(charCounts, digit + 1);
    }

    // Utilizing the special char properties in each digit
    // Time: O(n) Space: O(1)
    public String originalDigits2(String s) {
        int[] count = new int[10];
        for (int i = 0; i < s.length(); i++){
            char c = s.charAt(i);
            if (c == 'z') count[0]++;
            if (c == 'w') count[2]++;
            if (c == 'x') count[6]++;
            if (c == 's') count[7]++; //7-6
            if (c == 'g') count[8]++;
            if (c == 'u') count[4]++;
            if (c == 'f') count[5]++; //5-4
            if (c == 'h') count[3]++; //3-8
            if (c == 'i') count[9]++; //9-8-5-6
            if (c == 'o') count[1]++; //1-0-2-4
        }
        count[7] -= count[6];
        count[5] -= count[4];
        count[3] -= count[8];
        count[9] = count[9] - count[8] - count[5] - count[6];
        count[1] = count[1] - count[0] - count[2] - count[4];
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= 9; i++){
            for (int j = 0; j < count[i]; j++){
                sb.append(i);
            }
        }
        return sb.toString();
    }

    public static void main(String[] args){
        ReconstructOriginalDigitsFromEnglish instance = new ReconstructOriginalDigitsFromEnglish();
        System.out.println(instance.originalDigits("owoztneoer"));
        System.out.println(instance.originalDigits("fviefuro"));
    }
}
