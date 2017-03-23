package self;

/**
 * Given a 2D board and a word, find if the word exists in the grid.
 * The word can be constructed from letters of sequentially adjacent cell,
 * where "adjacent" cells are those horizontally or vertically neighboring.
 * The same letter cell may not be used more than once.
 */
public class WordSearch {
    private static final int[] dx = new int[]{0, 0, -1, 1};
    private static final int[] dy = new int[]{-1, 1, 0, 0};

    public boolean exist(char[][] board, String word) {
        if (board == null) {
            return false;
        }
        int m = board.length;
        if (m == 0) {
            return false;
        }
        int n = board[0].length;
        boolean[][] visited = new boolean[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (dfs(board, word, i, j, 0, visited)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean dfs(char[][] board, String word, int row, int col,
                        int idx, boolean[][] visited) {
        if (idx >= word.length()) {
            return true;
        }

        int m = board.length;
        int n = board[0].length;
        if (row < 0 || row >= m || col < 0 || col >= n
                || visited[row][col]
                || board[row][col] != word.charAt(idx)) {
            return false;
        }

        visited[row][col] = true;
        for (int i = 0; i < dx.length; i++) {
            int nextRow = row + dx[i];
            int nextCol = col + dy[i];
            if (dfs(board, word, nextRow, nextCol, idx + 1, visited)) {
                return true;
            }
        }
        visited[row][col] = false;
        return false;
    }

    public static void main(String[] args){
        WordSearch instance = new WordSearch();
        char[][] board = new char[][] {
                {'A','B','C','E'},
                {'S','F','C','S'},
                {'A','D','E','E'}
        };
        System.out.println(instance.exist(board, "ABCCED"));
        System.out.println(instance.exist(board, "SEE"));
        System.out.println(instance.exist(board, "ABCB"));

    }
}
