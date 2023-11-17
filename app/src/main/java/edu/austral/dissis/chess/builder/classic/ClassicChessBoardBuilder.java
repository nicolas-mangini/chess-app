package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.SimpleBoard;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.PieceBuilder;

public class ClassicChessBoardBuilder implements BoardBuilder {
    private final PieceBuilder chessPieceBuilder;

    public ClassicChessBoardBuilder() {
        this.chessPieceBuilder = new ClassicChessPieceBuilder();
    }

    @Override
    public Board build() {
        return new SimpleBoard(chessPieceBuilder.buildAll(), 8, 8);
    }
}

