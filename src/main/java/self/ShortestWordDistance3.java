package self;

/**
 * Created by tzhang2 on 1/18/17.
 */
public class ShortestWordDistance3 {
    // Time: O(n) Space:O(1)
    public int shortestWordDistance(String[] words, String word1, String word2) {
        int index1 = -1, index2 = -1, distance = words.length;
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            if (word.equals(word1)) {
                if (word.equals(word2) && index2 < index1) {
                    index2 = i;
                } else {
                    index1 = i;
                }
            } else if (word.equals(word2)) {
                index2 = i;
            }
            if (index1 >= 0 && index2 >= 0 && index1 != index2 && Math.abs(index1 - index2) < distance) {
                distance = Math.abs(index1 - index2);
            }
        }
        return distance;
    }

    public static void main(String[] args){
        ShortestWordDistance3 instance = new ShortestWordDistance3();
        String[] words = new String[]{"practice", "makes", "perfect", "coding", "makes"};
        System.out.println(instance.shortestWordDistance(words, "makes", "coding"));
        System.out.println(instance.shortestWordDistance(words, "makes", "makes"));
    }
}
