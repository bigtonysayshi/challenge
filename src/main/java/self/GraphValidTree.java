package self;

import java.util.*;

/**
 * Given n nodes labeled from 0 to n - 1 and a list of undirected edges (each edge is a pair of nodes),
 * write a function to check whether these edges make up a valid tree.
 * Note: you can assume that no duplicate edges will appear in edges. Since all edges are undirected,
 * [0, 1] is the same as [1, 0] and thus will not appear together in edges.
 */
public class GraphValidTree {
    // Time: O(n^2) Space: O(n)
    public boolean validTree(int n, int[][] edges) {
        if (edges.length != n-1) return false;
        int[] roots = new int[n];
        Arrays.fill(roots, -1);
        for (int[] edge : edges) {
            int r1 = findRoot(roots, edge[0]);
            int r2 = findRoot(roots, edge[1]);
            if (r1 == r2) return false;
            roots[r2] = r1;
        }
        return true;
    }

    private int findRoot(int[] roots, int n) {
        if (roots[n] == -1) return n;
        return findRoot(roots, roots[n]);
    }

    public static void main(String[] args){
        GraphValidTree instance = new GraphValidTree();
        System.out.println(instance.validTree(4,new int[][]{{0,1},{3,2}}));
        System.out.println(instance.validTree(3,new int[][]{{0,2},{1,2}}));
        System.out.println(instance.validTree(5,new int[][]{{0,1},{0,2},{0,3},{1,4}}));
        System.out.println(instance.validTree(5,new int[][]{{0,1},{1,2},{2,3},{1,3},{1,4}}));
    }
}
