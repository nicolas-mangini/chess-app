package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class NumberOfMovementValidator implements MovementValidator {
    private final int numberOfMovements;
    @Override
    public boolean isValid(Movement movement, Board board) {
        return false;
    }
}
