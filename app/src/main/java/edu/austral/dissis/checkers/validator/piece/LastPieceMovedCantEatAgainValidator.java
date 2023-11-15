package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

public class LastPieceMovedCantEatAgainValidator implements MovementValidator {
    /**
     * Validator to ensure that a piece can move if the last piece moved
     * cannot eat again
     */
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        return false;
    }
}
