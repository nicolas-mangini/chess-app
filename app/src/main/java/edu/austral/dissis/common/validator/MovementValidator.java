package edu.austral.dissis.common.validator;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;

public interface MovementValidator {
    /**
     * Validates whether a rule is valid or not.
     *
     * @param movement The movement to be validated.
     * @param board The game board.
     * @param gameManager the game and turn manager.
     * @return true if the movement is valid, false otherwise.
     */
    boolean isValid(Movement movement, Board board, GameManager gameManager);
}
