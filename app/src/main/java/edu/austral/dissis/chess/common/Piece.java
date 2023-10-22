package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Builder
@Getter
public class Piece {
    private final String id;
    private final Colour colour;
    private final Tile initialPosition;
    private final String pieceId;
    private final List<MovementValidator> orValidators;
    private final List<MovementValidator> andValidators;

    public Piece(Piece toCopy) {
        this.id = toCopy.id;
        this.colour = toCopy.colour;
        this.initialPosition = toCopy.initialPosition;
        this.pieceId = toCopy.pieceId;
        this.orValidators = toCopy.orValidators;
        this.andValidators = toCopy.andValidators;
    }
}
