
package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.common.board.SimpleBoard;
import edu.austral.dissis.common.builder.BoardBuilder;
import edu.austral.dissis.common.builder.PieceBuilder;

public class CustomChessBoardBuilder implements BoardBuilder {
    private final PieceBuilder customChessPieceBuilder;

    public CustomChessBoardBuilder() {
        this.customChessPieceBuilder = new CustomChessPieceBuilder();
    }

    @Override
    public SimpleBoard build() {
        return new SimpleBoard(customChessPieceBuilder.buildAll(), 8, 8);
    }
}
