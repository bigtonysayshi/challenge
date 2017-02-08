package self;

import java.util.*;

/**
 * Serialization is the process of converting a data structure or object into a sequence of bits
 * so that it can be stored in a file or memory buffer,
 * or transmitted across a network connection link to be reconstructed later in the same or another computer environment.
 * Design an algorithm to serialize and deserialize a binary search tree.
 * There is no restriction on how your serialization/deserialization algorithm should work.
 * You just need to ensure that a binary search tree can be serialized to a string and this string can be deserialized to the original tree structure.
 * The encoded string should be as compact as possible.
 * Note: Do not use class member/global/static variables to store states. Your serialize and deserialize algorithms should be stateless.
 */
public class SerializeAndDeserializeBST {
    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        StringBuilder sb = new StringBuilder();
        Stack<TreeNode> stack = new Stack<>();
        if (root != null) {
            stack.push(root);
        }
        while (!stack.isEmpty()) {
            TreeNode node = stack.pop();
            sb.append(node.val);
            sb.append(",");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }
        return sb.toString();
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        if (data == null) return null;
        String[] input = data.split(",");
        Queue<Integer> vals = new LinkedList<>();
        for (String s : input) {
            if (!s.isEmpty()) vals.add(Integer.valueOf(s));
        }
        return construct(vals);
    }

    private TreeNode construct(Queue<Integer> queue) {
        if (queue.isEmpty()) return null;
        TreeNode node = new TreeNode(queue.poll());
        Queue<Integer> leftQueue = new LinkedList<>();
        while (!queue.isEmpty() && queue.peek() < node.val) {
            leftQueue.offer(queue.poll());
        }
        node.left = construct(leftQueue);
        node.right = construct(queue);
        return node;
    }


    public static void main(String[] args){
        SerializeAndDeserializeBST instance = new SerializeAndDeserializeBST();
        System.out.println(instance.serialize(null));
        System.out.println(instance.serialize(new TreeNode(3)));
        TreeNode node = instance.deserialize(instance.serialize(new TreeNode(3)));
        System.out.println(node.val);
        System.out.println(node.left);
    }
}
