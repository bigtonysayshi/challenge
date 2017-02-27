package self;

/**
 * A character in UTF8 can be from 1 to 4 bytes long, subjected to the following rules:
 * For 1-byte character, the first bit is a 0, followed by its unicode code.
 * For n-bytes character, the first n-bits are all one's,
 * the n+1 bit is 0, followed by n-1 bytes with most significant 2 bits being 10.
 * Given an array of integers representing the data, return whether it is a valid utf-8 encoding.
 * Note:
 * The input is an array of integers. Only the least significant 8 bits of each integer is used to store the data.
 * This means each integer represents only 1 byte of data.
 */
public class UTF8Validation {
    // Time: O(n) Space: O(1)
    public boolean validUtf8(int[] data) {
        int count = 0;
        for (int d : data) {
            int b = d & 0b11111111;
            if (count == 0) {
                if ((b >> 5) == 0b110) {
                    count = 1;
                } else if ((b >> 4) == 0b1110) {
                    count = 2;
                } else if ((b >> 3) == 0b11110) {
                    count = 3;
                } else if ((b >> 7) > 0) {
                    return false;
                }
            } else {
                if ((b >> 6) != 0b10) return false;
                count--;
            }
        }
        return count == 0;
    }

    public static void main(String[] args){
        UTF8Validation instance = new UTF8Validation();
        System.out.println(instance.validUtf8(new int[]{197,130,1}));
        System.out.println(instance.validUtf8(new int[]{235,140,4}));
        System.out.println(instance.validUtf8(new int[]{145}));
        System.out.println(instance.validUtf8(new int[]{240,162,138,147,145}));
        System.out.println(instance.validUtf8(new int[]{250,145,145,145,145}));
    }
}
