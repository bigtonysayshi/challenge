package self;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find the length of shortest transformation sequence from beginWord to endWord, such that:
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder {
    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        int steps = 1;
        Queue<String> queue = new LinkedList<>();
        boolean[] visited = new boolean[wordList.size()];
        addCandidates(queue, wordList, visited, beginWord);
        while (!queue.isEmpty()) {
            int num = queue.size();
            steps++;
            for (int i = 0; i < num; i++) {
                String word = queue.poll();
                if (word.equals(endWord)) {
                    return steps;
                }
                addCandidates(queue, wordList, visited, word);
            }
        }
        return 0;
    }

    private boolean valid(String s1, String s2) {
        boolean diff = false;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                if (diff) {
                    return false;
                } else {
                    diff = true;
                }
            }
        }
        return diff;
    }

    private void addCandidates(Queue<String> queue,
                               List<String> words,
                               boolean[] visited,
                               String target) {
        for (int i = 0; i < words.size(); i++) {
            if (!visited[i] && valid(target, words.get(i))) {
                queue.offer(words.get(i));
                visited[i] = true;
            }
        }
    }

    public static void main(String[] args){
        WordLadder instance = new WordLadder();
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(instance.ladderLength("hit", "hot", wordList));
        System.out.println(instance.ladderLength("hit", "cog", wordList));
    }
}
