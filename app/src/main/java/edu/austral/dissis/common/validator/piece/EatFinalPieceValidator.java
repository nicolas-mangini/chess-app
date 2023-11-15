package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class EatFinalPieceValidator implements MovementValidator {
    private final boolean canEat;

    /**
     * This validator will determine whether a piece can eat another pieces. By default, if the piece doesn't contain this validator
     * it will behave as if it can eat (canEat set to true)
     */
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Optional<Piece> optionalToPiece = Optional.ofNullable(movement.getTo().getPiece());
        if (!canEat) {
            return optionalToPiece.isEmpty();
        }
        return true;
    }
}
