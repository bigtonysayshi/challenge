package self;

import java.util.HashMap;
import java.util.Map;

/**
 * Given n, how many structurally unique BST's (binary search trees) that store values 1...n?
 */
public class UniqueBinarySearchTrees {
    // Time: O(n^2) Space: O(n)
    public int numTrees(int n) {
        int[] combos = new int[n+1];
        combos[0] = combos[1] = 1;
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                combos[i] += combos[j-1] * combos[i-j];
            }
        }
        return combos[n];
    }

    public static void main(String[] args){
        UniqueBinarySearchTrees instance = new UniqueBinarySearchTrees();
        System.out.println(instance.numTrees(1));
        System.out.println(instance.numTrees(2));
        System.out.println(instance.numTrees(3));
    }
}
