package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.game.Game;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.game.Colour;

import java.util.ArrayList;

public class CheckersGameBuilder implements GameBuilder {
    private final CheckersMovementBuilder checkersMovementBuilder;
    private final CheckersBoardBuilder checkersBoardBuilder;

    public CheckersGameBuilder() {
        this.checkersMovementBuilder = new CheckersMovementBuilder();
        this.checkersBoardBuilder = new CheckersBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(checkersBoardBuilder.build())
                .gameValidators(checkersMovementBuilder.buildGameValidators())
                .gameOverValidators(checkersMovementBuilder.buildGameOverValidators())
                .history(new ArrayList<>())
                .build();
    }
}
