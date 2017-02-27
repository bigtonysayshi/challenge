package self;

import java.util.*;

/**
 * Given a binary tree, return the vertical order traversal of its nodes' values.
 * (ie, from top to bottom, column by column).
 * If two nodes are in the same row and column, the order should be from left to right.
 */
public class BinaryTreeVerticalOrderTraversal {
    // Time: O(nlogn) Space: O(n)
    public List<List<Integer>> verticalOrder(TreeNode root) {
        Queue<NodeWithLevel> nodeQueue = new LinkedList<>();
        if (root != null) nodeQueue.add(new NodeWithLevel(root, 0));
        Map<Integer, List<Integer>> levelMap = new TreeMap<>();
        while (!nodeQueue.isEmpty()) {
            NodeWithLevel nodeWithLevel = nodeQueue.poll();
            TreeNode node = nodeWithLevel.node;
            int level = nodeWithLevel.level;
            if (!levelMap.containsKey(level)) levelMap.put(level, new LinkedList<>());
            List<Integer> currentLevel = levelMap.get(level);
            currentLevel.add(node.val);
            if (node.left != null) nodeQueue.add(new NodeWithLevel(node.left, level-1));
            if (node.right != null) nodeQueue.add(new NodeWithLevel(node.right, level+1));
        }
        return new ArrayList<>(levelMap.values());
    }

}

class NodeWithLevel {
    TreeNode node;
    int level;

    public NodeWithLevel(TreeNode node, int level) {
        this.node = node;
        this.level = level;
    }
}
