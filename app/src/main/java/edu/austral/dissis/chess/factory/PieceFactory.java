package edu.austral.dissis.chess.factory;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MovementValidator;
import edu.austral.dissis.chess.validator.impl.CompoundAndValidator;
import edu.austral.dissis.chess.validator.impl.move.DirectionValidator;
import edu.austral.dissis.chess.validator.impl.move.EatValidator;
import edu.austral.dissis.chess.validator.impl.move.IncrementValidator;
import edu.austral.dissis.chess.validator.impl.move.PathClearValidator;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PieceFactory {
    public static Piece createRook() {
        return Piece.builder()
                .id("1")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 1))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createBishop() {
        return Piece.builder()
                .id("3")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 3))
                .pieceId("bishop")
                .orValidators(createBishopOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    private static List<MovementValidator> createRookOrValidators() {
        List<MovementValidator> rookOrValidators = new ArrayList<>();

        CompoundAndValidator compositeValidator1 = new CompoundAndValidator(List.of(

                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new IncrementValidator(2)
                //new EatValidator()
        ));

        CompoundAndValidator compositeValidator2 = new CompoundAndValidator(List.of(
                new DirectionValidator(-1, 0),
                new PathClearValidator(-1, 0)
                //new EatValidator()
        ));

        CompoundAndValidator compositeValidator3 = new CompoundAndValidator(List.of(
                new DirectionValidator(0, 1),
                // if i add the validator, now the piece cannot eat
                new PathClearValidator(0, 1),
                new EatValidator()
        ));

        CompoundAndValidator compositeValidator4 = new CompoundAndValidator(List.of(
                new DirectionValidator(0, -1),
                new PathClearValidator(0, -1)
                //new EatValidator()
        ));
        rookOrValidators.add(compositeValidator1);
        rookOrValidators.add(compositeValidator2);
        rookOrValidators.add(compositeValidator3);
        rookOrValidators.add(compositeValidator4);

        return rookOrValidators;
    }

    private static List<MovementValidator> createBishopOrValidators() {
        List<MovementValidator> bishopOrValidators = new ArrayList<>();

        CompoundAndValidator compositeValidator1 = new CompoundAndValidator(List.of(

                new DirectionValidator(1, 1),
                new PathClearValidator(1, 1)
                //new EatValidator()
        ));

        CompoundAndValidator compositeValidator2 = new CompoundAndValidator(List.of(
                new DirectionValidator(-1, -1),
                new PathClearValidator(-1, -1)
                //new EatValidator()
        ));

        CompoundAndValidator compositeValidator3 = new CompoundAndValidator(List.of(
                new DirectionValidator(1, -1),
                new PathClearValidator(1, -1)
                //new EatValidator()
        ));

        CompoundAndValidator compositeValidator4 = new CompoundAndValidator(List.of(
                new DirectionValidator(-1, 1),
                new PathClearValidator(-1, 1)
                //new EatValidator()
        ));
        bishopOrValidators.add(compositeValidator1);
        bishopOrValidators.add(compositeValidator2);
        bishopOrValidators.add(compositeValidator3);
        bishopOrValidators.add(compositeValidator4);

        return bishopOrValidators;
    }

    private static List<MovementValidator> createDefaultAndValidators() {
        return Collections.emptyList();
    }
}
