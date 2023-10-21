package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@Getter
public class Board {
    private final List<Tile> tiles;

    //copy constructor
    public Board(Board toCopy) {
        this.tiles = toCopy.getTiles();
    }

    public Board(int rows, int columns) {
        tiles = new ArrayList<>();
        for (int x = 1; x <= rows; x++) {
            for (int y = 1; y <= columns; y++) {
                //TODO change piece to optional
                tiles.add(new Tile(x, y, null));
            }
        }
    }

    public Optional<Board> setPieceInSquare(Piece piece) {
        Tile initialPosition = piece.getInitialPosition();
        List<Tile> updatedTiles = tiles.stream()
                .map(tile -> {
                    if (tile.getX() == initialPosition.getX() && tile.getY() == initialPosition.getY()) {
                        return new Tile(tile.getX(), tile.getY(), piece);
                    } else {
                        return tile;
                    }
                })
                .toList();

        return Optional.of(new Board(updatedTiles));
    }

    public Optional<Tile> getTile(int x, int y) {
        return tiles.stream()
                .filter(tile -> tile.getX() == x && tile.getY() == y)
                .findFirst();
    }

    public Optional<Tile> getTileByPiece(Piece piece) {
        return tiles.stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().equals(piece))
                .findFirst();
    }

    public Optional<Piece> getPieceByTile(int x, int y) {
        return tiles.stream()
                .filter(tile -> tile.getX() == x && tile.getY() == y)
                .map(Tile::getPiece)
                .findFirst();
    }

    public Tile getMaxSquare() {
        return tiles.stream()
                .max(Comparator.comparingInt(Tile::getX)
                        .thenComparingInt(Tile::getY)).get();
    }

    public String print() {
        StringBuilder boardString = new StringBuilder();
        for (int i = 1; i <= getMaxSquare().getX(); i++) {
            boardString.append("\n");
            for (int j = 1; j <= getMaxSquare().getY(); j++) {
                Tile square = getTile(i, j).get();
                if (square.getPiece() != null) {
                    Piece p = square.getPiece();
                    String pieceString;
                    if (p.getColour() == PlayerColour.WHITE) {
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
