package self;

/**
 * Given a sorted linked list, delete all duplicates such that each element appear only once.
 */
public class RemoveDuplicatesFromSortedList {
    // Time: O(n) Space: O(1)
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null) return head;
        ListNode currentNode = head;
        ListNode nextNode = currentNode.next;
        while (nextNode != null) {
            if (nextNode.val != currentNode.val) {
                currentNode = nextNode;
            } else {
                currentNode.next = nextNode.next;
            }
            nextNode = nextNode.next;
        }
        return head;
    }
}
