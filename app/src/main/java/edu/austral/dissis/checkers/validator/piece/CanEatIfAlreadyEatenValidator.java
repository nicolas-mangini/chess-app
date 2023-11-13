package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

public class CanEatIfAlreadyEatenValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        List<Movement> history = gameManager.getGame().getHistory();

        // if last movement.getFrom().getPiece() has the same piece as the current history movement,
        // then it can eat -> true
        if (history.get(history.size() - 1).getFrom().getPiece() == movement.getFrom().getPiece()) {
            return true;
        }
        return false;
    }
}
