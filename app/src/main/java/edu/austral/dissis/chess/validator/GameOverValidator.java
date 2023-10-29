package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.util.WinResult;

import java.util.List;

public interface GameOverValidator {
    WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, List<Movement> movementHistory);
}
