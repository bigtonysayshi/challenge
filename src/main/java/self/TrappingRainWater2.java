package self;

import java.util.PriorityQueue;

/**
 * Given an m x n matrix of positive integers representing the height of each unit cell in a 2D elevation map,
 * compute the volume of water it is able to trap after raining.
 * Note: Both m and n are less than 110.
 * The height of each unit cell is greater than 0 and is less than 20,000.
 */
public class TrappingRainWater2 {
    static final  int[] dx = new int[]{0, 0, -1, 1};
    static final  int[] dy = new int[]{-1, 1, 0, 0};

    // Time: O(mnlog(mn)) Space: O(mn)
    public int trapRainWater(int[][] heightMap) {
        if (heightMap == null) return 0;
        int m = heightMap.length;
        if (m == 0) return 0;
        int n = heightMap[0].length;
        if (n == 0) return 0;
        boolean[][] checked = new boolean[m][n];
        PriorityQueue<Cell> minHeap = new PriorityQueue<>((Cell c1, Cell c2) -> c1.height - c2.height);
        for (int i = 0; i < n; i++) {
            checked[0][i] = true;
            checked[m - 1][i] = true;
            minHeap.offer(new Cell(0, i, heightMap[0][i]));
            minHeap.offer(new Cell(m -1 , i, heightMap[m - 1][i]));
        }
        for (int i = 1; i < m - 1; i++) {
            checked[i][0] = true;
            checked[i][n - 1] = true;
            minHeap.offer(new Cell(i, 0, heightMap[i][0]));
            minHeap.offer(new Cell(i, n - 1, heightMap[i][n - 1]));
        }

        int total = 0;
        while (!minHeap.isEmpty()) {
            Cell cell = minHeap.poll();
            for (int i = 0; i < dx.length; i++) {
                int r = cell.row + dy[i];
                int c = cell.col + dx[i];
                if (r < 0 || r >= m || c < 0 || c >= n || checked[r][c]) {
                    continue;
                }
                int h = heightMap[r][c];
                if (h < cell.height) {
                    total += cell.height - h;
                }
                checked[r][c] = true;
                minHeap.offer(new Cell(r, c, Math.max(h, cell.height)));
            }
        }
        return total;
    }

    public static void main(String[] args){
        TrappingRainWater2 instance = new TrappingRainWater2();
        System.out.println(instance.trapRainWater(new int[][]{
                {1,4,3,1,3,2},
                {3,2,1,3,2,4},
                {2,3,3,2,3,1}
        }));
    }
}

class Cell {
    int row;
    int col;
    int height;

    public Cell(int r, int c, int h) {
        row = r;
        col = c;
        height = h;
    }
}
