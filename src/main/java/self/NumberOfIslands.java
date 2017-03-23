package self;

/**
 * Given a 2d grid map of '1's (land) and '0's (water), count the number of islands.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands {
    // Time: O(mn) Space: O(1)
    public int numIslands(char[][] grid) {
        int m = grid.length;
        if (m == 0) return 0;
        int n = grid[0].length;
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == '1') {
                    dfsMark(grid, i, j);
                    count++;
                }
            }
        }
        return count;
    }

    private void dfsMark(char[][] grid, int x, int y) {
        int m = grid.length, n = grid[0].length;
        if (x < 0 || y < 0 || x >= m || y >= n || grid[x][y] != '1') return;
        grid[x][y] = '0';
        dfsMark(grid, x-1, y);
        dfsMark(grid, x+1, y);
        dfsMark(grid, x, y-1);
        dfsMark(grid, x, y+1);
    }

    public static void main(String[] args){
        NumberOfIslands instance = new NumberOfIslands();
        char[][] matrix = new char[][] {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(instance.numIslands(matrix));
    }
}
