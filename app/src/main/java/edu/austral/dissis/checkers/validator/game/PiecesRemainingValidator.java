package edu.austral.dissis.checkers.validator.game;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PiecesRemainingValidator implements GameOverValidator {
    private final int amount;

    //end game when enemy has less or equal pieces than amount
    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager) {
        Colour enemyColour = gameManager.getTurnChanger().getCurrentTurn();

        int piecesRemaining = (int) board.getTiles()
                .stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getColour().equals(enemyColour))
                .count();

        if (piecesRemaining <= amount) return new WinResult<>(true, enemyColour);
        else return new WinResult<>(false, null);
    }
}
