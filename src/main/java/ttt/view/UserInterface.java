package ttt.view;

/**
 * Created by tzhang2 on 4/23/17.
 */
public interface UserInterface {
    void showGameStartMessage();

    void showGameDrawMessage();

    void showPlayerWonMessage(String playerName);

    void promptUserMove();

    void showBoardState(String state);

    void showInvalidMoveMessage();

    void showMoveMessage(String playerName, String symbol, String move);

    String getPlayerNameInput();

    int getUserMoveInput();
}
