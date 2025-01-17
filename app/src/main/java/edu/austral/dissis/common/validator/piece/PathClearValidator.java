package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PathClearValidator implements MovementValidator {
    private final int xDirection;
    private final int yDirection;

    public PathClearValidator(Direction direction) {
        this.xDirection = direction.getX();
        this.yDirection = direction.getY();
    }

    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Tile tile = board.getTile(movement.getFrom().getX() + xDirection, movement.getFrom().getY() + yDirection).get();
        while (!tile.equalCoordinate(movement.getTo())) {
            if (tile.getPiece() != null) return false;
            tile = new Tile(board.getTile(tile.getX() + xDirection, tile.getY() + yDirection).get());
        }
        return true;
    }
}
