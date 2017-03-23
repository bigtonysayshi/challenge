package self;

import java.util.*;

/**
 * Given an m x n matrix of non-negative integers representing the height of each unit cell in a continent,
 * the "Pacific ocean" touches the left and top edges of the matrix and the "Atlantic ocean" touches the right and bottom edges.
 * Water can only flow in four directions (up, down, left, or right) from a cell to another one with height equal or lower.
 * Find the list of grid coordinates where water can flow to both the Pacific and Atlantic ocean.
 * Note:
 * The order of returned grid coordinates does not matter.
 * Both m and n are less than 150.
 */
public class PacificAtlanticWaterFlow {
    // Time: O(mn) Space: O(mn)
    public List<int[]> pacificAtlantic(int[][] matrix) {
        List<int[]> results = new ArrayList<>();
        int m = matrix.length;
        if (m == 0) {
            return results;
        }
        int n = matrix[0].length;
        if (n == 0) {
            return results;
        }
        boolean[][] isPac = new boolean[m][n], isAtl = new boolean[m][n];
        Queue<int[]> pacQueue = new LinkedList<>(), atlQueue = new LinkedList<>();
        pacQueue.offer(new int[]{0,0});
        isPac[0][0] = true;
        atlQueue.offer(new int[]{m-1,n-1});
        isAtl[m-1][n-1] = true;
        for (int i = 1; i < m; i++) {
            pacQueue.offer(new int[]{i,0});
            isPac[i][0] = true;
            atlQueue.offer(new int[]{m-1-i,n-1});
            isAtl[m-1-i][n-1] = true;
        }
        for (int j = 1; j < n; j++) {
            pacQueue.offer(new int[]{0,j});
            isPac[0][j] = true;
            atlQueue.offer(new int[]{m-1,n-1-j});
            isAtl[m-1][n-1-j] = true;
        }
        while (!pacQueue.isEmpty()) {
            int[] current = pacQueue.poll();
            int x = current[0], y = current[1], order = matrix[x][y];
            markNeighbor(matrix, isPac, x-1, y, order, pacQueue);
            markNeighbor(matrix, isPac, x+1, y, order, pacQueue);
            markNeighbor(matrix, isPac, x, y-1, order, pacQueue);
            markNeighbor(matrix, isPac, x, y+1, order, pacQueue);
        }
        while (!atlQueue.isEmpty()) {
            int[] current = atlQueue.poll();
            int x = current[0], y = current[1], order = matrix[x][y];
            markNeighbor(matrix, isAtl, x-1, y, order, atlQueue);
            markNeighbor(matrix, isAtl, x+1, y, order, atlQueue);
            markNeighbor(matrix, isAtl, x, y-1, order, atlQueue);
            markNeighbor(matrix, isAtl, x, y+1, order, atlQueue);
        }
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (isPac[i][j] && isAtl[i][j]) {
                    results.add(new int[]{i,j});
                }
            }
        }
        return results;
    }

    private void markNeighbor(int[][] matrix, boolean[][] states, int x, int y, int order, Queue<int[]> queue) {
        int m = matrix.length, n = matrix[0].length;
        if (x >= 0 && y >= 0 && x < m && y < n && order <= matrix[x][y] && !states[x][y]) {
            states[x][y] = true;
            queue.offer(new int[]{x, y});
        }
    }


    public static void main(String[] args){
        PacificAtlanticWaterFlow instance = new PacificAtlanticWaterFlow();
        int[][] input = new int[][] {
                {1,2,2,3,5},
                {3,2,3,4,4},
                {2,4,5,3,1},
                {6,7,1,4,5},
                {5,1,1,2,4}
        };
        for (int[] pair : instance.pacificAtlantic(input)) {
            System.out.println(Arrays.toString(pair));
        }
    }
}
