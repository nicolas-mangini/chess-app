package edu.austral.dissis.common.game;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class Game {
    private final Colour player1;
    private final Colour player2;
    private final Board board;
    private final MovementValidator gameValidators;
    private final List<GameOverValidator> gameOverValidators;
    private final List<Movement> history;

    public Game(Game toCopy, List<Movement> newHistory) {
        this.player1 = toCopy.getPlayer1();
        this.player2 = toCopy.getPlayer2();
        this.board = toCopy.getBoard();
        this.gameValidators = toCopy.getGameValidators();
        this.gameOverValidators = toCopy.getGameOverValidators();
        this.history = newHistory;
    }

    public Game(Game toCopy, Board newBoard, List<Movement> newHistory) {
        this.player1 = toCopy.getPlayer1();
        this.player2 = toCopy.getPlayer2();
        this.board = newBoard;
        this.gameValidators = toCopy.getGameValidators();
        this.gameOverValidators = toCopy.getGameOverValidators();
        this.history = newHistory;
    }
}
