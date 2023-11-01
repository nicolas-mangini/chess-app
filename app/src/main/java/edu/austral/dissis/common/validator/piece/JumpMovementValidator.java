package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class JumpMovementValidator implements MovementValidator {
    private final int toX;
    private final int toY;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Tile from = movement.getFrom();
        Tile to = movement.getTo();
        return to.getX() == from.getX() + toX && to.getY() == from.getY() + toY;
    }
}
