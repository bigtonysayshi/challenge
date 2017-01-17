package self;

import java.util.Arrays;

/**
 * Given a non negative integer number num. For every numbers i in the range 0 ≤ i ≤ num
 * calculate the number of 1's in their binary representation and return them as an array.
 * It is very easy to come up with a solution with run time O(n*sizeof(integer)).
 * But can you do it in linear time O(n) /possibly in a single pass?
 * Space complexity should be O(n).
 * Can you do it like a boss? Do it without using any builtin function like __builtin_popcount in c++ or in any other language.
 */
public class CountingBits {
    // Time: O(n) Space: O(n)
    public int[] countBits(int num) {
        int[] bitCounts = new int[num+1];
        int currentBits = 1, nextShift = 2;
        for (int i = 0; i <= num; i++) {
            if (i == 0 || i == 1) {
                bitCounts[i] = i;
            } else if (i == nextShift) {
                currentBits++;
                nextShift *= 2;
                bitCounts[i] = 1;
            } else {
                int diff = (int)Math.pow(2, currentBits-1);
                bitCounts[i] = bitCounts[i-diff] + 1;
            }
        }
        return bitCounts;
    }

    // f[i] = f[i / 2] + i % 2
    public int[] countBits2(int num) {
        int[] f = new int[num + 1];
        for (int i=1; i<=num; i++) f[i] = f[i >> 1] + (i & 1);
        return f;
    }

    public static void main(String[] args){
        CountingBits instance = new CountingBits();
        System.out.println(Arrays.toString(instance.countBits(5)));
        System.out.println(Arrays.toString(instance.countBits(10000)));
    }
}
