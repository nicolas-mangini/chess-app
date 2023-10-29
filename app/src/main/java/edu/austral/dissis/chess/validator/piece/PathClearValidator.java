package edu.austral.dissis.chess.validator.piece;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PathClearValidator implements MovementValidator {
    private final int xDirection;
    private final int yDirection;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Tile tile = board.getTile(movement.getFrom().getX() + xDirection, movement.getFrom().getY() + yDirection).get();
        while (!tile.equalCoordinate(movement.getTo())) {
            if (tile.getPiece() != null) return false;
            tile = new Tile(board.getTile(tile.getX() + xDirection, tile.getY() + yDirection).get());
        }
        return true;
    }
}
