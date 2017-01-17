package self;

/**
 * Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.
 * Have you consider that the string might be empty?
 * This is a good question to ask during an interview.
 * For the purpose of this problem, we define empty string as valid palindrome.
 */
public class ValidPalindrome {
    // Time: O(n) Space:O(1)
    public boolean isPalindrome(String s) {
        int i = 0, j = s.length() - 1;
        while (i < j) {
            char c1 = s.charAt(i), c2 = s.charAt(j);
            if (!isValidChar(c1)) {
                i++;
            } else if (!isValidChar(c2)) {
                j--;
            } else if (Character.toLowerCase(c1) != Character.toLowerCase(c2)) {
                return false;
            } else {
                i++;
                j--;
            }
        }
        return true;
    }

    private boolean isValidChar(char c) {
        return Character.isLetterOrDigit(c);
    }

    public static void main(String[] args){
        ValidPalindrome instance = new ValidPalindrome();
        System.out.println(instance.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(instance.isPalindrome("race a car"));
        System.out.println(instance.isPalindrome(""));
    }
}
