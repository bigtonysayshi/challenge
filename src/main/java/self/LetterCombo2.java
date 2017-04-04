package self;

import java.util.*;

/**
 * Created by tzhang2 on 3/19/17.
 */
public class LetterCombo2 {
    private static String[] KEY_MAP = new String[] {
            "",
            "",
            "abc",
            "def",
            "ghi",
            "jkl",
            "mno",
            "pqrs",
            "tuv",
            "wxyz"
    };

    private static Set<String> DICT = new HashSet<String>() {{
        add("drop");
        add("box");
        add("cox");
        add("dropbox");
    }};

    // Time: O(n) Space: O(n)
    public List<String> letterCombinations(String digits) {
        Set<String> results = new HashSet<>();
        int[] keys = buildKeys(digits);

//        addLetters(results, "", new StringBuilder(), keys, 0);
        LCTrieNode root = buildTrie(DICT);
        findSentences(results, "", keys, 0, root, root);
        return new ArrayList<>(results);
    }

    private int[] buildKeys(String digits) {
        int[] keys = new int[digits.length()];
        for (int i = 0; i < digits.length(); i++) {
            if (Character.isDigit(digits.charAt(i))) {
                keys[i] =  Character.getNumericValue(digits.charAt(i));
            }
        }
        return keys;
    }

    private void addLetters(Set<String> results, String combo, StringBuilder word, int[] keys, int idx) {
        if (idx == keys.length) {
            if (word.length() == 0) {
                results.add(combo);
            }
            return;
        }
        int key = keys[idx];
        for (char c : KEY_MAP[key].toCharArray()) {
            word.append(c);
            if (isWord(word.toString())) {
                addLetters(results, combo + word.toString(), new StringBuilder(), keys, idx + 1);
            }
            addLetters(results, combo, word, keys, idx + 1);
            word.deleteCharAt(word.length() - 1);
        }
    }

    private void findSentences(Set<String> results, String sentence, int[] keys, int idx, LCTrieNode trieRoot, LCTrieNode trieNode) {
        if (idx == keys.length) {
            if (trieNode == trieRoot) {
                results.add(sentence);
            }
            return;
        }

        int key = keys[idx];
        for (char c : KEY_MAP[key].toCharArray()) {
            LCTrieNode nextNode = trieNode.children[c - 'a'];
            if (nextNode == null) {
                continue;
            }
            if (nextNode.word != null) {
                findSentences(results, sentence + nextNode.word, keys, idx + 1, trieRoot, trieRoot);
            }
            findSentences(results, sentence, keys, idx + 1, trieRoot, nextNode);
        }
    }

    private LCTrieNode buildTrie(Set<String> words) {
        LCTrieNode root = new LCTrieNode();
        for (String word : words) {
            LCTrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                char c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new LCTrieNode();
                }
                current = current.children[c - 'a'];
                if (i == word.length() - 1) {
                    current.word = word;
                }
            }
        }
        return root;
    }

    private boolean isWord(String word) {
        return DICT.contains(word);
    }

    private boolean isPrefix(String word) {
        return true;
    }

    public static void main(String[] args){
        LetterCombo2 instance = new LetterCombo2();
        System.out.println(instance.letterCombinations("3767269"));
        System.out.println(instance.letterCombinations("3767"));
        System.out.println(instance.letterCombinations("269"));
    }
}

class LCTrieNode {
    String word;
    LCTrieNode[] children;

    public LCTrieNode() {
        word = null;
        children = new LCTrieNode[26];
    }
}
