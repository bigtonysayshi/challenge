package self;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Write a program to find the nth super ugly number.
 * Super ugly numbers are positive numbers whose all prime factors are in the given prime list primes of size k. For example, [1, 2, 4, 7, 8, 13, 14, 16, 19, 26, 28, 32] is the sequence of the first 12 super ugly numbers given primes = [2, 7, 13, 19] of size 4.
 * Note:
 * (1) 1 is a super ugly number for any given primes.
 * (2) The given numbers in primes are in ascending order.
 * (3) 0 < k ≤ 100, 0 < n ≤ 10^6, 0 < primes[i] < 1000.
 * (4) The nth super ugly number is guaranteed to fit in a 32-bit signed integer.
 */
public class SuperUglyNumber {
    // Time: O(nk) Space: O(n+k)
    public int nthSuperUglyNumber(int n, int[] primes) {
        int k = primes.length;
        int[] nextIdx = new int[k];
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int count = 1;
        while (count < n) {
            int minVal = Integer.MAX_VALUE, minIdx = -1;
            for (int i = 0; i < k; i++) {
                if (primes[i] * uglyNumbers[nextIdx[i]] < minVal) {
                    minVal = primes[i] * uglyNumbers[nextIdx[i]];
                    minIdx = i;
                }
            }
            if (minVal > uglyNumbers[count-1]) {
                uglyNumbers[count++] = minVal;
            }
            nextIdx[minIdx]++;
        }
        return uglyNumbers[n-1];
    }

    public static void main(String[] args){
        SuperUglyNumber instance = new SuperUglyNumber();
        System.out.println(instance.nthSuperUglyNumber(12, new int[]{2,7,13,19}));
    }
}
