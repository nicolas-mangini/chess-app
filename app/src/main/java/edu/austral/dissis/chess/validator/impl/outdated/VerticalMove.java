/*
package edu.austral.dissis.chess.validator.impl.outdated;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.validator.MoveValidator;

public class VerticalMove implements MoveValidator {
    private final int increment;

    public VerticalMove(int increment) {
        this.increment = increment;
    }

    public VerticalMove() {
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
*/
/*        Piece pieceToMove = movement.getFrom().getPiece();
        Tile pieceTile = board.getPieceTile(pieceToMove).getValue();

        boolean isBackward = pieceToMove.isCanBackwards();
        if (isBackward) {

        } else {

        }*//*

        return false;
    }
}*/
