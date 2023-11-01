package edu.austral.dissis.chess.game;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.GameOverValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
@Builder
public class Game {
    private final Colour player1;
    private final Colour player2;
    private final Board board;
    private final List<GameOverValidator> gameOverValidators;
    private final List<Movement> history;
}
