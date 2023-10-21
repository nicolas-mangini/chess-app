/*
package edu.austral.dissis.chess.validator.impl.outdated;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MoveValidator;

public class CompundMove implements MoveValidator {
    private final int incrementX;
    private final int incrementY;

    public CompundMove(int incrementX, int incrementY) {
        this.incrementX = incrementX;
        this.incrementY = incrementY;
    }

    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        int offsetX = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
        int offsetY = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
        return offsetX == incrementX && offsetY == incrementY;
    }

    @Override
    public boolean checkPathBlocked(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        Tile pieceTile = board.getTileByPiece(pieceToMove).getValue();
        if (pieceToMove.isCanJump()) {
            if (movement.getTo().getPiece() == null) {
                return true;
            }
        }
        return  false;
    }
}
*/
