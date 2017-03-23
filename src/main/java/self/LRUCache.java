package self;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Design and implement a data structure for Least Recently Used (LRU) cache.
 * It should support the following operations: get and put.
 * get(key) - Get the value (will always be positive) of the key if the key exists in the cache, otherwise return -1.
 * put(key, value) - Set or insert the value if the key is not already present. When the cache reached its capacity, it should invalidate the least recently used item before inserting a new item.
 * Follow up: Could you do both operations in O(1) time complexity?
 */
public class LRUCache {
    private int capacity;
    private Map<Integer, DListNode> cache;
    DListNode head;
    DListNode tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        cache = new HashMap<>();
        head = null;
        tail = null;
    }

    public int get(int key) {
        DListNode current = cache.get(key);
        if (current == null) {
            return -1;
        }
        if (current != tail) {
            if (current != head) {
                current.prev.next = current.next;
            } else {
                head = current.next;
            }
            current.next.prev = current.prev;
            current.next = null;
            tail.next = current;
            current.prev = tail;
            tail = current;
        }
        return current.value;
    }

    public void put(int key, int value) {
        DListNode current = cache.get(key);
        if (current == null) {
            DListNode node = new DListNode(key, value);
            if (head == null && tail == null) {
                head = node;
                tail = node;
            } else {
                tail.next = node;
                node.prev = tail;
                tail = node;
            }
            cache.put(key, node);

            if (cache.size() > capacity) {
                DListNode newHead = head.next;
                newHead.prev = null;
                head.next = null;
                cache.remove(head.key);
                head = newHead;
            }
        } else {
            if (current != tail) {
                if (current != head) {
                    current.prev.next = current.next;
                } else {
                    head = current.next;
                }
                current.next.prev = current.prev;
                current.next = null;
                tail.next = current;
                current.prev = tail;
                tail = current;
            }
            current.value = value;
        }
    }

    public static void main(String[] args){
        LRUCache instance = new LRUCache(2);

        instance.put(1, 1);
        instance.put(2, 2);
        System.out.println(instance.get(1));    // returns 1
        instance.put(3, 3);    // evicts key 2
        System.out.println(instance.get(2));    // returns -1 (not found)
        instance.put(4, 4);    // evicts key 1
        System.out.println(instance.get(1));    // returns -1 (not found)
        System.out.println(instance.get(3));    // returns 3
        System.out.println(instance.get(4));    // returns 4
    }
}

class DListNode {
    int key;
    int value;
    DListNode prev;
    DListNode next;

    public DListNode(int key, int value) {
        this.key = key;
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
