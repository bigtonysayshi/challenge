package ttt.model;

/**
 * Created by tzhang2 on 4/23/17.
 */
public class Player {
    private final String name;
    private final boolean isComputer;
    private final Symbol symbol;
    private final MoveMethod moveStrategy;

    public Player(String name, boolean isComputer, Symbol symbol, MoveMethod moveStrategy) {
        this.name = name;
        this.isComputer = isComputer;
        this.symbol = symbol;
        this.moveStrategy = moveStrategy;
    }

    public String getName() {
        return name;
    }

    public boolean isComputer() {
        return isComputer;
    }

    public Symbol getSymbol() {
        return symbol;
    }

    public int getNextMove() {
        return moveStrategy.move();
    }
}
