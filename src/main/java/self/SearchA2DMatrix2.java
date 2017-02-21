package self;

/**
 * Write an efficient algorithm that searches for a value in an m x n matrix.
 * This matrix has the following properties:
 * Integers in each row are sorted in ascending from left to right.
 * Integers in each column are sorted in ascending from top to bottom.
 */
public class SearchA2DMatrix2 {
    // Time: O(m+n) Space: O(1)
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length;
        if (m == 0) return false;
        int n = matrix[0].length;
        if (n == 0) return false;
        for (int i = 0, j = n-1; i < m && j >= 0;) {
            int val = matrix[i][j];
            if (val == target) {
                return true;
            } else if (val < target) {
                i++;
            } else {
                j--;
            }
        }
        return false;
    }

    public static void main(String[] args){
        SearchA2DMatrix2 instance = new SearchA2DMatrix2();
        int[][] matrix = new int[][] {
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        System.out.println(instance.searchMatrix(matrix, 5));
        System.out.println(instance.searchMatrix(matrix, 20));
    }
}

