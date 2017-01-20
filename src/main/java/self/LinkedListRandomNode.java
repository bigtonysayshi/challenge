package self;

import java.util.Random;

/**
 * Given a singly linked list, return a random node's value from the linked list.
 * Each node must have the same probability of being chosen.
 * Follow up:
 * What if the linked list is extremely large and its length is unknown to you?
 * Could you solve this efficiently without using extra space?
 */
public class LinkedListRandomNode {
    ListNode head;
    Random generator;

    /** @param head The linked list's head.
    Note that the head is guaranteed to be not null, so it contains at least one node. */
    public LinkedListRandomNode(ListNode head) {
        this.head = head;
        generator = new Random();
    }

    // Reservoir Sampling
    /** Returns a random node's value. */
    public int getRandom() {
        ListNode node = head;
        int val = head.val;
        for (int i = 1; node != null; i++) {
            if (generator.nextInt(i) == 0) {
                val = node.val;
            }
            node = node.next;
        }
        return val;
    }
}
