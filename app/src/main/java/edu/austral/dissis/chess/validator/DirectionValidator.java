package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
//TODO maybe change xDirection and yDirection to be a Vector -> ex: ENUM {UP, DOWN, LEFT, RIGHT, UP_LEFT, UP_RIGHT, DOWN_LEFT, DOWN_RIGHT}
public class DirectionValidator implements MovementValidator {
    private final int xDirection;
    private final int yDirection;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Tile position = new Tile(movement.getFrom().getX() + xDirection, movement.getFrom().getY() + yDirection);
        while (!position.equalCoordinate(movement.getTo())) {
            if (isOutsideBoard(position, board)) return false;
            position = new Tile(position.getX() + xDirection, position.getY() + yDirection);
        }
        return true;
    }

    private boolean isOutsideBoard(Tile position, Board board) {
        int x = position.getX();
        int y = position.getY();
        int maxX = board.getMaxSquare().getX();
        int maxY = board.getMaxSquare().getY();

        return x < 0 || x > maxX || y < 0 || y > maxY;
    }
}
