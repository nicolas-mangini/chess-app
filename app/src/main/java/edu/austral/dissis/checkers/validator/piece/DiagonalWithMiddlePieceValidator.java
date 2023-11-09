package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.Direction;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class DiagonalWithMiddlePieceValidator implements MovementValidator {
    private final int xDirection;
    private final int yDirection;

    public DiagonalWithMiddlePieceValidator(Direction direction) {
        this.xDirection = direction.getX();
        this.yDirection = direction.getY();
    }

    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
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
