package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Game;
import edu.austral.dissis.common.builder.GameBuilder;

import java.util.ArrayList;

public class ClassicChessGameBuilder implements GameBuilder {
    private final BoardBuilder chessBoardBuilder;

    public ClassicChessGameBuilder() {
        this.chessBoardBuilder = new ClassicChessBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(chessBoardBuilder.build())
                .gameValidators(ClassicChessGameRulesBuilder.buildGameValidators())
                .gameOverValidators(ClassicChessGameRulesBuilder.buildGameOverValidators())
                .history(new ArrayList<>())
                .build();
    }
}
