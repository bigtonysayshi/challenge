package self;

/**
 * Implement a trie with insert, search, and startsWith methods.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
public class ImplementTrie {
    static final char START = 'a';

    private TrieNode root;

    /** Initialize your data structure here. */
    public ImplementTrie() {
        root = new TrieNode();
    }

    /** Inserts a word into the trie. */
    public void insert(String word) {
        if (search(word)) {
            return;
        }
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (current.children[c - START] == null) {
                current.children[c - START] = new TrieNode();
            }
            current = current.children[c - START];
            if (i == word.length() - 1) {
                current.isWord = true;
            }
        }
    }

    /** Returns if the word is in the trie. */
    public boolean search(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            Character c = word.charAt(i);
            if (current.children[c - START] == null) {
                return false;
            }
            current = current.children[c - START];
        }
        return current.isWord;
    }

    /** Returns if there is any word in the trie that starts with the given prefix. */
    public boolean startsWith(String prefix) {
        TrieNode current = root;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            if (current.children[c - START] == null) {
                return false;
            }
            current = current.children[c - START];
        }
        return true;
    }
}

class TrieNode {
    static final int NUM_CHARS = 26;

    boolean isWord;
    TrieNode[] children;

    public TrieNode() {
        isWord = false;
        children = new TrieNode[NUM_CHARS];
    }
}