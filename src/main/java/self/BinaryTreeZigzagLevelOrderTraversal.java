package self;

import java.util.*;

/**
 * Given a binary tree, return the zigzag level order traversal of its nodes' values.
 * (ie, from left to right, then right to left for the next level and alternate between).
 */
public class BinaryTreeZigzagLevelOrderTraversal {
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> results = new ArrayList<>();
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.offer(root);
        boolean reverse = false;
        while (!nodeQueue.isEmpty()) {
            int levelNodes = nodeQueue.size();
            List<Integer> level = new ArrayList<>(levelNodes);
            for (int i = 0; i < levelNodes; i++) {
                TreeNode node = nodeQueue.poll();
                level.add(node.val);
                if (node.left != null) nodeQueue.offer(node.left);
                if (node.right != null) nodeQueue.offer(node.right);
            }
            if (reverse) Collections.reverse(level);
            reverse = !reverse;
            results.add(level);
        }
        return results;
    }
}
