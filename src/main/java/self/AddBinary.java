package self;

/**
 * Given two binary strings, return their sum (also a binary string).
 */
public class AddBinary {
    // Time: O(m + n) Space: O(1)
    public String addBinary(String a, String b) {
        StringBuilder sb = new StringBuilder();
        boolean carry = false;
        int i = a.length() - 1, j = b.length() - 1;
        while (i >= 0 || j >= 0 || carry) {
            int sum = 0;
            if (i >= 0 && a.charAt(i) == '1') sum++;
            if (j >= 0 && b.charAt(j) == '1') sum++;
            if (carry) sum++;
            sb.append(sum % 2);
            carry = sum > 1;
            i--;
            j--;
        }
        return sb.reverse().toString();
    }

    public static void main(String[] args){
        AddBinary instance = new AddBinary();
        System.out.println(instance.addBinary("11", "1"));
        System.out.println(instance.addBinary("0", "1111"));
        System.out.println(instance.addBinary("11", "1111"));
    }
}
