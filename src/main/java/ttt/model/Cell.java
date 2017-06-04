package ttt.model;

/**
 * Created by tzhang2 on 4/22/17.
 */
public class Cell {
    private int row;
    private int col;
    private Symbol symbol;

    public Cell(int r, int c) {
        row = r;
        col = c;
        symbol = Symbol.EMPTY;
    }

    public void clear() {
        symbol = Symbol.EMPTY;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public void setSymbol(Symbol s) {
        symbol = s;
    }

}
