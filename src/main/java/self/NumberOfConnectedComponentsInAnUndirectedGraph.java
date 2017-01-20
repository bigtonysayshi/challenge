package self;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to find the number of connected components in an undirected graph.
 * You can assume that no duplicate edges will appear in edges.
 * Since all edges are undirected, [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class NumberOfConnectedComponentsInAnUndirectedGraph {
    // Time: O(n + k) Space: O(n)
    public int countComponents(int n, int[][] edges) {
        int[] roots = new int[n];
        int components = n;
        for (int i = 0; i < n; i++) {
            roots[i] = i;
        }
        for (int[] edge : edges) {
            int first = edge[0], second = edge[1];
            int root1 = findRoot(first, roots);
            int root2 = findRoot(second, roots);
            if (root1 != root2) {
                roots[root2] = root1;
                components--;
            }
        }
        return components;
    }

    private int findRoot(int k, int[] roots) {
        int val = roots[k];
        while (val != k) {
            k = val;
            val = roots[val];
        }
        return val;
    }

    public static void main(String[] args){
        NumberOfConnectedComponentsInAnUndirectedGraph instance = new NumberOfConnectedComponentsInAnUndirectedGraph();
        System.out.println(instance.countComponents(5, new int[][] {{0,1},{1,2},{3,4}}));
        System.out.println(instance.countComponents(6, new int[][] {{0,1},{1,2},{3,4},{3,2}}));
    }
}
