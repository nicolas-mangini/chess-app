package edu.austral.dissis.chess.game;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.turn.TurnChanger;
import edu.austral.dissis.common.turn.TwoPlayersTurnChanger;
import edu.austral.dissis.common.util.Result;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class GameManager {
    private final Game game;
    private final GameMover gameMover;
    private final TurnChanger turnChanger;

    public Result<Boolean, Colour> isGameOver(Movement movement) {
        return game.getGameOverValidators().stream()
                .map(validator -> validator.isGameOver(movement, game.getBoard(), game.getHistory()))
                .filter(Result::getKey)
                .findFirst()
                // turnChanger already changed the turn (inside makeMovement) in the applyMovement method
                // and this method is called after that, so we need to get the previous one
                .map(result -> new WinResult<>(true, turnChanger.getPreviousTurn()))
                .orElse(new WinResult<>(false, null));
    }
}
