package edu.austral.dissis.common.board;

import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.piece.PieceType;

import java.util.List;
import java.util.Optional;

public interface Board {
    Tile getMaxSquare();

    Optional<Piece> findPiece(PieceType pieceType, Colour colour);

    void setPieceAtTile(Piece piece, Tile tile);

    Optional<Piece> getPieceByTile(int x, int y);

    Optional<Tile> getTileByPiece(Piece piece);

    Optional<Tile> getTile(int x, int y);

    List<Tile> getTiles();
}
