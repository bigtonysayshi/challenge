package self;

/**
 * Given a non-empty array of integers, return the third maximum number in this array.
 * If it does not exist, return the maximum number. The time complexity must be in O(n).
 */
public class ThirdMaximumNumber {
    // Time: O(n) Space: O(1)
    public int thirdMax(int[] nums) {
        Integer first = null, second = null, third = null;
        for (int n : nums) {
            if ((first != null && first == n) ||
                    (second != null && second == n)||
                    (third != null && third == n)) continue;

            if (first == null || n > first) {
                third = second;
                second = first;
                first = n;
            } else if (second == null || n > second) {
                third = second;
                second = n;
            } else if (third == null || n > third) {
                third = n;
            }
        }
        return third == null ? (first == null ? 0 : first) : third;
    }

    public static void main(String[] args){
        ThirdMaximumNumber instance = new ThirdMaximumNumber();
        System.out.println(instance.thirdMax(new int[]{3, 2, 1}));
        System.out.println(instance.thirdMax(new int[]{2, 1}));
        System.out.println(instance.thirdMax(new int[]{2, 3, 2, 1}));
    }
}
