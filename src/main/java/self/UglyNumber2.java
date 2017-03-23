package self;

import java.util.PriorityQueue;

/**
 * Write a program to find the n-th ugly number.
 * Ugly numbers are positive numbers whose prime factors only include 2, 3, 5.
 * For example, 1, 2, 3, 4, 5, 6, 8, 9, 10, 12 is the sequence of the first 10 ugly numbers.
 * Note that 1 is typically treated as an ugly number, and n does not exceed 1690.
 */
public class UglyNumber2 {
    // Time: O(n) Space: O(n)
    public int nthUglyNumber(int n) {
        if (n <= 0) return 0;
        int[] uglyNumbers = new int[n];
        uglyNumbers[0] = 1;
        int p2 = 0, p3 = 0, p5 = 0, count = 1;
        while (count < n) {
            int v2 = uglyNumbers[p2] * 2,
                    v3 = uglyNumbers[p3] * 3,
                    v5 = uglyNumbers[p5] * 5;
            int next = Math.min(v2, Math.min(v3, v5));
            if (next == v2) p2++;
            if (next == v3) p3++;
            if (next == v5) p5++;
            uglyNumbers[count++] = next;
        }
        return uglyNumbers[n-1];
    }

    public static void main(String[] args){
        UglyNumber2 instance = new UglyNumber2();
        System.out.println(instance.nthUglyNumber(10));
    }
}
