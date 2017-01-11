package self;

import java.util.HashSet;
import java.util.Set;

/**
 * Given a string, determine if a permutation of the string could form a palindrome.
 * For example,"code" -> False, "aab" -> True, "carerac" -> True.
 */
public class PalindromePermutation {
    // Time: O(n) Space:O(1)
    public boolean canPermutePalindrome(String s) {
        int[] charMap = new int[256];
        for (int i = 0; i < s.length(); i++) {
            charMap[s.charAt(i)]++;
        }
        int singleCount = 0;
        for (int count : charMap) {
            if (count % 2 != 0) {
                singleCount++;
            }
        }
        return  singleCount <= 1;
    }

    // Use Set
    public boolean canPermutePalindrome2(String s) {
        Set<Character> set=new HashSet<>();
        for(int i = 0; i < s.length(); i++){
            if (!set.contains(s.charAt(i)))
                set.add(s.charAt(i));
            else
                set.remove(s.charAt(i));
        }
        return set.size() <= 1;
    }

    public static void main(String[] args){
        PalindromePermutation instance = new PalindromePermutation();
        System.out.println(instance.canPermutePalindrome("code"));
        System.out.println(instance.canPermutePalindrome("aab"));
        System.out.println(instance.canPermutePalindrome("carearc"));
        System.out.println(instance.canPermutePalindrome("AbBb//a"));
    }
}
