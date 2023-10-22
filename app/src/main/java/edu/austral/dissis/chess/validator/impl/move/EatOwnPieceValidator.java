package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MoveValidator;

public class EatOwnPieceValidator implements MoveValidator {
    @Override
    public boolean isValid(Movement movement, Board board) {
        Piece pieceToMove = movement.getFrom().getPiece();
        return pieceToMove.getColour().equals(movement.getTo().getPiece().getColour());
    }
}
