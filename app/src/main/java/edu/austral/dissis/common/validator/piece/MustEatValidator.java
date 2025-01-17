package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.Optional;

public class MustEatValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Optional<Piece> optionalToPiece = Optional.ofNullable(movement.getTo().getPiece());
        return optionalToPiece.isPresent();
    }
}
