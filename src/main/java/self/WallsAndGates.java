package self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * You are given a m x n 2D grid initialized with these three possible values.
 * -1 - A wall or an obstacle.
 * 0 - A gate.
 * INF - Infinity means an empty room. We use the value 231 - 1 = 2147483647 to represent INF as you may assume that the distance to a gate is less than 2147483647.
 * Fill each empty room with the distance to its nearest gate.
 * If it is impossible to reach a gate, it should be filled with INF.
 */
public class WallsAndGates {
    // Time: O(mn) Space: O(mn)
    public void wallsAndGates(int[][] rooms) {
        int m = rooms.length;
        if (m == 0) return;
        int n = rooms[0].length;
        Queue<Point> points = new LinkedList<>();
        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (rooms[r][c] == 0) points.add(new Point(r, c));
            }
        }
        while (!points.isEmpty()) {
            Point p = points.poll();
            int r = p.row, c = p.col, d = rooms[r][c];
            if (r != 0 && rooms[r-1][c] > d + 1) {
                rooms[r-1][c] = d + 1;
                points.add(new Point(r-1, c));
            }
            if (r != m-1 && rooms[r+1][c] > d + 1) {
                rooms[r+1][c] = d + 1;
                points.add(new Point(r+1, c));
            }
            if (c != 0 && rooms[r][c-1] > d + 1) {
                rooms[r][c-1] = d + 1;
                points.add(new Point(r, c-1));
            }
            if (c != n-1 && rooms[r][c+1] > d + 1) {
                rooms[r][c+1] = d + 1;
                points.add(new Point(r, c+1));
            }
        }
    }
}

class Point {
    int row;
    int col;

    public Point(int r, int c) {
        this.row = r;
        this.col = c;
    }
}