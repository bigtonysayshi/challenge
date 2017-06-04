package self;

import java.util.PriorityQueue;

/**
 * Merge k sorted linked lists and return it as one sorted list. Analyze and describe its complexity.
 */
public class MergeKSortedList {
    // Time: O(knlogk) Space: O(k)
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }
        PriorityQueue<ListNode> minHeap = new PriorityQueue<>((ListNode n1, ListNode n2) -> Integer.compare(n1.val, n2.val));
        for (ListNode listNode : lists) {
            if (listNode != null) {
                minHeap.offer(listNode);
            }
        }
        if (minHeap.isEmpty()) {
            return null;
        }
        ListNode dummy = new ListNode(0);
        ListNode current = dummy;
        while (!minHeap.isEmpty()) {
            ListNode next = minHeap.poll();
            if (next.next != null) {
                minHeap.offer(next.next);
            }
            current.next = next;
            current = next;
        }
        return dummy.next;
    }
}
