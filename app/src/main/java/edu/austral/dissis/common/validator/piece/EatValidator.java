package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.chess.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class EatValidator implements MovementValidator {
    private final boolean canEat;

    /**
     * This validator will determine whether a piece can eat another pieces. By default, if the piece doesn't contain this validator
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
