package self;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted from left to right.
 * The first integer of each row is greater than the last integer of the previous row.
 */
public class SearchA2DMatrix {
    // Time: O(log(mn)) Space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;

        int lo = 0, hi = m * n - 1;
        while (lo <= hi) {
            int mid = lo + (hi - lo) / 2, val = matrix[mid/n][mid%n];
            if (target == val) {
                return true;
            } else if (target < val) {
                hi = mid - 1;
            } else {
                lo = mid + 1;
            }
        }
        return false;
    }

    public static void main(String[] args){
        SearchA2DMatrix instance = new SearchA2DMatrix();
        int[][] matrix = new int[][] {
                {1,   3,  5,  7},
                {10, 11, 16, 20},
                {23, 30, 34, 50}
        };
        System.out.println(instance.searchMatrix(matrix, 5));
        System.out.println(instance.searchMatrix(matrix, 21));
    }
}
