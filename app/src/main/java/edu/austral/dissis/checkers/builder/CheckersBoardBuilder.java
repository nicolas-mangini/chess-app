package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.board.SimpleBoard;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.PieceBuilder;

public class CheckersBoardBuilder implements BoardBuilder {
    private final PieceBuilder checkersPieceBuilder;

    @Override
    public Board build() {
        return new SimpleBoard(checkersPieceBuilder.buildAll(), 8, 8);
    }

    public CheckersBoardBuilder() {
        this.checkersPieceBuilder = new CheckersPieceBuilder();
    }
}
