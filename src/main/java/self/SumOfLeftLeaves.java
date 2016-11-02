package self;

/**
 * Find the sum of all left leaves in a given binary tree.
 */
public class SumOfLeftLeaves {
    public int sumOfLeftLeaves(TreeNode root) {
        if (root == null) {
            return 0;
        }
        int sum = sumOfLeftLeaves(root.right);
        if (root.left != null)  {
            if (root.left.left == null && root.left.right == null) {
                sum += root.left.val;
            } else {
                sum += sumOfLeftLeaves(root.left);
            }
        }
        return sum;
    }
}
