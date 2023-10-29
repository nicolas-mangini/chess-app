package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

@AllArgsConstructor
@Builder
@Getter
public class Piece {
    private final String id;
    private final Colour colour;
    private final Tile initialPosition;
    private final String pieceId;
    private final PieceMovementsValidator pieceMover;

    public Piece(Piece toCopy) {
        this.id = toCopy.id;
        this.colour = toCopy.colour;
        this.initialPosition = toCopy.initialPosition;
        this.pieceId = toCopy.pieceId;
        this.pieceMover = toCopy.pieceMover;
    }
}