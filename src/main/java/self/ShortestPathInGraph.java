package self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a 2D matrix a two cells inside the matrix, find the length of the shortest path between the two points.
 * The matrix have two types of cells: 0 and 1.
 * You can pass through 0 cells, but not 1 cells.
 * Also, you can only go up, down, left, right, but not outside the matrix or diagonally.
 */
public class ShortestPathInGraph {
    static final int[] dx = new int[]{0, 0, 1, -1};
    static final int[] dy = new int[]{1, -1, 0, 0};

    public int shortestPath(int[][] matrix, Point start, Point end) {
        int m = matrix.length;
        int n = matrix[0].length;
        boolean[][] checked = new boolean[m][n];
        checked[start.row][start.col] = true;
        Queue<Point> queue = new LinkedList<>();
        queue.offer(start);
        int distance = 0;
        while (!queue.isEmpty()) {
            int numPoints = queue.size();
            for (int i = 0; i < numPoints; i++) {
                Point point = queue.poll();
                if (point.row == end.row && point.col == end.col) {
                    return distance;
                }
                for (int j = 0; j < dx.length; j++) {
                    int r = point.row + dy[j];
                    int c = point.col + dx[j];
                    if (r < 0 || r >= m || c < 0 || c >= n || matrix[r][c] == 1 || checked[r][c]) {
                        continue;
                    }
                    queue.offer(new Point(r, c));
                    checked[r][c] = true;
                }
            }
            distance++;
        }
        return -1;
    }

    public static void main(String[] args){
        ShortestPathInGraph instance = new ShortestPathInGraph();
        System.out.println(instance.shortestPath(new int[][]{
                {0,1,0},
                {0,0,0},
                {0,1,0}
        }, new Point(0,0), new Point(0,2)));
    }


}

