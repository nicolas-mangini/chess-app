package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.chess.board.ChessBoard;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class DirectionValidator implements MovementValidator {
    private final int xDirection;
    private final int yDirection;

    @Override
    public boolean isValid(Movement movement, ChessBoard board, List<Movement> movementHistory) {
        Tile position = new Tile(movement.getFrom().getX() + xDirection, movement.getFrom().getY() + yDirection);
        while (!position.equalCoordinate(movement.getTo())) {
            if (isOutsideBoard(position, board)) return false;
            position = new Tile(position.getX() + xDirection, position.getY() + yDirection);
        }
        return true;
    }

    private boolean isOutsideBoard(Tile position, ChessBoard board) {
        int x = position.getX();
        int y = position.getY();
        int maxX = board.getMaxSquare().getX();
        int maxY = board.getMaxSquare().getY();

        return x < 0 || x > maxX || y < 0 || y > maxY;
    }
}
