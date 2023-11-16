package edu.austral.dissis.common.game;

import edu.austral.dissis.common.util.MovementResult;
import edu.austral.dissis.common.util.Result;

public interface GameMover {
    Result<?, ?> tryMovement(Movement movement, GameManager gameManager);
}
