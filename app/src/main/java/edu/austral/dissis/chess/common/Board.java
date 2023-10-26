package edu.austral.dissis.chess.common;

import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Getter
public class Board {
    private final List<Tile> tiles;

    public Board(List<Piece> pieces, int rows, int columns) {
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


    public Board(int rows, int columns) {
        tiles = new ArrayList<>();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                tiles.add(new Tile(x, y, null));
            }
        }
    }

    public Board(Board toCopy) {
        this.tiles = toCopy.getTiles();
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

    public String display() {
        StringBuilder boardString = new StringBuilder();
        for (int i = 1; i <= getMaxSquare().getX(); i++) {
            boardString.append("\n");
            for (int j = 1; j <= getMaxSquare().getY(); j++) {
                Tile square = getTile(i, j).get();
                if (square.getPiece() != null) {
                    Piece p = square.getPiece();
                    String pieceString;
                    if (p.getColour() == Colour.WHITE) {
                        pieceString = p.getPieceId() + p.getId();
                    } else {
                        pieceString = "\u001B[1m" + p.getPieceId() + p.getId() + "\u001B[0m";
                    }
                    boardString.append("  ").append(pieceString).append("  ");
                } else {
                    boardString.append("   %s%s   ".formatted(square.getX(), square.getY()));
                }
            }
            boardString.append("\n");
        }
        boardString.append("\n");
        return boardString.toString();
    }
}
