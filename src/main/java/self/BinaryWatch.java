package self;

import java.util.LinkedList;
import java.util.List;

/**
 * A binary watch has 4 LEDs on the top which represent the hours (0-11),
 * and the 6 LEDs on the bottom represent the minutes (0-59).
 * Each LED represents a zero or one, with the least significant bit on the right.
 * Given a non-negative integer n which represents the number of LEDs that are currently on,
 * return all possible times the watch could represent.
 *
 * The order of output does not matter.
 * The hour must not contain a leading zero, for example "01:00" is not valid, it should be "1:00".
 * The minute must be consist of two digits and may contain a leading zero,
 * for example "10:2" is not valid, it should be "10:02".
 */
public class BinaryWatch {
    // Time: O(1) Space: O(1). Smart!
    public List<String> readBinaryWatch(int num) {
        List<String> times = new LinkedList<String>();
        for (int h = 0; h < 12; h++) {
            for (int m = 0; m < 60; m ++) {
                if (Integer.bitCount(m + h * 64) == num) {
                    times.add(String.format("%d:%02d", h, m));
                }
            }
        }
        return times;
    }

    // Time: O(1) Space: O(1)
    public List<String> readBinaryWatch2(int num) {
        List<String> times = new LinkedList<String>();
        for (int n = 0; n < 1024; n++) {
            boolean[] binaryArray = numToBinaryArray(n);
            if (numBitsSet(binaryArray) == num) {
                boolean[] hourBinaryArray = new boolean[4];
                boolean[] minuteBinaryArray = new boolean[6];
                for (int i = 0; i < 4; i++) {
                    hourBinaryArray[i] = binaryArray[i];
                }
                for (int i = 4; i < 10; i++) {
                    minuteBinaryArray[i - 4] = binaryArray[i];
                }

                int hour = binaryArrayToValue(hourBinaryArray);
                int minute = binaryArrayToValue(minuteBinaryArray);
                if (hour > 11 || minute > 59) {
                    continue;
                }
                String time = Integer.toString(hour) + ":" + String.format("%02d", minute);
                times.add(time);
            }
        }
        return times;

    }

    private boolean[] numToBinaryArray(int n) {
        boolean[] binaryArray = new boolean[10];
        for (int i = 0; i < 10; i++) {
            if ((n & 1) == 1) {
                binaryArray[9 - i] = true;
            }
            n >>= 1;
        }
        return binaryArray;
    }

    private int numBitsSet(boolean[] binaryArray) {
        int bitsSet = 0;
        for (boolean b : binaryArray) {
            if (b) bitsSet++;
        }
        return bitsSet;
    }

    private int binaryArrayToValue(boolean[] binaryArray) {
        int size = binaryArray.length;
        int value = 0;
        for (int i = 0; i < size; i++) {
            boolean binary = binaryArray[size - 1 - i];
            if (binary) value += Math.pow(2, i);
        }
        return  value;
    }

    public static void main(String[] args){
        BinaryWatch instance = new BinaryWatch();
        System.out.println(instance.readBinaryWatch(1));
    }

}
