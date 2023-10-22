package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MoveValidator;

public class EatValidator implements MoveValidator {
    @Override
    public boolean isValid(Movement movement, Board board) {
        if (movement.getTo().getPiece() != null) {
            return !movement.getTo().getPiece().getColour().equals(movement.getFrom().getPiece().getColour());
        }
        return true;
    }
}
