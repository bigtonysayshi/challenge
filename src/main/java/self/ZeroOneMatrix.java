package self;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a matrix consists of 0 and 1, find the distance of the nearest 0 for each cell.
 * The distance between two adjacent cells is 1.
 * Note:
 * The number of elements of the given matrix will not exceed 10,000.
 * There are at least one 0 in the given matrix.
 * The cells are adjacent in only four directions: up, down, left and right.
 */
public class ZeroOneMatrix {
    static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    public int[][] updateMatrix(int[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return matrix;
        }
        int m = matrix.length;
        int n = matrix[0].length;
        int[][] results = new int[m][n];
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (matrix[i][j] == 0) {
                    queue.add(new Point(i, j));
                    results[i][j] = 0;
                } else {
                    results[i][j] = -1;
                }
            }
        }
        while (!queue.isEmpty()) {
            Point p = queue.poll();
            int row = p.row;
            int col = p.col;
            int val = results[row][col];
            for (int i = 0; i < DIRS.length; i++) {
                int rr = row + DIRS[i][0];
                int cc = col + DIRS[i][1];
                if ((rr >= 0 && rr < m && cc >= 0 && cc < n) &&
                        (results[rr][cc] < 0 || results[rr][cc] > val + 1)) {
                    results[rr][cc] = val + 1;
                    queue.add(new Point(rr, cc));
                }
            }
        }
        return results;
    }

    public static void main(String[] args){
        ZeroOneMatrix instance = new ZeroOneMatrix();
        int[][] output = instance.updateMatrix(new int[][] {
                {0, 0, 0},
                {0, 1, 0},
                {1, 1, 1}
        });
        for (int[] row : output) {
            System.out.println(Arrays.toString(row));
        }
    }

    class Point {
        int row;
        int col;

        public Point(int r, int c) {
            row = r;
            col = c;
        }
    }
}
