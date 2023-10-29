package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.util.Result;
import edu.austral.dissis.chess.util.WinResult;
import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameManager {
    private final Game game;
    private final GameMover gameMover;
    private final TurnChanger turnChanger;

    public Result<Boolean, Colour> isGameOver(Movement movement) {
        boolean isGameOver = game.getGameOverValidator().isGameOver(movement, game.getBoard(), game.getHistory()).getKey();
        if (isGameOver) {
            // turnChanger already changed the turn (inside makeMovement) in the applyMovement method
            // and this method is called after that, so we need to get the previous one
            return new WinResult<>(true, turnChanger.getPreviousTurn());
        }
        return new WinResult<>(false, null);
    }
}
