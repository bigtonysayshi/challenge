package self;

/**
 * Given an array of integers, every element appears three times except for one,
 * which appears exactly once. Find that single one.
 * Note:
 * Your algorithm should have a linear runtime complexity.
 * Could you implement it without using extra memory?
 */
public class SingleNumber2 {
    // Time: O(n) Space: O(1)
    public int singleNumber(int[] nums) {
        int ans = 0;
        for(int i = 0; i < 32; i++) {
            int sum = 0;
            for(int n : nums) {
                if(((n >> i) & 1) == 1) {
                    sum++;
                    sum %= 3;
                }
            }
            if(sum != 0) {
                ans |= sum << i;
            }
        }
        return ans;
    }

    public static void main(String[] args){
        SingleNumber2 instance = new SingleNumber2();
        System.out.println(instance.singleNumber(new int[]{1,1,1,2,3,3,3}));
        System.out.println(instance.singleNumber(new int[]{1}));
        System.out.println(instance.singleNumber(new int[]{3,1,1,3,2,3,1}));
    }
}
