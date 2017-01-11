package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a binary tree, return all root-to-leaf paths.
 */
public class BinaryTreePaths {
    public List<String> binaryTreePaths(TreeNode root) {
        List<String> results = new ArrayList<String>();
        pathHelper(root, new StringBuilder(), results);
        return results;
    }

    private void pathHelper(TreeNode node, StringBuilder parentPath, List<String> results) {
        if (node == null) return;
        StringBuilder newParentPath = new StringBuilder(parentPath);
        if (!parentPath.toString().isEmpty()) {
            newParentPath.append("->");
        }
        newParentPath.append(node.val);
        if (node.left == null && node.right == null) {
            results.add(newParentPath.toString());
            return;
        }
        if (node.left != null) pathHelper(node.left, newParentPath, results);
        if (node.right != null) pathHelper(node.right, newParentPath, results);
    }
}
