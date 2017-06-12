package self;

import java.util.PriorityQueue;

/**
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall.
 * When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze,
 * find the shortest distance for the ball to stop at the destination.
 * The distance is defined by the number of empty spaces traveled by the ball from the start position
 * (excluded) to the destination (included). If the ball cannot stop at the destination, return -1.
 * The maze is represented by a binary 2D array. 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column indexes.
 * Note:
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures),
 * but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */
public class TheMaze2 {
    private static final int[][] DIRS = {{0, 1}, {0, -1}, {1, 0}, {-1, 0}};

    // Dijkstra Time: O(mn*log(mn)) Space: O(mn)
    public int shortestDistance(int[][] maze, int[] start, int[] destination) {
        if (maze == null) {
            return -1;
        }
        int m = maze.length;
        if (m == 0) {
            return -1;
        }
        int n = maze[0].length;
        if (n == 0) {
            return -1;
        }
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        dijkstra(maze, start, destination, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void dijkstra(int[][] maze, int[] start, int[] dest, int[][] distance) {
        int m = maze.length;
        int n = maze[0].length;

        PriorityQueue<int[]> queue = new PriorityQueue<>((a, b) -> Integer.compare(a[2], b[2]));
        queue.offer(new int[]{start[0], start[1], 0});
        while (!queue.isEmpty()) {
            int[] current = queue.poll();
            if (current[0] == dest[0] && current[1] == dest[1]) {
                break;
            }
            int currentDist = distance[current[0]][current[1]];
            for (int[] dir : DIRS) {
                int steps = 0;
                int cr = current[0];
                int cc = current[1];
                int nr = cr + dir[0];
                int nc = cc + dir[1];
                while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == 0) {
                    cr = nr;
                    cc = nc;
                    nr = cr + dir[0];
                    nc = cc + dir[1];
                    steps++;
                }
                if (currentDist + steps < distance[cr][cc]) {
                    distance[cr][cc] = currentDist + steps;
                    queue.offer(new int[]{cr, cc, currentDist + steps});
                }
            }
        }
    }

    // DFS Time: O(mn*max(m,n)) Space: O(mn)
    public int shortestDistance2(int[][] maze, int[] start, int[] destination) {
        if (maze == null) {
            return -1;
        }
        int m = maze.length;
        if (m == 0) {
            return -1;
        }
        int n = maze[0].length;
        if (n == 0) {
            return -1;
        }
        int[][] distance = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                distance[i][j] = Integer.MAX_VALUE;
            }
        }
        distance[start[0]][start[1]] = 0;
        getDistance(maze, start, destination, distance);
        return distance[destination[0]][destination[1]] == Integer.MAX_VALUE ? -1 : distance[destination[0]][destination[1]];
    }

    private void getDistance(int[][] maze, int[] current, int[] dest, int[][] distance) {
        int row = current[0];
        int col = current[1];
        if (row == dest[0] && col == dest[1]) {
            return;
        }
        int m = maze.length;
        int n = maze[0].length;

        for (int[] dir : DIRS) {
            int steps = 0;
            int cr = row;
            int cc = col;
            int nr = cr + dir[0];
            int nc = cc + dir[1];
            while (nr >= 0 && nr < m && nc >= 0 && nc < n && maze[nr][nc] == 0) {
                cr = nr;
                cc = nc;
                nr = cr + dir[0];
                nc = cc + dir[1];
                steps++;
            }
            if (distance[row][col] + steps < distance[cr][cc]) {
                distance[cr][cc] = distance[row][col] + steps;
                getDistance(maze, new int[]{cr, cc}, dest, distance);
            }
        }
    }

    public static void main(String[] args){
        TheMaze2 instance = new TheMaze2();
        int[][] maze = new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        System.out.println(instance.shortestDistance(maze, new int[]{0,4}, new int[]{4,4}));
        System.out.println(instance.shortestDistance(maze, new int[]{0,4}, new int[]{3,2}));
    }
}
