package self;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Set;

/**
 * A linked list is given such that each node contains an additional random pointer which could point to any node in the list or null.
 * Return a deep copy of the list.
 */
public class CopyListWithRandomPointer {
    // Time: O(n) Space: O(n)
    public RandomListNode copyRandomList(RandomListNode head) {
        if (head == null) {
            return null;
        }
        Map<RandomListNode, RandomListNode> nodeCopies = new HashMap<>();
        RandomListNode current = head;
        while (current != null) {
            nodeCopies.put(current, new RandomListNode(current.label));
            current = current.next;
        }

        current = head;
        RandomListNode copy = nodeCopies.get(head);
        while (current != null) {
            copy.next = nodeCopies.get(current.next);
            copy.random = nodeCopies.get(current.random);
            copy = copy.next;
            current = current.next;
        }
        return nodeCopies.get(head);
    }
}
