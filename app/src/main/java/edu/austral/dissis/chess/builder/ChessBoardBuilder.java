package edu.austral.dissis.chess.builder;

import edu.austral.dissis.chess.board.ChessBoard;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.PieceBuilder;

public class ChessBoardBuilder implements BoardBuilder {
    private final PieceBuilder chessPieceBuilder;

    public ChessBoardBuilder() {
        this.chessPieceBuilder = new ChessPieceBuilder();
    }

    @Override
    public ChessBoard build() {
        return new ChessBoard(chessPieceBuilder.buildAll(), 8, 8);
    }
}
