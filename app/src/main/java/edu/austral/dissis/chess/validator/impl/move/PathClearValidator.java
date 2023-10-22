package edu.austral.dissis.chess.validator.impl.move;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PathClearValidator implements MovementValidator {
    private final int incrementX;
    private final int incrementY;
    public boolean isValid(Movement movement, Board board) {
        int x = movement.getFrom().getX();
        int y = movement.getFrom().getY();

        while (x <= movement.getTo().getX() - 1 && y <= movement.getTo().getY() - 1) {
            x += incrementX;
            y += incrementY;
            if (board.getPieceByTile(x, y).isPresent()) {
                return false;
            }
        }

        return true;
    }
}
