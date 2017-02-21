package self;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 */
public class BinaryTreeRightSideView {
    // Time: O(n) Space: O(n)
    public List<Integer> rightSideView(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        Queue<TreeNode> currentLevel = new LinkedList<>();
        Queue<TreeNode> nextLevel = new LinkedList<>();
        if (root != null) currentLevel.add(root);
        while (!currentLevel.isEmpty() || !nextLevel.isEmpty()) {
            if (currentLevel.isEmpty()) {
                while (!nextLevel.isEmpty()) {
                    currentLevel.add(nextLevel.poll());
                }
            } else {
                TreeNode node = currentLevel.poll();
                if (node.left != null) nextLevel.add(node.left);
                if (node.right != null) nextLevel.add(node.right);
                if (currentLevel.isEmpty()) results.add(node.val);
            }
        }
        return results;
    }

    // Recursive method
    public List<Integer> rightSideView2(TreeNode root) {
        List<Integer> results = new LinkedList<>();
        traverse(root, results, 0);
        return results;
    }

    private void traverse(TreeNode node, List<Integer> resutls, int depth) {
        if (node == null) return;
        if (depth == resutls.size()) resutls.add(node.val);
        traverse(node.right, resutls, depth+1);
        traverse(node.left, resutls, depth+1);
    }
}
