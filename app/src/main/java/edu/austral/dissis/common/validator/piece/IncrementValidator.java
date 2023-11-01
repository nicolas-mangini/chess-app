package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class IncrementValidator implements MovementValidator {
    private final int limit;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        int offsetX = movement.getTo().getX() - movement.getFrom().getX();
        int offsetY = movement.getTo().getY() - movement.getFrom().getY();
        return Math.abs(offsetX) <= limit && Math.abs(offsetY) <= limit;
    }
}
