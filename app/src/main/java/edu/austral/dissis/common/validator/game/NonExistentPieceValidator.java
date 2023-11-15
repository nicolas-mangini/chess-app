package edu.austral.dissis.common.validator.game;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.Optional;

public class NonExistentPieceValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Optional<Piece> pieceToMove = Optional.ofNullable(movement.getFrom().getPiece());
        return pieceToMove.isPresent();
    }
}
