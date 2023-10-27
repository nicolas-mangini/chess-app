package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;

import java.util.List;

public class CheckValidator implements MovementValidator{
    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        List<Piece> attackPieces = board.getPiecesByColour(movement.getFrom().getPiece().getColour());

        return false;
    }
}
