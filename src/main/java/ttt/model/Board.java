package ttt.model;

/**
 * Created by tzhang2 on 4/22/17.
 */
public class Board {
    private int rows;
    private int cols;
    private Cell[][] cells;

    public Board(int r, int c) {
        rows = r;
        cols = c;
        init();
    }

    private void init() {
        if (rows <= 0 || cols <= 0) {
            return;
        }
        cells = new Cell[rows][cols];
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j] = new Cell(i, j);
            }
        }
    }

    public void reset() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                cells[i][j].clear();
            }
        }
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }

    public Symbol getSymbol(int r, int c) {
        return cells[r][c].getSymbol();
    }

    public boolean validMove(int move) {
        if (move <= 0 || move > rows * cols) {
            return false;
        }
        int r = (move - 1) / cols;
        int c = (move - 1) % cols;
        return getSymbol(r, c) == Symbol.EMPTY;
    }

    public void setMove(int move, Symbol s) {
        if (validMove(move)) {
            int r = (move - 1) / cols;
            int c = (move - 1) % cols;
            Cell cell = cells[r][c];
            cell.setSymbol(s);
        }
    }

    public boolean isWinningConfig(Symbol symbol) {
        boolean winning = true;
        // check rows
        for (int i = 0; i < rows; i++) {
            winning = true;
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].getSymbol() != symbol) {
                    winning = false;
                    break;
                }
            }
            if (winning) {
                return true;
            }
        }

        // check columns
        for (int j = 0; j < cols; j++) {
            winning = true;
            for (int i = 0; i < rows; i++) {
                if (cells[i][j].getSymbol() != symbol) {
                    winning = false;
                    break;
                }
            }
            if (winning) {
                return true;
            }
        }

        // check diagonals
        winning = true;
        for (int i = 0; i < Math.min(rows, cols); i++) {
            if (cells[i][i].getSymbol() != symbol) {
                winning = false;
                break;
            }
        }
        if (winning) {
            return true;
        }

        // check reverse diagonals
        winning = true;
        for (int i = 0; i < Math.min(rows, cols); i++) {
            if (cells[rows - i - 1][i].getSymbol() != symbol) {
                winning = false;
                break;
            }
        }
        if (winning) {
            return true;
        }

        return false;
    }


    public boolean isFull() {
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (cells[i][j].getSymbol() == Symbol.EMPTY) {
                    return false;
                }
            }
        }
        return true;
    }

    public String getBoardDescription() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                sb.append(cells[i][j].getSymbol());
                sb.append(j == cols - 1 ? "\n" : " | ");
            }
        }
        return sb.toString();
    }

    public String getThreeByThreeMovePos(int move) {
        String str = "";
        if (move == 5) {
            str = "center";
            return str ;
        }

        if ((move - 1) / 3 == 0 ) {
            str += "upper ";
        } else if((move - 1) / 3 == 1 ) {
            str += "middle ";
        } else {
            str += "lower ";
        }

        if ((move - 1) % 3 == 0 ) {
            str += "left";
        } else if((move - 1) % 3 == 1 ) {
            str += "middle";
        } else {
            str += "right";
        }
        return str;
    }

}
