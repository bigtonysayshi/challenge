package self;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Design an algorithm to serialize and deserialize a binary tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * Note: Do not use class member/global/static variables to store states.
 * Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBinaryTree {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        nodeQueue.offer(root);
        StringBuilder sb = new StringBuilder();
        while (!nodeQueue.isEmpty()) {
            TreeNode node = nodeQueue.poll();
            if (node == null) {
                sb.append("null,");
            } else {
                sb.append(node.val).append(",");
                nodeQueue.offer(node.left);
                nodeQueue.offer(node.right);
            }
        }
        if (sb.length() > 1) {
            sb.deleteCharAt(sb.length() - 1);
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        Queue<TreeNode> nodeQueue = new LinkedList<>();
        TreeNode root = makeNode(vals[0]);
        if (root != null) {
            nodeQueue.offer(root);
        }
        int nextIdx = 1;
        while (!nodeQueue.isEmpty() && nextIdx < vals.length) {
            TreeNode node = nodeQueue.poll();
            TreeNode left = makeNode(vals[nextIdx++]);
            TreeNode right = makeNode(vals[nextIdx++]);
            if (left != null) {
                nodeQueue.offer(left);
            }
            if (right != null) {
                nodeQueue.offer(right);
            }
            node.left = left;
            node.right = right;
        }
        return root;
    }

    private TreeNode makeNode(String s) {
        return s.equals("null") ? null : new TreeNode(Integer.valueOf(s));
    }
}
