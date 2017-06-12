package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a string s, partition s such that every substring of the partition is a palindrome.
 * Return all possible palindrome partitioning of s.
 */
public class PalindromePartitioning {
    public List<List<String>> partition(String s) {
        List<List<String>> results = new ArrayList<>();
        if (s == null || s.length() == 0) {
            return results;
        }
        search(s, 0, results, new ArrayList<>());
        return results;
    }

    private void search(String s, int start, List<List<String>> results, List<String> partition) {
        if (start >= s.length()) {
            results.add(new ArrayList<>(partition));
            return;
        }
        for (int end = start + 1; end <= s.length(); end++) {
            String sub = s.substring(start, end);
            if (isPalindrome(sub)) {
                partition.add(sub);
                search(s, end, results, partition);
                partition.remove(partition.size() - 1);
            }
        }
    }

    private boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }

    public static void main(String[] args){
        PalindromePartitioning instance = new PalindromePartitioning();
        System.out.println(instance.partition("aab"));

    }
}
