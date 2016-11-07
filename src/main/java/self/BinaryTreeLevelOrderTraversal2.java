package self;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

/**
 * Given a binary tree, return the bottom-up level order traversal of its nodes' values.
 * (ie, from left to right, level by level from leaf to root).
 */
public class BinaryTreeLevelOrderTraversal2 {

    // BFS, 2 Queues
    public List<List<Integer>> levelOrderBottom(TreeNode root) {
        List<List<Integer>> results = new ArrayList<List<Integer>>();
        if (root == null) return results;

        List<Integer> currentLevelResults = new ArrayList<Integer>();
        Queue<TreeNode> nodeQueue = new LinkedList<TreeNode>();
        nodeQueue.add(root);
        Queue<TreeNode> nextLevelQueue = new LinkedList<TreeNode>();

        while (!nodeQueue.isEmpty() || !nextLevelQueue.isEmpty()) {
            if (nodeQueue.isEmpty()) {
                nodeQueue.addAll(nextLevelQueue);
                nextLevelQueue.clear();
                results.add(0, currentLevelResults);
                currentLevelResults = new ArrayList<Integer>();
            }
            TreeNode node = nodeQueue.poll();
            currentLevelResults.add(node.val);
            if (node.left != null) nextLevelQueue.add(node.left);
            if (node.right != null) nextLevelQueue.add(node.right);
        }
        results.add(0, currentLevelResults);
        return results;
    }
}
