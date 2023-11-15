package edu.austral.dissis.common.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PieceValidator {
    //classic validators
    private final MovementValidator pieceValidators;

    //special (check and LastMoved...from checkers)
    private final MovementValidator specialAndValidators;

    // check if all validators are valid
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        return pieceValidators.isValid(movement, board, gameManager)
                && specialAndValidators.isValid(movement, board, gameManager);
    }

    // checks only if piece validators are valid without special validators
    public boolean isValidClassic(Movement movement, Board board, GameManager gameManager) {
        return pieceValidators.isValid(movement, board, gameManager);
    }
}
