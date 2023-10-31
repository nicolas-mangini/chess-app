package edu.austral.dissis.common.validator;

import edu.austral.dissis.chess.board.ChessBoard;
import edu.austral.dissis.common.game.Movement;

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
    boolean isValid(Movement movement, ChessBoard board, List<Movement> movementHistory);
}
