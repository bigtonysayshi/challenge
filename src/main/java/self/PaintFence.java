package self;

/**
 * There is a fence with n posts, each post can be painted with one of the k colors.
 * You have to paint all the posts such that no more than two adjacent fence posts have the same color.
 * Return the total number of ways you can paint the fence.
 * Note: n and k are non-negative integers.
 */
public class PaintFence {
    public int numWays(int n, int k) {
        if (n == 0 || k == 0) return 0;
        int sameCount = 0;
        int diffCount = k;
        for (int i = 1; i < n; i++) {
            int newSameCount = diffCount;
            int newDiffCount = (diffCount + sameCount) * (k-1);
            sameCount = newSameCount;
            diffCount = newDiffCount;
        }
        return sameCount + diffCount;
    }

    public static void main(String[] args){
        PaintFence instance = new PaintFence();
        System.out.println(instance.numWays(2, 3));
        System.out.println(instance.numWays(3, 3));
        System.out.println(instance.numWays(4, 3));
    }
}
