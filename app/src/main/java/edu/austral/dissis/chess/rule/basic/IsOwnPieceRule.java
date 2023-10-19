package edu.austral.dissis.chess.rule.basic;

import edu.austral.dissis.chess.Board;
import edu.austral.dissis.chess.Movement;
import edu.austral.dissis.chess.Piece;
import edu.austral.dissis.chess.Player;

public class IsOwnPieceRule implements GameRule {
    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        return !pieceToMove.getPlayerColour().equals(player.getPlayerColour());
    }
}
