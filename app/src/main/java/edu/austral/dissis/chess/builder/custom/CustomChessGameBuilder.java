package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.chess.builder.ChessBoardBuilder;
import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.game.CheckMate;

import java.util.ArrayList;

public class CustomChessGameBuilder implements GameBuilder {
    private final BoardBuilder customChessBoardBuilder;

    public CustomChessGameBuilder() {
        this.customChessBoardBuilder = new CustomChessBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(customChessBoardBuilder.build())
                .gameOverValidator(new CheckMate())
                .history(new ArrayList<>())
                .build();
    }
}
