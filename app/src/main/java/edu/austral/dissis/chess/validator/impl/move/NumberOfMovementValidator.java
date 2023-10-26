package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class NumberOfMovementValidator implements MovementValidator {
    private final int numberOfMovements;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Piece pieceToMove = movement.getFrom().getPiece();
        long movements =  movementHistory.stream()
                .filter(movement1 -> movement1.getFrom().getPiece().getId().equals(pieceToMove.getId()))
                .count();
        return movements < numberOfMovements;
    }
}
