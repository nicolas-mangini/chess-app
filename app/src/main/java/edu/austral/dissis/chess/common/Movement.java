package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class Movement {
    private final Tile from;
    private final Tile to;
}
