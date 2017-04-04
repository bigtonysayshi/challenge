package self;

/**
 * Design a data structure that supports the following two operations:
 * void addWord(word)
 * bool search(word)
 * search(word) can search a literal word or a regular expression string containing only letters a-z or .
 * A . means it can represent any one letter.
 * Note: You may assume that all words are consist of lowercase letters a-z.
 */
public class AddAndSearchWord {
    private TrieNode root;

    /** Initialize your data structure here. */
    public AddAndSearchWord() {
        root = new TrieNode();
    }

    /** Adds a word into the data structure. */
    public void addWord(String word) {
        TrieNode current = root;
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (current.children[c - 'a'] == null) {
                current.children[c - 'a'] = new TrieNode();
            }
            current = current.children[c - 'a'];
        }
        current.isWord = true;
    }

    /** Returns if the word is in the data structure. A word could contain the dot character '.' to represent any one letter. */
    public boolean search(String word) {
        return findWord(word, 0, root);
    }

    private boolean findWord(String word, int idx, TrieNode node) {
        if (node == null) {
            return false;
        }
        if (idx == word.length()) {
            return node.isWord;
        }
        char c = word.charAt(idx);
        if (c == '.') {
            for (TrieNode child : node.children) {
                if (findWord(word, idx + 1, child)) {
                    return true;
                }
            }
            return false;
        }

        return findWord(word, idx + 1, node.children[c - 'a']);
    }

}
