package self;

/**
 * Count the number of segments in a string, where a segment is defined to be a
 * contiguous sequence of non-space characters.
 * Please note that the string does not contain any non-printable characters.
 */
public class NumberOfSegmentsInAString {
    // Time: O(n) Space: O(1)
    public int countSegments(String s) {
        int segments = 0;
        boolean wasSpace = true;
        for (int i = 0; i < s.length(); i ++) {
            if (s.charAt(i) == ' ') {
                wasSpace = true;
            } else if (wasSpace) {
                segments++;
                wasSpace = false;
            }
        }
        return segments;
    }

    public static void main(String[] args){
        NumberOfSegmentsInAString instance = new NumberOfSegmentsInAString();
        System.out.println(instance.countSegments(" "));
        System.out.println(instance.countSegments(""));
        System.out.println(instance.countSegments("1"));
        System.out.println(instance.countSegments("Hello, my name is John"));
    }
}
