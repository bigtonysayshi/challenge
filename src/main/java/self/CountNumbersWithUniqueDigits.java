package self;

/**
 * Given a non-negative integer n, count all numbers with unique digits, x, where 0 ≤ x < 10^n.
 */
public class CountNumbersWithUniqueDigits {
    // Time: O(1) Space: O(1)
    public int countNumbersWithUniqueDigits(int n) {
        int count = 1;
        for (int i = 0; i < Math.min(n,9); i++) {
            int choices = 9, numbers = 9;
            for (int j = 0; j < i; j++) {
                numbers *= choices--;
            }
            count += numbers;
        }
        return count;
    }

    public static void main(String[] args){
        CountNumbersWithUniqueDigits instance = new CountNumbersWithUniqueDigits();
        System.out.println(instance.countNumbersWithUniqueDigits(0));
        System.out.println(instance.countNumbersWithUniqueDigits(1));
        System.out.println(instance.countNumbersWithUniqueDigits(2));
        System.out.println(instance.countNumbersWithUniqueDigits(3));
    }
}
