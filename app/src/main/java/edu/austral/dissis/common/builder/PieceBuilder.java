package edu.austral.dissis.common.builder;

import edu.austral.dissis.common.piece.Piece;

import java.util.List;

public interface PieceBuilder {
    List<Piece> buildAll();

    List<Piece> createWhitePieces();

    List<Piece> createBlackPieces();
}
