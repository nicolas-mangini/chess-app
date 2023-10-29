package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class Movement {
    private final Tile from;
    private final Tile to;

    public Movement(Movement toCopy) {
        this.from = new Tile(toCopy.getFrom());
        this.to = new Tile(toCopy.getTo());
    }
}
