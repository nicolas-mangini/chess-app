package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EatValidator implements MovementValidator {
    private final boolean canEat;

    /**
     * This validator determines whether a piece can eat other pieces. By default, if the piece doesn't contain this validator
     * it will behave as if it can eat (canEat set to true)
     */
    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Optional<Piece> optionalToPiece = Optional.ofNullable(movement.getTo().getPiece());
        if (!canEat) {
            return optionalToPiece.isEmpty();
        }
        return true;
    }
}
