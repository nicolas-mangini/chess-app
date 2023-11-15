package edu.austral.dissis.common.board;

import edu.austral.dissis.common.piece.Piece;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Objects;

@AllArgsConstructor
@Getter
@Setter
public class Tile {
    private final Integer x;
    private final Integer y;
    private Piece piece;

    public Tile(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Tile(Tile toCopy) {
        this.x = toCopy.getX();
        this.y = toCopy.getY();
        if (toCopy.getPiece() == null) {
            this.piece = null;
        } else {
            this.piece = new Piece(toCopy.getPiece());
        }
    }

    public boolean equalCoordinate(Tile toCompare) {
        return Objects.equals(toCompare.getX(), x) && Objects.equals(toCompare.getY(), y);
    }
}
