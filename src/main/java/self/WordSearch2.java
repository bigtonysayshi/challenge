package self;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * Given a 2D board and a list of words from the dictionary, find all words in the board.
 * Each word must be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once in a word.
 * Note: You may assume that all inputs are consist of lowercase letters a-z.
 */
public class WordSearch2 {
    private static final int[] dx = new int[]{0, 0, -1, 1};
    private static final int[] dy = new int[]{-1, 1, 0, 0};

    public List<String> findWords(char[][] board, String[] words) {
        List<String> results = new ArrayList<>();
        if (board == null) {
            return results;
        }
        int m = board.length;
        if (m == 0) {
            return results;
        }
        int n = board[0].length;

        TrieNode trieRoot = buildTrie(words);
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                dfs(board, i, j, new StringBuilder(), visited, trieRoot, results);
            }
        }
        return results;
    }

    private void dfs(char[][] board, int row, int col, StringBuilder sb,
                     boolean[][] visited,
                     TrieNode trieNode,
                     List<String> results) {
        if (trieNode.isWord) {
            results.add(sb.toString());
            trieNode.isWord = false;
        }
        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n || visited[row][col]) {
            return;
        }

        char c = board[row][col];
        TrieNode nextNode = trieNode.children[c - 'a'];
        if (nextNode == null) {
            return;
        }
        visited[row][col] = true;
        sb.append(c);
        for (int i = 0; i < dx.length; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            dfs(board, nextRow, nextCol, sb, visited, nextNode, results);
        }

        sb.deleteCharAt(sb.length() - 1);
        visited[row][col] = false;
        return;
    }

    private TrieNode buildTrie(String[] words) {
        TrieNode root = new TrieNode();

        for (String word : words) {
            TrieNode current = root;
            for (int i = 0; i < word.length(); i++) {
                Character c = word.charAt(i);
                if (current.children[c - 'a'] == null) {
                    current.children[c - 'a'] = new TrieNode();
                }
                current = current.children[c - 'a'];
                if (i == word.length() - 1) {
                    current.isWord = true;
                }
            }
        }
        return root;
    }

    public static void main(String[] args){
        WordSearch2 instance = new WordSearch2();
        char[][] board = new char[][] {
                {'o','a','a','n'},
                {'e','t','a','e'},
                {'i','h','k','r'},
                {'i','f','l','v'}
        };
        String[] words = new String[]{"oath","pea","eat","rain"};
        System.out.println(instance.findWords(board, words));
    }
}
