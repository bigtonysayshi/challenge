package self;

/**
 * A robot is located at the top-left corner of a m x n grid (marked 'Start' in the diagram below).
 * The robot can only move either down or right at any point in time.
 * The robot is trying to reach the bottom-right corner of the grid (marked 'Finish' in the diagram below).
 * How many possible unique paths are there?
 */
public class UniquePaths {
    // Time: O(min(m,n)) Space: O(1)
    public int uniquePaths(int m, int n) {
        if (m > n) return uniquePaths(n, m);
        int totalMoves = m + n - 2, downMoves = m - 1;
        long paths = 1L;
        for (int i = 1; i <= downMoves; i++) {
            paths = paths * (totalMoves - i + 1) / i;
        }
        return (int)paths;
    }

    public static void main(String[] args){
        UniquePaths instance = new UniquePaths();
        System.out.println(instance.uniquePaths(2,2));
        System.out.println(instance.uniquePaths(4,3));
        System.out.println(instance.uniquePaths(3,7));
        System.out.println(instance.uniquePaths(5,5));
        System.out.println(instance.uniquePaths(51,9));
    }
}
