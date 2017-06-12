package self;

/**
 * Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.
 * You should preserve the original relative order of the nodes in each of the two partitions.
 */
public class PartitionList {
    // Time: O(n) Space: O(1)
    public ListNode partition(ListNode head, int x) {
        ListNode leftHead = null, left = null, rightHead = null, right = null;
        ListNode curr = head;
        while (curr != null) {
            if (curr.val < x) {
                if (leftHead == null) {
                    leftHead = curr;
                }
                if (left != null) {
                    left.next = curr;
                }
                left = curr;
            } else {
                if (rightHead == null) {
                    rightHead = curr;
                }
                if (right != null) {
                    right.next = curr;
                }
                right = curr;
            }
            curr = curr.next;
        }
        if (left == null) {
            return rightHead;
        }
        if (right != null) {
            right.next = null;
        }
        left.next = rightHead;
        return leftHead;
    }
}
