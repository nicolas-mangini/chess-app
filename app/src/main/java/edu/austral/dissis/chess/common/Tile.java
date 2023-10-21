package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@Getter
@Setter
@AllArgsConstructor
public class Tile {
    private final Integer x;
    private final Integer y;
    private Piece piece;

    public Tile(Tile toCopy) {
        this.x = toCopy.getX();
        this.y = toCopy.getY();
        this.piece = toCopy.getPiece();
    }

    public boolean equalCoordinate(Tile toCompare) {
        return Objects.equals(toCompare.getX(), x) && Objects.equals(toCompare.getY(), y);
    }
}
