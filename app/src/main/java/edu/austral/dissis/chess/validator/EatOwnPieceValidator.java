package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EatOwnPieceValidator implements MovementValidator {
    private final boolean canEat;
    //TODO EatValidator + OwnPieceValidator?
    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Piece fromPiece = movement.getFrom().getPiece();
        Optional<Piece> optionalToPiece = Optional.ofNullable(movement.getTo().getPiece());
        if (!canEat) {
            return optionalToPiece.isEmpty() || optionalToPiece.get().getColour() != fromPiece.getColour();
        }
        return true;
    }
}
