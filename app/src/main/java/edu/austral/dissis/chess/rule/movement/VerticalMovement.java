package edu.austral.dissis.chess.rule.movement;

import edu.austral.dissis.chess.*;

public class VerticalMovement implements MovementRule {
    private final int increment;

    public VerticalMovement(int increment) {
        this.increment = increment;
    }

    public VerticalMovement() {
        this.increment = 0;
    }

    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        if (pieceToMove.isCanJump()) {
            return movement.getTo().getY() == movement.getFrom().getY() + increment;
        }
        if (checkPathBlocked(movement, board, player)) return false;
        return true;
    }

    @Override
    public boolean checkPathBlocked(Movement movement, Board board, Player player) {
/*        Piece pieceToMove = movement.getFrom().getPiece();
        Tile pieceTile = board.getPieceTile(pieceToMove).getValue();

        boolean isBackward = pieceToMove.isCanBackwards();
        if (isBackward) {

        } else {

        }*/
        return false;
    }
}