package self;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * Given a n x n matrix where each of the rows and columns are sorted in ascending order,
 * find the kth smallest element in the matrix.
 * Note that it is the kth smallest element in the sorted order, not the kth distinct element.
 * Note:You may assume k is always valid, 1 ≤ k ≤ n^2.
 */
public class KthSmallestElementInASortedMatrix {
    // Time: O(n+k) Space: O(k)
    public int kthSmallest(int[][] matrix, int k) {
        int n = matrix.length;
        PriorityQueue<Tuple> minHeap = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            minHeap.add(new Tuple(0, i, matrix[0][i]));
        }
        for (int i = 0; i < k-1; i++) {
            Tuple t = minHeap.poll();
            if (t.x < n -1) minHeap.add(new Tuple(t.x+1, t.y, matrix[t.x+1][t.y]));
        }
        return minHeap.peek().val;
    }

    public static void main(String[] args){
        KthSmallestElementInASortedMatrix instance = new KthSmallestElementInASortedMatrix();
        System.out.println(instance.kthSmallest(new int[][] {
                {1,5,9},
                {10,11,13},
                {12,13,15}
        }, 8));
    }
}

class Tuple implements Comparable<Tuple> {
    int x, y, val;
    public Tuple(int x, int y, int val) {
        this.x = x;
        this.y = y;
        this.val = val;
    }

    @Override
    public int compareTo(Tuple t) {
        return this.val - t.val;
    }
}