package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given a positive integer n, break it into the sum of at least two positive integers
 * and maximize the product of those integers. Return the maximum product you can get.
 * Note: You may assume that n is not less than 2 and not larger than 58.
 */
public class IntegerBreak {
    // Time: O(n) Space: O(1)
    // Factors are either 2 or 3
    public int integerBreak(int n) {
        if (n <= 3) return n-1;
        int product = 1;
        while (n > 4) {
            product *= 3;
            n -= 3;
        }
        product *= n;
        return product;
    }

    public static void main(String[] args){
        IntegerBreak instance = new IntegerBreak();
        System.out.println(instance.integerBreak(2));
        System.out.println(instance.integerBreak(10));
    }
}
