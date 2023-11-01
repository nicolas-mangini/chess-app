package edu.austral.dissis.common.validator;

import edu.austral.dissis.chess.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.WinResult;

import java.util.List;

public interface GameOverValidator {
    WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, List<Movement> movementHistory);
}