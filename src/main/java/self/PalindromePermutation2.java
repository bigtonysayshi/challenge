package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, return all the palindromic permutations (without duplicates) of it.
 * Return an empty list if no palindromic permutation could be form.
 */
public class PalindromePermutation2 {
    public List<String> generatePalindromes(String s) {
        List<String> results = new ArrayList<>();
        if (s == null) {
            return results;
        }
        int[] charCounts = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charCounts[s.charAt(i)]++;
        }
        Character oddChar = null;
        int targetLen = 0;
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] % 2 == 1) {
                if (oddChar == null) {
                    oddChar = (char)i;
                    charCounts[i]--;
                } else {
                    return results;
                }
            }
            targetLen += charCounts[i] / 2;
        }
        search(results, targetLen, oddChar, charCounts, new StringBuilder());
        return results;
    }

    private void search(List<String> results, int targetLen, Character oddChar, int[] charCounts, StringBuilder sb) {
        if (sb.length() == targetLen) {
            StringBuilder res = new StringBuilder(sb);
            if (oddChar != null) {
                res.append(oddChar);
            }
            res.append(new StringBuilder(sb).reverse());
            results.add(res.toString());
            return;
        }
        for (int i = 0; i < charCounts.length; i++) {
            if (charCounts[i] > 0) {
                char c = (char)i;
                sb.append(c);
                charCounts[i] -= 2;
                search(results, targetLen, oddChar, charCounts, sb);
                sb.deleteCharAt(sb.length() - 1);
                charCounts[i] += 2;
            }
        }
    }

    public static void main(String[] args){
        PalindromePermutation2 instance = new PalindromePermutation2();
        System.out.println(instance.generatePalindromes("aabb"));
        System.out.println(instance.generatePalindromes("abc"));
    }
}
