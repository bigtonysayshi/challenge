package self;

import java.util.Random;

/**
 * Shuffle a set of numbers without duplicates.
 */
public class ShuffleAnArray {
    private int[] original;
    private Random rdn;
    public ShuffleAnArray(int[] nums) {
        original = nums;
        rdn = new Random();
    }

    /** Resets the array to its original configuration and return it. */
    public int[] reset() {
        return original;
    }

    /** Returns a random shuffling of the array. */
    public int[] shuffle() {
        if (original == null) return null;
        int[] copy = original.clone();
        for (int i = 0; i < copy.length; i++) {
            int idx = rdn.nextInt(i+1);
            int tmp = copy[i];
            copy[i] = copy[idx];
            copy[idx] = tmp;
        }
        return copy;
    }
}
