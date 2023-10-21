package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.validator.MoveValidator;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.List;

@Getter
@Builder
@EqualsAndHashCode
@AllArgsConstructor
public class Piece {
    private final String id;
    private final PlayerColour colour;
    private final Tile initialPosition;
    private final String pieceId;
    private final List<List<MoveValidator>> orValidators; //or-rules
    private final List<MoveValidator> andValidators; //and-rules

    public Piece(Piece toCopy) {
        this.id = toCopy.id;
        this.colour = toCopy.colour;
        this.initialPosition = toCopy.initialPosition;
        this.pieceId = toCopy.pieceId;
        this.andValidators = List.copyOf(toCopy.andValidators);
        this.orValidators = List.copyOf(toCopy.orValidators);
    }
}
