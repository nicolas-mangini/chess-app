package edu.austral.dissis.chess.rule.movement;

import edu.austral.dissis.chess.*;

public class CompundMovement implements MovementRule {
    private final int incrementX;
    private final int incrementY;

    public CompundMovement(int incrementX, int incrementY) {
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
        Tile pieceTile = board.getPieceTile(pieceToMove).getValue();
        if (pieceToMove.isCanJump()) {
            if (movement.getTo().getPiece() == null) {
                return true;
            }
        }
        return  false;
    }
}
