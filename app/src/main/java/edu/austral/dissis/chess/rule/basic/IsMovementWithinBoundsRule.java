package edu.austral.dissis.chess.rule.basic;

import edu.austral.dissis.chess.Board;
import edu.austral.dissis.chess.Movement;
import edu.austral.dissis.chess.Player;

public class IsMovementWithinBoundsRule implements GameRule {
    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        int toX = movement.getTo().getX();
        int toY = movement.getTo().getY();
        int maxX = board.getMaxSquare().getValue().getX();
        int maxY = board.getMaxSquare().getValue().getY();
        return toX >= 1 && toX <= maxX && toY >= 1 && toY <= maxY;
    }
}
