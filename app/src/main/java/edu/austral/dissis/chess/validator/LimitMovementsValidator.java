package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class LimitMovementsValidator implements MovementValidator {
    /**
     * The maximum number of movements allowed.
     */
    private final int limit;

    /**
     * Validates whether a piece is allowed to make a movement based on its movement history.
     * This validator returns true if the piece has made fewer movements than the specified limit.
     * For example, if the limit is set to 1, the validator allows the piece to move just once. Useful for cases
     * like a pawn's initial double movement.
     */
    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Piece pieceToMove = movement.getFrom().getPiece();
        long movements = movementHistory.stream()
                .filter(movement1 -> movement1.getFrom().getPiece().getId().equals(pieceToMove.getId()))
                .count();
        return movements < limit;
    }
}
