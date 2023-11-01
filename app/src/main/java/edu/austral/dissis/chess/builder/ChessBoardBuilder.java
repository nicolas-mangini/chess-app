package edu.austral.dissis.chess.builder;

import edu.austral.dissis.chess.board.Board;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.PieceBuilder;

public class ChessBoardBuilder implements BoardBuilder {
    private final PieceBuilder chessPieceBuilder;

    public ChessBoardBuilder() {
        this.chessPieceBuilder = new ChessPieceBuilder();
    }

    @Override
    public Board build() {
        return new Board(chessPieceBuilder.buildAll(), 8, 8);
    }
}
