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
    // Time: O(klogk) Space: O(mn)
    public int kthSmallest(int[][] matrix, int k) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0 || k <= 0) {
            return 0;
        }
        int n = matrix.length, m = matrix[0].length;
        PriorityQueue<Entry> entryQueue = new PriorityQueue<Entry>();
        entryQueue.offer(new Entry(0, 0, matrix[0][0]));
        boolean[][] checked = new boolean[n][m];
        checked[0][0] = true;

        int[] dx = new int[]{0, 1};
        int[] dy = new int[]{1, 0};

        for (int i = 0; i < k -1; i++) {
            Entry entry = entryQueue.poll();
            for (int j = 0; j < 2; j++) {
                int row = entry.row + dy[j];
                int col = entry.col + dx[j];
                if (row < n && col < m && !checked[row][col]) {
                    checked[row][col] = true;
                    entryQueue.offer(new Entry(row, col, matrix[row][col]));
                }
            }
        }
        return entryQueue.peek().val;
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

class Entry implements Comparable<Entry> {
    int row;
    int col;
    int val;

    public Entry(int row, int col, int val) {
        this.row = row;
        this.col = col;
        this.val = val;
    }

    @Override
    public int compareTo(Entry e) {
        return this.val - e.val;
    }
}
