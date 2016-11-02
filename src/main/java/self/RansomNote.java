package self;

/**
 * Given an arbitrary ransom note string and another string containing letters from all the magazines,
 * write a function that will return true if the ransom note can be constructed from the magazines ;
 * otherwise, it will return false.
 * Each letter in the magazine string can only be used once in your ransom note.
 * You may assume that both strings contain only lowercase letters.
 */
public class RansomNote {
    // n = num chars in magazine. Time: O(n) Space: O(1)
    public boolean canConstruct(String ransomNote, String magazine) {
        int[] charCounts = new int[26];
        for (char c : magazine.toCharArray()) {
            charCounts[c - 'a']++;
        }
        for (char c : ransomNote.toCharArray()) {
            if (charCounts[c - 'a'] == 0) {
                return false;
            }
            charCounts[c - 'a']--;
        }
        return true;
    }

    public static void main(String[] args){
        RansomNote instance = new RansomNote();
        System.out.println(instance.canConstruct("a", "b"));
        System.out.println(instance.canConstruct("aa", "ab"));
        System.out.println(instance.canConstruct("aa", "aab"));
    }
}
