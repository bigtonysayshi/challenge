package self;

/**
 * Given an integer n, return the number of trailing zeroes in n!.
 * Note: Your solution should be in logarithmic time complexity.
 */
public class FactorialTrailingZeroes {
    public int trailingZeroes(int n) {
        int fiveCounts = 0;
        while (n > 0) {
            n /= 5;
            fiveCounts += n;
        }
        return fiveCounts;
    }

    public static void main(String[] args){
        FactorialTrailingZeroes instance = new FactorialTrailingZeroes();
        System.out.println(instance.trailingZeroes(0));
        System.out.println(instance.trailingZeroes(10));
        System.out.println(instance.trailingZeroes(20));
    }
}
