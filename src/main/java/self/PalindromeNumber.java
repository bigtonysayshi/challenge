package self;

/**
 * Determine whether an integer is a palindrome. Do this without extra space.
 */
public class PalindromeNumber {
    public boolean isPalindrome(int x) {
        if (x < 0) return false;
        int numDigits = numDigits(x);
        for (int i = 0; i < numDigits/2; i++) {
            int rightDigit = (x / (int)Math.pow(10, i)) % 10;
            int leftDigit = (x / (int)Math.pow(10, numDigits - 1 - i)) % 10;
            if (leftDigit != rightDigit) return false;
        }
        return true;
    }

    private int numDigits(int num) {
        int numDigits = 1;
        while (num >= 10) {
            numDigits++;
            num /= 10;
        }
        return numDigits;
    }

    // Cleaner solution
    public boolean isPalindrome2(int x) {
        if (x < 0) return false;

        int p = x;
        int q = 0;

        while (p >= 10){
            q *=10;
            q += p%10;
            p /=10;
        }
        return q == x / 10 && p == x % 10;
    }

    public static void main(String[] args){
        PalindromeNumber instance = new PalindromeNumber();
        System.out.println(instance.isPalindrome(1));
        System.out.println(instance.isPalindrome(12));
        System.out.println(instance.isPalindrome(1221));
        System.out.println(instance.isPalindrome(12221));
    }
}
