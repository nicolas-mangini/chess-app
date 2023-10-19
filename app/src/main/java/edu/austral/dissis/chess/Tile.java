package edu.austral.dissis.chess;

import lombok.Data;

@Data
public class Tile {
    private final Integer x;
    private final Integer y;
    private Piece piece;

    public Tile(Integer x, Integer y, Piece piece) {
        this.x = x;
        this.y = y;
        this.piece = piece;
    }
}
