package self;

/**
 * Definition for singly-linked list.
 */
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) {
        val = x;
    }

    public static ListNode fromArray(int[] values) {
        ListNode root = new ListNode(values[0]);
        ListNode current = root;
        for (int i = 1; i < values.length; i++) {
            ListNode newNode = new ListNode(values[i]);
            current.next = newNode;
            current = newNode;
        }
        return root;
    }
}
