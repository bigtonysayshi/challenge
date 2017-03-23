package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.
 */
public class PathSum2 {
    // Time: O(n) Space: O(n)
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> results = new ArrayList<>();
        addPath(results, new ArrayList<>(), root, sum);
        return results;
    }

    private void addPath(List<List<Integer>> results,
                         List<Integer> path, TreeNode node, int target) {
        if (node == null) {
            return;
        }
        path.add(node.val);
        target -= node.val;
        if (node.left == null && node.right == null) {
            if (target == 0) {
                results.add(new ArrayList<>(path));
            }
            return;
        }
        if (node.left != null) {
            addPath(results, path, node.left, target);
            path.remove(path.size() - 1);
        }
        if (node.right != null) {
            addPath(results, path, node.right, target);
            path.remove(path.size() - 1);
        }
    }
}
