package edu.austral.dissis.common.game;

import edu.austral.dissis.common.board.Tile;
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
