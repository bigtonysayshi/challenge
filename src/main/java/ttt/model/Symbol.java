package ttt.model;

/**
 * Created by tzhang2 on 4/22/17.
 */
public enum Symbol {
    EMPTY,
    CROSS,
    CIRCLE;

    @Override
    public String toString() {
        switch (this) {
            case EMPTY:
                return " ";
            case CROSS:
                return "X";
            case CIRCLE:
                return "O";
            default:
                return "";
        }
    }
}
