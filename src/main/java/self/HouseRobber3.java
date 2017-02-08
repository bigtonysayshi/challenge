package self;

import java.util.HashMap;
import java.util.Map;

/**
 * The thief has found himself a new place for his thievery again.
 * There is only one entrance to this area, called the "root."
 * Besides the root, each house has one and only one parent house.
 * After a tour, the smart thief realized that "all houses in this place forms a binary tree".
 * It will automatically contact the police if two directly-linked houses were broken into on the same night.
 * Determine the maximum amount of money the thief can rob tonight without alerting the police.
 */
public class HouseRobber3 {
    // Time: O(n) Space: O(n)
    public int rob(TreeNode root) {
        return robHelper(root, new HashMap<>());
    }

    private int robHelper(TreeNode root, Map<TreeNode, Integer> values) {
        if (root == null) return 0;
        if (!values.containsKey(root)) {
            int takeRoot = root.val;
            if (root.left != null) takeRoot += robHelper(root.left.left, values) + robHelper(root.left.right, values);
            if (root.right != null) takeRoot += robHelper(root.right.left, values) + robHelper(root.right.right, values);
            int skipRoot = robHelper(root.left, values) + robHelper(root.right, values);
            values.put(root, Math.max(takeRoot, skipRoot));
        }
        return values.get(root);
    }
}
