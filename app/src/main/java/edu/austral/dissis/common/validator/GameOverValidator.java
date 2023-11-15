package edu.austral.dissis.common.validator;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.WinResult;

public interface GameOverValidator {
    WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager);
}
