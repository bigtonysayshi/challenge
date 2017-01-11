package self;

/**
 * The Hamming distance between two integers is the number of positions at which
 * the corresponding bits are different.
 * Given two integers x and y, calculate the Hamming distance.
 * Note: 0 ≤ x, y < 2^31.
 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        int distance = 0;
        while (x > 0 || y > 0) {
            int xBit = 0, yBit = 0;
            if (x > 0) {
                xBit = x & 1;
                x >>>= 1;
            }
            if (y > 0) {
                yBit = y & 1;
                y >>>= 1;
            }
            if (xBit != yBit) distance++;
        }
        return distance;
    }

    // Just use XOR to get the different bits
    public int hammingDistance2(int x, int y) {
        return Integer.bitCount(x ^ y);
    }

    public static void main(String[] args){
        HammingDistance instance = new HammingDistance();
        System.out.println(instance.hammingDistance(1, 4));
        System.out.println(instance.hammingDistance(1, 1));
    }
}
