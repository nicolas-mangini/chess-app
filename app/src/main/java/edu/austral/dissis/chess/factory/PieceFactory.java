package edu.austral.dissis.chess.factory;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MovementValidator;
import edu.austral.dissis.chess.validator.impl.CompoundAndValidator;
import edu.austral.dissis.chess.validator.impl.move.*;

import java.util.List;

public class PieceFactory {
    public static List<Piece> createAllPieces() {
        return List.of(
                createRookB1(),
                createKnightB1(),
                createBishopB1(),
                createKingB1(),
                createQueenB1(),
                createBishopB2(),
                createKnightB2(),
                createRookB2(),
                createPawnB1(),
                createPawnB2(),
                createPawnB3(),
                createPawnB4(),
                createPawnB5(),
                createPawnB6(),
                createPawnB7(),
                createPawnB8(),
                createRookW1(),
                createKnightW1(),
                createBishopW1(),
                createKingW1(),
                createQueenW1(),
                createBishopW2(),
                createKnightW2(),
                createRookW2(),
                createPawnW1(),
                createPawnW2(),
                createPawnW3(),
                createPawnW4(),
                createPawnW5(),
                createPawnW6(),
                createPawnW7(),
                createPawnW8()
        );
    }

    public static Piece createRookW1() {
        return Piece.builder()
                .id("1")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 1))
                .pieceId("rook")
                .validators(createRookOrValidators())
                .build();
    }

    public static Piece createKnightW1() {
        return Piece.builder()
                .id("2")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 2))
                .pieceId("knight")
                .validators(createKnightOrValidators())
                .build();
    }

    public static Piece createBishopW1() {
        return Piece.builder()
                .id("3")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 3))
                .pieceId("bishop")
                .validators(createBishopOrValidators())
                .build();
    }

    public static Piece createKingW1() {
        return Piece.builder()
                .id("4")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 4))
                .pieceId("king")
                .validators(createKingOrValidators())
                .build();
    }

    public static Piece createQueenW1() {
        return Piece.builder()
                .id("5")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 5))
                .pieceId("queen")
                .validators(createQueenOrValidators())
                .build();
    }

    public static Piece createBishopW2() {
        return Piece.builder()
                .id("6")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 6))
                .pieceId("bishop")
                .validators(createBishopOrValidators())
                .build();
    }

    public static Piece createKnightW2() {
        return Piece.builder()
                .id("7")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 7))
                .pieceId("knight")
                .validators(createKnightOrValidators())
                .build();
    }

    public static Piece createRookW2() {
        return Piece.builder()
                .id("8")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 8))
                .pieceId("rook")
                .validators(createRookOrValidators())
                .build();
    }

    public static Piece createPawnW1() {
        return Piece.builder()
                .id("9")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 1))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW2() {
        return Piece.builder()
                .id("10")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 2))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW3() {
        return Piece.builder()
                .id("11")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 3))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW4() {
        return Piece.builder()
                .id("12")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 4))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW5() {
        return Piece.builder()
                .id("13")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 5))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW6() {
        return Piece.builder()
                .id("14")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 6))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW7() {
        return Piece.builder()
                .id("15")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 7))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createPawnW8() {
        return Piece.builder()
                .id("16")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(2, 8))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.WHITE))
                .build();
    }

    public static Piece createRookB1() {
        return Piece.builder()
                .id("17")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 8))
                .pieceId("rook")
                .validators(createRookOrValidators())
                .build();
    }

    public static Piece createKnightB1() {
        return Piece.builder()
                .id("18")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 2))
                .pieceId("knight")
                .validators(createKnightOrValidators())
                .build();
    }

    public static Piece createBishopB1() {
        return Piece.builder()
                .id("19")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 3))
                .pieceId("bishop")
                .validators(createBishopOrValidators())
                .build();
    }

    public static Piece createKingB1() {
        return Piece.builder()
                .id("20")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 4))
                .pieceId("king")
                .validators(createKingOrValidators())
                .build();
    }

    public static Piece createQueenB1() {
        return Piece.builder()
                .id("21")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 5))
                .pieceId("queen")
                .validators(createQueenOrValidators())
                .build();
    }

    public static Piece createBishopB2() {
        return Piece.builder()
                .id("22")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 6))
                .pieceId("bishop")
                .validators(createBishopOrValidators())
                .build();
    }

    public static Piece createKnightB2() {
        return Piece.builder()
                .id("23")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 7))
                .pieceId("knight")
                .validators(createKnightOrValidators())
                .build();
    }

    public static Piece createRookB2() {
        return Piece.builder()
                .id("24")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(8, 1))
                .pieceId("rook")
                .validators(createRookOrValidators())
                .build();
    }

    public static Piece createPawnB1() {
        return Piece.builder()
                .id("25")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 1))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB2() {
        return Piece.builder()
                .id("26")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 2))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB3() {
        return Piece.builder()
                .id("27")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 3))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB4() {
        return Piece.builder()
                .id("28")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 4))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB5() {
        return Piece.builder()
                .id("29")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 5))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB6() {
        return Piece.builder()
                .id("30")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 6))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB7() {
        return Piece.builder()
                .id("31")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 7))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    public static Piece createPawnB8() {
        return Piece.builder()
                .id("32")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(7, 8))
                .pieceId("pawn")
                .validators(createPawnOrValidators(Colour.BLACK))
                .build();
    }

    private static List<MovementValidator> createRookOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    private static List<MovementValidator> createKnightOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, 2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, 2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, -2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, -2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    private static List<MovementValidator> createBishopOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    private static List<MovementValidator> createQueenOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    private static List<MovementValidator> createKingOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    private static List<MovementValidator> createPawnOrValidators(Colour colour) {
        int xDirection = colour == Colour.WHITE ? 1 : -1;

        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(2),
                        new LimitMovementsValidator(1),
                        new EatValidator(false),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(1),
                        new EatValidator(false),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new PathClearValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new MustEatValidator(),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new PathClearValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new MustEatValidator(),
                        new EatOwnPieceValidator(false)
                ))
        );
    }
}
