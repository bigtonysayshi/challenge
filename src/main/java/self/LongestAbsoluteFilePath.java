package self;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/**
 * Given a string representing the file system in the above format,
 * return the length of the longest absolute path to file in the abstracted file system.
 * If there is no file in the system, return 0.
 * Note:
 * The name of a file contains at least a . and an extension.
 * The name of a directory or sub-directory will not contain a ..
 * Time complexity required: O(n) where n is the size of the input string.
 * Notice that a/aa/aaa/file1.txt is not the longest file path, if there is another path aaaaaaaaaaaaaaaaaaaaa/sth.png.
 */
public class LongestAbsoluteFilePath {
    // Time: O(n) Space: O(n)
    public int lengthLongestPath(String input) {
        String[] parts = input.split("\n");
        int longestPath = 0;
        Stack<Integer> dirStack = new Stack<>();
        int baseLen = 0;
        for (int i = 0; i < parts.length; i++) {
            String part = parts[i];
            int tabs = findTabs(part);
            int len = part.length() - tabs;
            while (tabs < dirStack.size()) {
                baseLen -= (dirStack.pop() + 1);
            }
            if (part.contains(".")) {
                longestPath = Math.max(longestPath, baseLen + len);
            } else {
                dirStack.push(len);
                baseLen += 1 + len;
            }
        }
        return longestPath;
    }

    private int findTabs(String s) {
        int lastIdx = s.lastIndexOf("\t");
        return lastIdx + 1;
    }

    public static void main(String[] args){
        LongestAbsoluteFilePath instance = new LongestAbsoluteFilePath();
        System.out.println(instance.lengthLongestPath("dir\n\t    file.ext"));
        System.out.println(instance.lengthLongestPath("dir\n    file.ext"));
        System.out.println(instance.lengthLongestPath("dir\n\tsubdir1\n\tsubdir2\n\t\tfile.ext"));
        System.out.println(instance.lengthLongestPath("dir\n\tsubdir1\n\t\tfile1.ext\n\t\tsubsubdir1\n\tsubdir2\n\t\tsubsubdir2\n\t\t\tfile2.ext"));
    }
}
