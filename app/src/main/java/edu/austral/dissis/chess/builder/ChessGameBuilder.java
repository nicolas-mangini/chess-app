package edu.austral.dissis.chess.builder;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.common.builder.GameBuilder;

import java.util.ArrayList;

public class ChessGameBuilder implements GameBuilder {
    private final ChessBoardBuilder chessBoardBuilder;
    private final ChessValidatorBuilder chessValidatorBuilder;

    public ChessGameBuilder() {
        this.chessValidatorBuilder = new ChessValidatorBuilder();
        this.chessBoardBuilder = new ChessBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(chessBoardBuilder.build())
                .gameOverValidators(chessValidatorBuilder.buildGameOverValidators())
                .history(new ArrayList<>())
                .build();
    }
}
