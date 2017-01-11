package self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the level order traversal of its nodes' values.
 * (ie, from left to right, level by level).
 */
public class BinaryTreeLevelOrderTraversal {
    // BFS
    public List<List<Integer>> levelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.add(root);
        while (!nodeQueue.isEmpty()) {
            int queueSize = nodeQueue.size();
            List<Integer> currentLevel = new ArrayList<>();
            for (int i = 0; i < queueSize; i++) {
                TreeNode node = nodeQueue.poll();
                currentLevel.add(node.val);
                if (node.left != null) nodeQueue.add(node.left);
                if (node.right != null) nodeQueue.add(node.right);
            }
            results.add(currentLevel);
        }
        return results;
    }

    // DFS
    public List<List<Integer>> levelOrder2(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        if (root == null) return results;
        dfsHelper(root, results, 0);
        return results;
    }

    private void dfsHelper(TreeNode node, List<List<Integer>> levels, int depth) {
        if (depth == levels.size()) levels.add(new ArrayList<Integer>());
        List<Integer> level = levels.get(depth);
        level.add(node.val);
        if (node.left != null) dfsHelper(node.left, levels, depth+1);
        if (node.right != null) dfsHelper(node.right, levels, depth+1);
    }
}
