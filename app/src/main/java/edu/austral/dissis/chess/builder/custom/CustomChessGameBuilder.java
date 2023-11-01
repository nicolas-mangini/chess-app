package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.game.Colour;

import java.util.ArrayList;

public class CustomChessGameBuilder implements GameBuilder {
    private final BoardBuilder customChessBoardBuilder;
    private final CustomChessValidatorBuilder customChessValidatorBuilder;

    public CustomChessGameBuilder() {
        this.customChessBoardBuilder = new CustomChessBoardBuilder();
        this.customChessValidatorBuilder = new CustomChessValidatorBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(customChessBoardBuilder.build())
                .gameOverValidators(customChessValidatorBuilder.buildGameOverValidators())
                .history(new ArrayList<>())
                .build();
    }
}
