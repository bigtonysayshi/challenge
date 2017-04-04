package self;

/**
 * Given n non-negative integers representing an elevation map where the width of each bar is 1,
 * compute how much water it is able to trap after raining.
 */
public class TrappingRainWater {
    // Time: O(n) Space: O(1)
    public int trap(int[] height) {
        if (height == null || height.length < 2) {
            return 0;
        }
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        int leftHeight = height[left];
        int rightHeight = height[right];
        while (left < right) {
            if (leftHeight <= rightHeight) {
                left++;
                if (height[left] > leftHeight) {
                    leftHeight = height[left];
                } else {
                    total += leftHeight - height[left];
                }
            } else {
                right--;
                if (height[right] > rightHeight) {
                    rightHeight = height[right];
                } else {
                    total += rightHeight - height[right];
                }
            }
        }
        return total;
    }

    public static void main(String[] args){
        TrappingRainWater instance = new TrappingRainWater();
        System.out.println(instance.trap(new int[]{0,1,0,2,1,0,1,3,2,1,2,1}));
    }
}
