package edu.austral.dissis.common.builder;

import edu.austral.dissis.chess.piece.Piece;

import java.util.List;

public interface PieceBuilder {
    List<Piece> buildAll();
}
