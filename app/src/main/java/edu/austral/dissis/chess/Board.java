package edu.austral.dissis.chess;

import lombok.Data;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

@Data
public class Board {
    private final List<Tile> tiles;

    public Board(List<Tile> tiles) {
        this.tiles = tiles;
    }

    public Board(int xAmount, int yAmount) {
        tiles = new ArrayList<>();
        for (int x = 1; x <= xAmount; x++) {
            for (int y = 1; y <= yAmount; y++) {
                tiles.add(new Tile(x, y, null));
            }
        }
    }

    public Result<Tile> getTile(int x, int y) {
        for (Tile tile : tiles) {
            if (tile.getX() == x && tile.getY() == y) {
                return Result.success(tile);
            }
        }
        return Result.failure("Square not found at coordinates (%s,%s)".formatted(x, y));
    }

    public Result<Tile> getPieceTile(Piece piece) {
        for (Tile tile : tiles) {
            if (tile.getPiece() != null && tile.getPiece().equals(piece)) {
                return Result.success(tile);
            }
        }
        return Result.failure("Piece not found in any square");
    }

    public Result<Tile> getMaxSquare() {
        Optional<Tile> tileOptional = tiles.stream()
                .max(Comparator.comparingInt(Tile::getX)
                        .thenComparingInt(Tile::getY));
        if (tileOptional.isPresent()) return Result.success(tileOptional.get());
        else return Result.failure("Max square not found");
    }

    public String displayBoard() {
        StringBuilder board = new StringBuilder();
        for (int i = 1; i <= getMaxSquare().getValue().getX(); i++) {
            board.append("\n");
            for (int j = 1; j <= getMaxSquare().getValue().getY(); j++) {
                Tile square = getTile(i, j).getValue();
                if (square.getPiece() != null) {
                    Piece p = square.getPiece();
                    String pieceString;
                    if (p.getPlayerColour() == PlayerColour.WHITE) {
                        pieceString = p.getId();
                    } else {
                        pieceString = "\u001B[1m" + p.getId() + "\u001B[0m";
                    }
                    board.append("  ").append(pieceString).append("  ");
                } else {
                    board.append("   ▢   ");
                }
            }
            board.append("\n");
        }
        board.append("\n");
        return board.toString();
    }

    protected Board cloneBoard(Board board) {
        return new Board(board.getTiles());
    }
}
