package self;

/**
 * One way to serialize a binary tree is to use pre-order traversal.
 * When we encounter a non-null node, we record the node's value.
 * If it is a null node, we record using a sentinel value such as #
 * Given a string of comma separated values, verify whether it is a correct preorder traversal serialization of a binary tree.
 * Find an algorithm without reconstructing the tree.
 * Each comma separated value in the string must be either an integer or a character '#' representing null pointer.
 * You may assume that the input format is always valid, for example it could never contain two consecutive commas such as "1,,3".
 */
public class VerifyPreorderSerializationOfABinaryTree {
    // Time: O(n) Space: O(1)
    public boolean isValidSerialization(String preorder) {
        String[] nodes = preorder.split(",");
        int degree = 1;
        for (String val : nodes) {
            if (--degree < 0) return false;
            if (!val.equals("#")) degree += 2;
        }
        return degree == 0;
    }

    public static void main(String[] args){
        VerifyPreorderSerializationOfABinaryTree instance = new VerifyPreorderSerializationOfABinaryTree();
        System.out.println(instance.isValidSerialization("9,3,4,#,#,1,#,#,2,#,6,#,#"));
        System.out.println(instance.isValidSerialization("1,#"));
        System.out.println(instance.isValidSerialization("9,#,#,1"));
    }
}
