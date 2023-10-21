/*
package edu.austral.dissis.chess.validator.impl.outdated;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MoveValidator;

public class DiagonalMove implements MoveValidator {
    private final int incrementX;
    private final int incrementY;

    public DiagonalMove(int incrementX, int incrementY) {
        this.incrementX = incrementX;
        this.incrementY = incrementY;
    }

    public DiagonalMove() {
        this.incrementX = 0;
        this.incrementY = 0;
    }

    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        int offsetX = movement.getTo().getX() - movement.getFrom().getX();
        int offsetY = movement.getTo().getY() - movement.getFrom().getY();

        if (Math.abs(offsetY) != Math.abs(offsetX)) return false;
        if (pieceToMove.isCanJump()) {
            return movement.getTo().getY() == movement.getFrom().getY() + incrementY &&
                    movement.getTo().getX() == movement.getFrom().getX() + incrementX;
        } else {
            return checkPathBlocked(movement, board, player);
        }
    }

    //maybe check path blocked should be another validator
    @Override
    public boolean checkPathBlocked(Movement movement, Board board, Player player) {
        int offsetX = movement.getTo().getX() - movement.getFrom().getX();
        int offsetY = movement.getTo().getY() - movement.getFrom().getY();

        int rowIncrement = (offsetX > 0) ? 1 : -1;
        int columnIncrement = (offsetY > 0) ? 1 : -1;

        // Check each square along the diagonal path
        for (int i = 1; i < Math.abs(offsetX); i++) {
            int xToCheck = movement.getFrom().getX() + i * rowIncrement;
            int yToCheck = movement.getFrom().getY() + i * columnIncrement;

            Tile currentTile = board.getTile(xToCheck, yToCheck).getValue();
            if (currentTile.getPiece() != null) return false;
        }
        return true;
    }
}
*/