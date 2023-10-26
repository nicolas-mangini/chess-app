package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;

import java.util.List;

public interface MovementValidator {
    /**
     * Validates whether a rule is valid or not.
     *
     * @param movement The movement to be validated.
     * @param board The game board.
     * @param movementHistory The list of previous movements.
     * @return true if the movement is valid, false otherwise.
     */
    boolean isValid(Movement movement, Board board, List<Movement> movementHistory);
}
