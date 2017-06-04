package ttt.controller;

import ttt.model.*;
import ttt.view.UserInterface;

/**
 * Created by tzhang2 on 4/23/17.
 */
public class Automaton {
    private Game game;
    private UserInterface userInterface;

    public Automaton(Game game, UserInterface ui) {
        this.game = game;
        this.userInterface = ui;
    }

    public void step() {
        GameState state = game.getState();
        switch (state) {
            case IDLE:
                userInterface.showGameStartMessage();
                break;
            case INIT:
                if (game.needHumanPlayer()) {
                    String playerName = userInterface.getPlayerNameInput();
                    game.addHumanPlayer(playerName);
                } else if (game.needComputerPlayer()) {
                    game.addComputerPlayer();
                } else {
                    game.setCurrentPlayer(1);
                    userInterface.promptUserMove();
                    userInterface.showBoardState(game.getBoard().getBoardDescription());
                    game.setState(GameState.WAIT_MOVE);
                }
                break;
            case DRAW:
                userInterface.showGameDrawMessage();
                game.setState(GameState.END);
                break;
            case PLAYER_WON:
                String playerName = game.getCurrentPlayer().getName();
                userInterface.showPlayerWonMessage(playerName);
                game.setState(GameState.END);
                break;
            case WAIT_MOVE:
                Board board = game.getBoard();
                Player currentPlayer = game.getCurrentPlayer();
                int move;
                if (currentPlayer.isComputer()) {
                    move = currentPlayer.getNextMove();
                } else {
                    move = userInterface.getUserMoveInput();
                }
                if (board.validMove(move)) {
                    // make move
                    Symbol symbol = game.getCurrentPlayer().getSymbol();
                    board.setMove(move, symbol);
                    userInterface.showMoveMessage(currentPlayer.getName(), symbol.toString(), board.getThreeByThreeMovePos(move));
                    userInterface.showBoardState(board.getBoardDescription());
                    // check if game ends and switch to next state
                    if (board.isWinningConfig(currentPlayer.getSymbol())) {
                        game.setState(GameState.PLAYER_WON);
                    } else if (board.isFull()) {
                        game.setState(GameState.DRAW);
                    } else {
                        game.switchPlayer();
                    }
                } else {
                    game.setState(GameState.INVALID_MOVE);
                }
                break;
            case INVALID_MOVE:
                userInterface.showInvalidMoveMessage();
                game.setState(GameState.WAIT_MOVE);
                break;
            default:
                break;
        }
    }

    public boolean gameOver() {
        GameState state = game.getState();
        return state == GameState.END;
    }

}
