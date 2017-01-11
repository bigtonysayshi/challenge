package self;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a non-empty binary search tree and a target value,
 * find the value in the BST that is closest to the target.
 * Note:
 * Given target value is a floating point.
 * You are guaranteed to have only one unique value in the BST that is closest to the target.
 */
public class ClosestBinarySearchTreeValue {
    public int closestValue(TreeNode root, double target) {
        TreeNode next = root.val < target ? root.right : root.left;
        if (next == null) return root.val;
        int closestChildVal = closestValue(next, target);
        return Math.abs(target - root.val) < Math.abs(target - closestChildVal) ?
                root.val : closestChildVal;
    }

}
