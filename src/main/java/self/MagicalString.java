package self;

/**
 * A magical string S consists of only '1' and '2' and obeys the following rules:
 * The string S is magical because concatenating the number of contiguous occurrences of characters '1' and '2' generates the string S itself.
 * The first few elements of string S is the following: S = "1221121221221121122……"
 * If we group the consecutive '1's and '2's in S, it will be:
 * 1 22 11 2 1 22 1 22 11 2 11 22 ......
 * and the occurrences of '1's or '2's in each group are:
 * 1 2	2 1 1 2 1 2 2 1 2 2 ......
 * You can see that the occurrence sequence above is the S itself.
 * Given an integer N as input, return the number of '1's in the first N number in the magical string S.
 */
public class MagicalString {
    // Time: O(n) Space: O(n)
    public int magicalString(int n) {
        if (n <= 1) return n;
        int[] digits = new int[n+1];
        digits[0] = 1;
        digits[1] = 2;
        digits[2] = 2;
        int nextIdx = 3, countIdx = 2;
        while (nextIdx < n) {
            int currDigit = digits[nextIdx-1];
            if (digits[countIdx++] == 2) {
                digits[nextIdx++] = 3- currDigit;
            }
            digits[nextIdx++] = 3 - currDigit;
        }
        int numOnes = 0;
        for (int i = 0; i < n; i++) {
            if (digits[i] == 1) numOnes++;
        }
        return numOnes;
    }

    public static void main(String[] args){
        MagicalString instance = new MagicalString();
        System.out.println(instance.magicalString(1));
        System.out.println(instance.magicalString(4));
        System.out.println(instance.magicalString(6));
        System.out.println(instance.magicalString(18));
    }
}
