package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.game.Game;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.game.Colour;

import java.util.ArrayList;

public class CheckersGameBuilder implements GameBuilder {
    private final BoardBuilder checkersBoardBuilder;

    public CheckersGameBuilder() {
        this.checkersBoardBuilder = new CheckersBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(checkersBoardBuilder.build())
                .gameValidators(CheckersGameRulesBuilder.buildGameValidators())
                .gameOverValidators(CheckersGameRulesBuilder.buildGameOverValidators())
                .history(new ArrayList<>())
                .build();
    }
}
