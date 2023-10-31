package edu.austral.dissis.chess.builder;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.validator.game.CheckMate;

import java.util.ArrayList;

public class ChessGameBuilder implements GameBuilder {
    private final ChessBoardBuilder chessBoardBuilder;

    public ChessGameBuilder() {
        this.chessBoardBuilder = new ChessBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(chessBoardBuilder.build())
                .gameOverValidator(new CheckMate())
                .history(new ArrayList<>())
                .build();
    }
}
