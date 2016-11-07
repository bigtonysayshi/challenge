package self;

/**
 * You are climbing a stair case. It takes n steps to reach to the top.
 * Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
 */
public class ClimbingStairs {
    // Time: O(n) Space: O(1)
    public int climbStairs(int n) {
        if (n == 1 || n == 2) return n;
        int p1 = 1, p2 = 2;
        int cur = p1 + p2;
        for (int i = 3; i < n; i++) {
            p1 = p2;
            p2 = cur;
            cur = p1 + p2;
        }
        return cur;
    }

    public static void main(String[] args){
        ClimbingStairs instance = new ClimbingStairs();
        System.out.println(instance.climbStairs(1));
        System.out.println(instance.climbStairs(2));
        System.out.println(instance.climbStairs(10));
        System.out.println(instance.climbStairs(20));
    }
}
