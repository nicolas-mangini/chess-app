package edu.austral.dissis.common.game;

import edu.austral.dissis.common.util.MovementResult;

public interface GameMover {
    MovementResult<GameManager, String> tryMovement(Movement movement, GameManager gameManager);

}
