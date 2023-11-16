package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Game;
import edu.austral.dissis.common.builder.GameBuilder;

import java.util.ArrayList;

public class ChessGameBuilder implements GameBuilder {
    private final BoardBuilder chessBoardBuilder;
    private final ChessMovementBuilder chessMovementBuilder;

    public ChessGameBuilder() {
        this.chessMovementBuilder = new ChessMovementBuilder();
        this.chessBoardBuilder = new ChessBoardBuilder();
    }

    @Override
    public Game build() {
        return Game.builder()
                .player1(Colour.WHITE)
                .player2(Colour.BLACK)
                .board(chessBoardBuilder.build())
                .gameValidators(chessMovementBuilder.buildGameValidators())
                .gameOverValidators(chessMovementBuilder.buildGameOverValidators())
                .history(new ArrayList<>())
                .build();
    }
}