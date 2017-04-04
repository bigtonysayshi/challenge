package self;

import java.util.BitSet;

/**
 * Design a Phone Directory which supports the following operations:
 * get: Provide a number which is not assigned to anyone.
 * check: Check if a number is available or not.
 * release: Recycle or release a number.
 */
public class DesignPhoneDirectory {
    BitSet bits;
    int maxNumbers;
    int nextIdx;

    /** Initialize your data structure here
     @param maxNumbers - The maximum numbers that can be stored in the phone directory. */
    public DesignPhoneDirectory(int maxNumbers) {
        this.maxNumbers = maxNumbers;
        this.bits = new BitSet(maxNumbers);
        nextIdx = 0;
    }

    /** Provide a number which is not assigned to anyone.
     @return - Return an available number. Return -1 if none is available. */
    public int get() {
        if (nextIdx == maxNumbers) {
            return -1;
        }
        int num = nextIdx;
        bits.set(num);
        nextIdx = bits.nextClearBit(nextIdx);
        return num;
    }

    /** Check if a number is available or not. */
    public boolean check(int number) {
        if (number < 0 || number > maxNumbers) {
            return false;
        }
        return !bits.get(number);
    }

    /** Recycle or release a number. */
    public void release(int number) {
        if (number < 0 || number > maxNumbers || !bits.get(number)) {
            return;
        }
        bits.clear(number);
        if (number < nextIdx) {
            nextIdx = number;
        }
    }
}
