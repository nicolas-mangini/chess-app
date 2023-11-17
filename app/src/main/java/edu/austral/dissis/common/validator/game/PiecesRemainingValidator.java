package edu.austral.dissis.common.validator.game;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;
import lombok.AllArgsConstructor;

/**
 * Validator to check if the game is over based on the number of remaining pieces of the opponent.
 */
@AllArgsConstructor
public class PiecesRemainingValidator implements GameOverValidator {
    private final int maxRemainingPieces;

    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager) {
        Colour enemyColour = gameManager.getTurnChanger().getCurrentTurn();

        int remainingPieces = (int) board.getTiles()
                .stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getColour().equals(enemyColour))
                .count();

        if (remainingPieces <= maxRemainingPieces)
            return new WinResult<>(true, enemyColour);
        else
            return new WinResult<>(false, null);
    }
}
