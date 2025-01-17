package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class EatOwnPieceValidator implements MovementValidator {
    private final boolean canEat;

    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Piece fromPiece = movement.getFrom().getPiece();
        Optional<Piece> optionalToPiece = Optional.ofNullable(movement.getTo().getPiece());
        if (!canEat) {
            return optionalToPiece.isEmpty() || optionalToPiece.get().getColour() != fromPiece.getColour();
        }
        return true;
    }
}
