package self;


/**
 * Write a function that takes a string as input and returns the string reversed.
 */
public class ReverseString {
    // n = s.length(); Time: O(n) Space: O(n)
    public String reverseString(String s) {
        if (s == null || s.length() == 0) {
            return "";
        }
        int size = s.length();
        char[] reverseChars = new char[size];

        for (int i = 0; i < size; i++) {
            char c = s.charAt(i);
            reverseChars[size - 1 - i] = c;
        }
        return String.copyValueOf(reverseChars);
    }


    public static void main(String[] args){
        ReverseString instance = new ReverseString();
        String input = "hello";
        System.out.println(instance.reverseString(input));
    }
}
