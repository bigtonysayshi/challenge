package self;

import java.util.HashSet;

/**
 * Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.
 * The Sudoku board could be partially filled, where empty cells are filled with the character '.'.
 * Note:
 * A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.
 */
public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        int size = 9;
        if (board == null || board.length != size || board[0].length != size) return false;
        for (int i = 0; i < size; i++) {
            // validate row i
            if (!validate(board[i])) return false;
            // validate col i
            char[] col = new char[size];
            for (int j = 0; j < size; j++) {
                col[j] = board[j][i];
            }
            if (!validate(col)) return false;
        }
        // validate quadrants
        for (int i = 0; i < size; i+=3) {
            for (int j = 0; j < size; j+=3) {
                char[] quad = new char[]{
                        board[i][j],board[i][j+1],board[i][j+2],
                        board[i+1][j],board[i+1][j+1],board[i+1][j+2],
                        board[i+2][j],board[i+2][j+1],board[i+2][j+2]
                };
                if (!validate(quad)) return false;
            }
        }
        return true;
    }

    private boolean validate(char[] nums) {
        boolean[] digits = new boolean[10];
        for (char c : nums) {
            if (Character.isDigit(c)) {
                int idx = c - '0';
                if (digits[idx]) return false;
                digits[idx] = true;
            }
        }
        return true;
    }
}
