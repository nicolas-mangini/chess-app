/*
package edu.austral.dissis.chess.validator.impl.outdated;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MoveValidator;

public class HorizontalMove implements MoveValidator {
    private final int increment;

    public HorizontalMove(int increment) {
        this.increment = increment;
    }

    public HorizontalMove() {
        this.increment = 0;
    }

    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        if (pieceToMove.isCanJump()) {
            return movement.getTo().getY() == movement.getFrom().getY() &&
                    movement.getTo().getX() == movement.getFrom().getX() + increment;
        } else {
            return checkPathBlocked(movement, board, player);
        }
    }

    @Override
    public boolean checkPathBlocked(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        Tile pieceTile = board.getTileByPiece(pieceToMove).getValue();
        //two possibilities: horizontal left or right
        if (movement.getTo().getY() > movement.getFrom().getY()) {
            for (int i = 1; i < movement.getTo().getY() - movement.getFrom().getY(); i++) {
                int xToCheck = pieceTile.getX();
                int yToCheck = pieceTile.getY() + i;

                Tile currentTile = board.getTile(xToCheck, yToCheck).getValue();
                if (currentTile.getPiece() != null) return false;
            }
        } else {
            for (int i = 1; i < movement.getFrom().getY() - movement.getTo().getY(); i++) {
                Tile current = board.getTile(pieceTile.getX(), pieceTile.getY() - i).getValue();
                if (current.getPiece() != null) return false;
            }
        }
        return true;
    }
}
*/
