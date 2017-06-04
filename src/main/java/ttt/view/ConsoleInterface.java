package ttt.view;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

/**
 * Created by tzhang2 on 4/24/17.
 */
public class ConsoleInterface implements UserInterface {
    private static final BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

    public void showGameStartMessage() {
        System.out.println("Welcome to Tic-Tac-Toe.\n");
    }

    public void showGameDrawMessage() {
        System.out.println("Well played. It is a draw!\n");
    }

    public void showPlayerWonMessage(String playerName) {
        System.out.println("Player " + playerName + " won the game!\n");
    }

    public void promptUserMove() {
        System.out.println("Please make your move selection by entering a number 1-9 corresponding to the movement key on the right.\n");
    }

    public void showBoardState(String state) {
        System.out.println(state);
    }

    public void showInvalidMoveMessage() {
        System.out.println("Invalid Move!\n");
    }

    public void showMoveMessage(String playerName, String symbol, String pos) {
        System.out.println(playerName + "has put a " + symbol + " at " + pos + "\n");
    }


    public String getPlayerNameInput() {
        System.out.println("Enter Player Name:");
        String playerName = getUserInput();
        return playerName;
    }

    public int getUserMoveInput() {
        String moveInput = getUserInput();
        while (!moveInput.matches("\\d+")) {
            System.out.println("Please enter an integer\n");
            moveInput = getUserInput();
        }
        return Integer.parseInt(moveInput);
    }

    private static String getUserInput() {
        String input = "" ;
        try {
            input = reader.readLine();
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return input;
    }

}
