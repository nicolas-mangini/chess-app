package edu.austral.dissis.chess;

import lombok.Data;

@Data
public class Movement {
    private final Tile from;
    private final Tile to;

    public Movement(Tile from, Tile to) {
        this.from = from;
        this.to = to;
    }
}
