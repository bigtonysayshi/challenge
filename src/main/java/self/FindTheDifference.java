package self;

/**
 * Given two strings s and t which consist of only lowercase letters.
 * String t is generated by random shuffling string s and then add one more letter at a random position.
 * Find the letter that was added in t.
 */
public class FindTheDifference {
    // Time: O(n) Space: O(1)
    public char findTheDifference(String s, String t) {
        int[] charCounts = new int[26];
        for (char c : s.toCharArray()) {
            charCounts[c - 'a']++;
        }
        for (char c : t.toCharArray()) {
            if (charCounts[c - 'a'] == 0) {
                return c;
            } else {
                charCounts[c - 'a']--;
            }
        }
        return ' ';
    }

    // Time: O(n) Space: O(1) More elegant
    public char findTheDifference2(String s, String t) {
        int charCodeSum = 0;
        for (int i = 0; i < s.length(); i++) {
            charCodeSum += t.charAt(i);
            charCodeSum -= s.charAt(i);
        }
        charCodeSum += t.charAt(t.length() - 1);
        return (char)charCodeSum;
    }

    public static void main(String[] args){
        FindTheDifference instance = new FindTheDifference();
        System.out.println(instance.findTheDifference2("abcd", "abdce"));
    }
}