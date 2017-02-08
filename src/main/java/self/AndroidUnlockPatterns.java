package self;

/**
 * Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9,
 * count the total number of unlock patterns of the Android lock screen,
 * which consist of minimum of m keys and maximum n keys.
 * Rules for a valid pattern:
 * Each pattern must connect at least m keys and at most n keys.
 * All the keys must be distinct.
 * If the line connecting two consecutive keys in the pattern passes through any other keys,
 * the other keys must have previously selected in the pattern.
 * No jumps through non selected key is allowed.
 * The order of keys used matters.
 */
public class AndroidUnlockPatterns {
    private boolean[] selected;

    // Backtracking
    // Time: O(n!) Space: O(n)
    public int numberOfPatterns(int m, int n) {
        int numPatterns = 0;
        for (int len = m; len <= n; len++) {
            selected = new boolean[9];
            numPatterns += countPatterns(-1, len);
        }
        return numPatterns;
    }

    private int countPatterns(int last, int len) {
        if (len == 0) return 1;
        int patterns = 0;
        for (int i = 0; i < 9; i++) {
            if (isValidPattern(last, i)) {
                selected[i] = true;
                patterns += countPatterns(i, len - 1);
                selected[i] = false;
            }
        }
        return patterns;
    }

    private boolean isValidPattern(int last, int idx) {
        if (selected[idx]) return false;
        if (last == -1) return true;
        // Adjacent or knight move
        if ((last + idx) % 2 == 1) return true;
        // On the same diagonal but not adjacent
        int mid = (last + idx) / 2;
        if (mid == 4) return selected[mid];
        // Adjacent on diagonal
        if ((idx%3 != last%3) && (idx/3 != last/3)) {
            return true;
        }
        // On the same row / col but not adjacent
        return selected[mid];
    }

    public static void main(String[] args){
        AndroidUnlockPatterns instance = new AndroidUnlockPatterns();
        System.out.println(instance.numberOfPatterns(1,1));
        System.out.println(instance.numberOfPatterns(1,2));
    }
}
