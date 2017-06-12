package self;

import java.util.ArrayList;
import java.util.List;

/**
 * There are a total of n courses you have to take, labeled from 0 to n - 1.
 * Some courses may have prerequisites, for example to take course 0 you have to first take course 1,
 * which is expressed as a pair: [0,1]
 * Given the total number of courses and a list of prerequisite pairs, is it possible for you to finish all courses?
 * Note:
 * The input prerequisites is a graph represented by a list of edges, not adjacency matrices.
 * Read more about how a graph is represented.
 * You may assume that there are no duplicate edges in the input prerequisites.
 */
public class CourseSchedule {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] edges = new List[numCourses];
        for (int i = 0; i < numCourses; i++) {
            edges[i] = new ArrayList<>();
        }
        for (int[] pair : prerequisites) {
            edges[pair[0]].add(pair[1]);
        }
        for (int i = 0; i < numCourses; i++) {
            if (hasCycle(edges, i, new boolean[numCourses])) {
                return false;
            }
        }
        return true;
    }

    private boolean hasCycle(List<Integer>[] edges, int idx, boolean[] visited) {
        if (visited[idx]) {
            return true;
        }
        visited[idx] = true;
        List<Integer> neighbors = edges[idx];
        for (Integer neighbor : neighbors) {
            if (hasCycle(edges, neighbor, visited)) {
                return true;
            }
        }
        visited[idx] = false;
        return false;
    }

    public static void main(String[] args){
        CourseSchedule instance = new CourseSchedule();
        System.out.println(instance.canFinish(2, new int[][]{{1, 0}}));
        System.out.println(instance.canFinish(2, new int[][]{{1, 0}, {0, 1}}));
        System.out.println(instance.canFinish(4, new int[][]{{1, 0}, {2, 1}, {3, 2}, {1, 3}}));
    }
}
