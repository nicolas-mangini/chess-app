package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;
import java.util.Objects;

public class EatenBeforeValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        List<Movement> history = gameManager.getGame().getHistory();
        // if last movement.getFrom().getPiece() has the same piece as the current history movement,
        if (Objects.equals(history.get(history.size() - 1).getFrom().getPiece().getId(), movement.getFrom().getPiece().getId())) {
            // eat -> 2 tiles movement
            return Math.abs(movement.getFrom().getX() - movement.getTo().getX()) == 2;
        }
        return false;
    }
}
