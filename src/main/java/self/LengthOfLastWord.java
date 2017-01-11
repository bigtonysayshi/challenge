package self;

/**
 * Given a string s consists of upper/lower-case alphabets and empty space characters ' ',
 * return the length of last word in the string.
 * If the last word does not exist, return 0.
 * Note: A word is defined as a character sequence consists of non-space characters only.
 */
public class LengthOfLastWord {
    public int lengthOfLastWord(String s) {
        String[] words = s.split(" ");
        for (int i = words.length - 1; i >= 0; i--) {
            if (words[i].length() > 0) return words[i].length();
        }
        return 0;
    }

    public static void main(String[] args){
        LengthOfLastWord instance = new LengthOfLastWord();
        System.out.println(instance.lengthOfLastWord(""));
        System.out.println(instance.lengthOfLastWord(" "));
        System.out.println(instance.lengthOfLastWord(" a  "));
        System.out.println(instance.lengthOfLastWord("Hello World"));
    }
}
