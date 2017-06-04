package self;

import java.util.*;

/**
 * Given two words (beginWord and endWord), and a dictionary's word list,
 * find all shortest transformation sequence(s) from beginWord to endWord, such that:
 * Only one letter can be changed at a time
 * Each transformed word must exist in the word list. Note that beginWord is not a transformed word.
 * Note:
 * Return an empty list if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 */
public class WordLadder2 {
    public List<List<String>> findLadders(String beginWord, String endWord, List<String> wordList) {
        Map<String, List<Integer>> neighborMap = buildNeighborMap(wordList, beginWord);
        List<List<String>> ans = new ArrayList<>();
        List<String> ladder = new ArrayList<>();
        ladder.add(beginWord);
        boolean[] visited = new boolean[wordList.size()];
        dfs(ans, ladder, wordList, visited, endWord, neighborMap);
        return ans;
    }

    private void dfs(List<List<String>> ans,
                     List<String> ladder,
                     List<String> words,
                     boolean[] visited,
                     String endWord,
                     Map<String, List<Integer>> neighborMap) {
        if (ans.size() > 0 && ladder.size() > ans.get(0).size()) {
            return;
        }
        String word = ladder.get(ladder.size() - 1);
        if (word.equals(endWord)) {
            if (ans.size() > 0 && ladder.size() < ans.get(0).size()) {
                ans.clear();
            }
            ans.add(new ArrayList<>(ladder));
            return;
        }

        List<Integer> neighbors = neighborMap.get(word);
        for (int idx : neighbors) {
            if (!visited[idx]) {
                visited[idx] = true;
                ladder.add(words.get(idx));
                dfs(ans, ladder, words, visited, endWord, neighborMap);
                ladder.remove(ladder.size() - 1);
                visited[idx] = false;
            }
        }
    }

    private Map<String, List<Integer>> buildNeighborMap(List<String> wordList, String beginWord) {
        Map<String, List<Integer>> neighborMap = new HashMap<>();
        List<String> keys = new ArrayList<>(wordList);
        keys.add(beginWord);
        for (String word : keys) {
            List<Integer> neighbors = new LinkedList<>();
            for (int i = 0; i < wordList.size(); i++) {
                if (valid(word, wordList.get(i))) {
                    neighbors.add(i);
                }
            }
            neighborMap.put(word, neighbors);
        }
        return neighborMap;
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

    public static void main(String[] args){
        WordLadder2 instance = new WordLadder2();
        List<String> wordList = Arrays.asList(new String[]{"hot","dot","dog","lot","log","cog"});
        System.out.println(instance.findLadders("hit", "cog", wordList));
    }
}
