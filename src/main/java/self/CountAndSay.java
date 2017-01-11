package self;

/**
 * The count-and-say sequence is the sequence of integers beginning as follows:
 * 1, 11, 21, 1211, 111221, ...
 * 1 is read off as "one 1" or 11
 * 11 is read off as "two 1s" or 21.
 * 21 is read off as "one 2, then one 1" or 1211.
 * Given an integer n, generate the nth sequence.
 * Note: The sequence of integers will be represented as a string.
 */
public class CountAndSay {
    public String countAndSay(int n) {
        String currSequence = "1";
        for (int i = 1; i < n; i++) {
            StringBuilder sb = new StringBuilder();
            int prevDigit = Character.getNumericValue(currSequence.charAt(0));
            int prevCount = 1;
            for (int j = 1; j < currSequence.length(); j++) {
                int currDigit = Character.getNumericValue(currSequence.charAt(j));
                if (currDigit == prevDigit) {
                    prevCount++;
                } else {
                    sb.append(prevCount);
                    sb.append(prevDigit);
                    prevDigit = currDigit;
                    prevCount = 1;
                }
            }
            sb.append(prevCount);
            sb.append(prevDigit);
            currSequence = sb.toString();
        }
        return currSequence;
    }

    public static void main(String[] args){
        CountAndSay instance = new CountAndSay();
        System.out.println(instance.countAndSay(1));
        System.out.println(instance.countAndSay(2));
        System.out.println(instance.countAndSay(3));
        System.out.println(instance.countAndSay(4));
        System.out.println(instance.countAndSay(5));
        System.out.println(instance.countAndSay(6));
        System.out.println(instance.countAndSay(7));
    }
}
