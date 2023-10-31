package edu.austral.dissis.chess.board;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.BoardPrinter;
import edu.austral.dissis.common.board.Tile;
import lombok.Getter;

import java.util.*;

@Getter
public class ChessBoard implements Board {
    private final List<Tile> tiles;
    private final BoardPrinter printer = new ChessBoardPrinter();

    public ChessBoard(List<Piece> pieces, int rows, int columns) {
        tiles = new ArrayList<>();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                tiles.add(new Tile(x, y, null));
            }
        }

        for (Piece piece : pieces) {
            Tile initialPosition = piece.getInitialPosition();
            int x = initialPosition.getX();
            int y = initialPosition.getY();
            Tile tile = getTile(x, y).get();
            tile.setPiece(piece);
        }
    }


    public ChessBoard(int rows, int columns) {
        tiles = new ArrayList<>();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                tiles.add(new Tile(x, y, null));
            }
        }
    }

    public ChessBoard(ChessBoard toCopy) {
        this.tiles = toCopy.getTiles()
                .stream()
                .map(Tile::new)
                .toList();
    }

    //pieceId, example: "rook"
    public Optional<Piece> findPiece(String pieceId, Colour colour) {
        return tiles.stream()
                .map(Tile::getPiece)
                .filter(Objects::nonNull)
                .filter(piece -> piece.getPieceId().equals(pieceId))
                .filter(piece -> piece.getColour().equals(colour))
                .findFirst();
    }

    public void setPieceAtTile(Piece piece, Tile tile) {
        tiles.stream()
                .filter(t -> t.equalCoordinate(tile))
                .findFirst()
                .ifPresent(t -> t.setPiece(piece));
    }

    public Optional<Piece> getPieceByTile(int x, int y) {
        return tiles.stream()
                .filter(tile -> tile.getX() == x && tile.getY() == y)
                .map(tile -> Optional.ofNullable(tile.getPiece()))
                .findFirst()
                .orElse(Optional.empty());
    }

    public Optional<Tile> getTileByPiece(Piece piece) {
        return tiles.stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getId().equals(piece.getId()))
                .findFirst();
    }

    public Optional<Tile> getTile(int x, int y) {
        return tiles.stream()
                .filter(tile -> tile.getX() == x && tile.getY() == y)
                .findFirst();
    }

    public Tile getMaxSquare() {
        return tiles.stream()
                .max(Comparator.comparingInt(Tile::getX)
                        .thenComparingInt(Tile::getY)).get();
    }
}