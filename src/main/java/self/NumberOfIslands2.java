package self;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * A 2d grid map of m rows and n columns is initially filled with water.
 * We may perform an addLand operation which turns the water at position (row, col) into a land.
 * Given a list of positions to operate, count the number of islands after each addLand operation.
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically.
 * You may assume all four edges of the grid are all surrounded by water.
 */
public class NumberOfIslands2 {
    static final int[] dx = new int[]{0, 0, -1, 1};
    static final int[] dy = new int[]{-1, 1, 0, 0};

    public List<Integer> numIslands2(int m, int n, int[][] positions) {
        Coord[][] roots = new Coord[m][n];

        int numIslands = 0;
        List<Integer> results = new LinkedList<>();
        for (int[] pos : positions) {
            int row = pos[0];
            int col = pos[1];
            Coord root = findRoot(roots, row, col);
            if (root == null) {
                numIslands++;
                roots[row][col] = new Coord(row, col);
                root = roots[row][col];
            }
            for (int i = 0; i < dx.length; i++) {
                int rr = row + dy[i];
                int cc = col + dx[i];
                if (rr < 0 || rr >= m || cc < 0 || cc >= n) {
                    continue;
                }
                Coord neighborRoot = findRoot(roots, rr, cc);
                if (neighborRoot != null) {
                    if (neighborRoot.row != root.row || neighborRoot.col != root.col) {
                        roots[neighborRoot.row][neighborRoot.col] = root;
                        numIslands--;
                    }
                }
            }
            results.add(numIslands);
        }
        return results;
    }

    private Coord findRoot(Coord[][] roots, int row, int col) {
        Coord root = roots[row][col];
        if (root == null || root.row == row && root.col == col) {
            return root;
        }
        Coord newRoot = findRoot(roots, root.row, root.col);
        roots[row][col] = newRoot;
        return newRoot;
    }

    public static void main(String[] args){
        NumberOfIslands2 instance = new NumberOfIslands2();
        int[][] positions = new int[][] {
                {0,0},
                {0,1},
                {1,2},
                {2,1},
                {1,1}
        };
        System.out.println(instance.numIslands2(3,3, positions));
    }
}

class Coord {
    int row;
    int col;

    public Coord(int r, int c) {
        row = r;
        col = c;
    }
}
