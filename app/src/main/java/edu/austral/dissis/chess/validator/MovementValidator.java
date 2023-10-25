package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;

import java.util.List;

public interface MovementValidator {
    boolean isValid(Movement movement, Board board, List<Movement> movementHistory);
}
