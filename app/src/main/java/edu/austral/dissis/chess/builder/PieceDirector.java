/*
package edu.austral.dissis.chess.builder;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class PieceDirector {
    private int ID;
    private final MovementDirector movementDirector;

    public Piece buildRook(Colour colour, List<MovementValidator> orValidators, List<MovementValidator> andValidators) {
        return Piece.builder()
                .id(Integer.toString(ID++))
                .colour(colour)
                .initialPosition(new Tile(1, 1))
                .pieceId("rook")
                .validators(movementDirector.buildRookMovementValidators())
                .andValidators(movementDirector.buildDefaultMovementValidators())
                .build();
    }

    public Piece buildBishop(Colour colour, List<MovementValidator> orValidators, List<MovementValidator> andValidators) {
        return Piece.builder()
                .id(Integer.toString(ID++))
                .colour(colour)
                .initialPosition(new Tile(1, 1))
                .pieceId("bishop")
                .validators(movementDirector.buildBishopMovementValidators())
                .andValidators(movementDirector.buildDefaultMovementValidators())
                .build();
    }
}
*/
