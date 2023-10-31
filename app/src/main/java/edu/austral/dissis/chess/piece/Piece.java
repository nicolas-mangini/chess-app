package edu.austral.dissis.chess.piece;

import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
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