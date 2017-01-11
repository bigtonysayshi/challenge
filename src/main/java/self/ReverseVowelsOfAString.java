package self;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/**
 * Write a function that takes a string as input and reverse only the vowels of a string.
 * Note: The vowels does not include the letter "y".
 */
public class ReverseVowelsOfAString {
    private static final Set<Character> VOWELS = new HashSet<>(
            Arrays.asList('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'));
    // Time: O(n) Space: O(n)
    public String reverseVowels(String s) {
        if (s == null || s.isEmpty()) return s;
        char[] chars = s.toCharArray();
        int start = 0;
        int end = chars.length - 1;
        while (start < end) {
            char leftChar = chars[start];
            char rightChar = chars[end];
            if (VOWELS.contains(leftChar) && VOWELS.contains(rightChar)) {
                char tmp = chars[start];
                chars[start++] = chars[end];
                chars[end--] = tmp;
            } else {
                if (!VOWELS.contains(leftChar)) start++;
                if (!VOWELS.contains(rightChar)) end--;
            }
        }
        return String.valueOf(chars);
    }

    public static void main(String[] args){
        ReverseVowelsOfAString instance = new ReverseVowelsOfAString();
        System.out.println(instance.reverseVowels("hello"));
        System.out.println(instance.reverseVowels("leetcode"));
        System.out.println(instance.reverseVowels("leaetcode"));

    }
}
