package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;
import java.util.Objects;

/**
 * Validator to check if a piece has been eaten before in the current sequence of movements.
 * This validator ensures that a piece can only perform an "eat" movement if it has been involved
 * in the last movement sequence as the capturing piece.
 */
public class EatenBeforeValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        List<Movement> history = gameManager.getGame().getHistory();
        if (Objects.equals(history.get(history.size() - 1).getFrom().getPiece().getId(), movement.getFrom().getPiece().getId())) {
            return Math.abs(movement.getFrom().getX() - movement.getTo().getX()) == 2;
        }
        return false;
    }
}
