package self;

import java.util.Arrays;

/**
 * There is a ball in a maze with empty spaces and walls.
 * The ball can go through empty spaces by rolling up, down, left or right,
 * but it won't stop rolling until hitting a wall.
 * When the ball stops, it could choose the next direction.
 * Given the ball's start position, the destination and the maze,
 * determine whether the ball could stop at the destination.
 * The maze is represented by a binary 2D array.
 * 1 means the wall and 0 means the empty space.
 * You may assume that the borders of the maze are all walls.
 * The start and destination coordinates are represented by row and column indexes.
 * Note:
 * There is only one ball and one destination in the maze.
 * Both the ball and the destination exist on an empty space, and they will not be at the same position initially.
 * The given maze does not contain border (like the red rectangle in the example pictures),
 * but you could assume the border of the maze are all walls.
 * The maze contains at least 2 empty spaces, and both the width and height of the maze won't exceed 100.
 */
public class TheMaze {
    // Time: O(n^2) Space: O(n^2)
    public boolean hasPath(int[][] maze, int[] start, int[] destination) {
        int m = maze.length;
        if (m == 0) return false;
        int n = maze[0].length;
        boolean[][] visited = new boolean[m][n];
        return explore(maze, start, destination, visited);
    }

    private boolean explore(int[][] maze, int[] start, int[] destination, boolean[][] visited) {
        if (Arrays.equals(start, destination)) return true;
        int x = start[0], y = start[1];
        if (visited[x][y]) return false;
        visited[x][y] = true;
        if (x > 0) {
            int newX = x;
            while (newX > 0 && maze[newX-1][y] == 0) {
                newX--;
            }
            boolean found = explore(maze, new int[]{newX,y}, destination, visited);
            if (found) return true;
        }
        if (x < maze.length - 1) {
            int newX = x;
            while (newX < maze.length - 1 && maze[newX+1][y] == 0) {
                newX++;
            }
            boolean found = explore(maze, new int[]{newX,y}, destination, visited);
            if (found) return true;
        }
        if (y > 0) {
            int newY = y;
            while (newY > 0 && maze[x][newY-1] == 0) {
                newY--;
            }
            boolean found = explore(maze, new int[]{x,newY}, destination, visited);
            if (found) return true;
        }
        if (y < maze[0].length - 1) {
            int newY = y;
            while (newY < maze[0].length - 1 && maze[x][newY+1] == 0) {
                newY++;
            }
            boolean found = explore(maze, new int[]{x,newY}, destination, visited);
            if (found) return true;
        }
        return false;
    }

    public static void main(String[] args){
        TheMaze instance = new TheMaze();
        int[][] maze = new int[][]{
                {0,0,1,0,0},
                {0,0,0,0,0},
                {0,0,0,1,0},
                {1,1,0,1,1},
                {0,0,0,0,0}
        };
        System.out.println(instance.hasPath(maze, new int[]{0,4}, new int[]{4,4}));
        System.out.println(instance.hasPath(maze, new int[]{0,4}, new int[]{3,2}));
    }
}
