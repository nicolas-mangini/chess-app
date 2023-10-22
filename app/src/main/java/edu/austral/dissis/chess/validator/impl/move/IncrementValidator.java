package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MoveValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class IncrementValidator implements MoveValidator {
    private final int increments;

    @Override
    public boolean isValid(Movement movement, Board board) {
        int offsetX = movement.getTo().getX() - movement.getFrom().getX();
        int offsetY = movement.getTo().getY() - movement.getFrom().getY();
        return Math.abs(offsetX) <= increments && Math.abs(offsetY) <= increments;
    }
}
