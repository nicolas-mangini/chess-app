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
    public static Piece createRookW1() {
        return Piece.builder()
                .id("1")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 1))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createKnightW1() {
        return Piece.builder()
                .id("2")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 2))
                .pieceId("knight")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createBishopW1() {
        return Piece.builder()
                .id("3")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 3))
                .pieceId("bishop")
                .orValidators(createBishopOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createKingW1() {
        return Piece.builder()
                .id("4")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 4))
                .pieceId("king")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createQueenW1() {
        return Piece.builder()
                .id("5")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 5))
                .pieceId("queen")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createBishopW2() {
        return Piece.builder()
                .id("6")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 6))
                .pieceId("bishop")
                .orValidators(createBishopOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createKnightW2() {
        return Piece.builder()
                .id("7")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 7))
                .pieceId("knight")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createRookW2() {
        return Piece.builder()
                .id("8")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 8))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW1() {
        return Piece.builder()
                .id("9")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 1))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW2() {
        return Piece.builder()
                .id("10")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 2))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW3() {
        return Piece.builder()
                .id("11")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 3))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW4() {
        return Piece.builder()
                .id("12")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 4))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW5() {
        return Piece.builder()
                .id("13")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 5))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW6() {
        return Piece.builder()
                .id("14")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 6))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW7() {
        return Piece.builder()
                .id("15")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 7))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnW8() {
        return Piece.builder()
                .id("16")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 8))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createRookB1() {
        return Piece.builder()
                .id("17")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 8))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createKnightB1() {
        return Piece.builder()
                .id("18")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 2))
                .pieceId("knight")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createBishopB1() {
        return Piece.builder()
                .id("19")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 3))
                .pieceId("bishop")
                .orValidators(createBishopOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createKingB1() {
        return Piece.builder()
                .id("20")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 4))
                .pieceId("king")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createQueenB1() {
        return Piece.builder()
                .id("21")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 5))
                .pieceId("queen")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createBishopB2() {
        return Piece.builder()
                .id("22")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 6))
                .pieceId("bishop")
                .orValidators(createBishopOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createKnightB2() {
        return Piece.builder()
                .id("23")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 7))
                .pieceId("knight")
                .orValidators(Collections.emptyList())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createRookB2() {
        return Piece.builder()
                .id("24")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 1))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB1() {
        return Piece.builder()
                .id("25")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 1))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB2() {
        return Piece.builder()
                .id("26")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 2))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB3() {
        return Piece.builder()
                .id("27")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 3))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB4() {
        return Piece.builder()
                .id("28")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 4))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB5() {
        return Piece.builder()
                .id("29")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 5))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB6() {
        return Piece.builder()
                .id("30")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 6))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB7() {
        return Piece.builder()
                .id("31")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 7))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
                .andValidators(createDefaultAndValidators())
                .build();
    }

    public static Piece createPawnB8() {
        return Piece.builder()
                .id("32")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 8))
                .pieceId("pawn")
                .orValidators(createPawnOrValidators())
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
                new PathClearValidator(0, 1),
                // if i add the validator, now the piece cannot eat
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

    private static List<MovementValidator> createPawnOrValidators() {
        List<MovementValidator> pawnOrValidators = new ArrayList<>();

        CompoundAndValidator compositeValidator1 = new CompoundAndValidator(List.of(
                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new IncrementValidator(2),
                new EatValidator()
        ));

        CompoundAndValidator compositeValidator2 = new CompoundAndValidator(List.of(
                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new IncrementValidator(1),
                new EatValidator()
        ));

        pawnOrValidators.add(compositeValidator1);
        pawnOrValidators.add(compositeValidator2);

        return pawnOrValidators;
    }

    private static List<MovementValidator> createDefaultAndValidators() {
        return Collections.emptyList();
    }
}
