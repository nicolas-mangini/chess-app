package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MovementValidator;

import java.util.List;
import java.util.Optional;

public class MustEatValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Optional<Piece> optionalToPiece = Optional.ofNullable(movement.getTo().getPiece());
        return optionalToPiece.isPresent();
    }
}
