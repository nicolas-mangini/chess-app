package edu.austral.dissis.chess.factory;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;

import java.util.List;

public class ChessPieceFactory {
    private final ChessMovementFactory chessMovementFactory;

    public ChessPieceFactory() {
        this.chessMovementFactory = new ChessMovementFactory();
    }

    public List<Piece> createBlackPieces() {
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
                createPawnB8());
    }

    public List<Piece> createWhitePieces() {
        return List.of(createRookW1(),
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
                createPawnW8());
    }

    private Piece createRookW1() {
        return Piece.builder()
                .id("1")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 1))
                .pieceId("rook")
                .orValidators(chessMovementFactory.createRookMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createKnightW1() {
        return Piece.builder()
                .id("2")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 2))
                .pieceId("knight")
                .orValidators(chessMovementFactory.createKnightMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createBishopW1() {
        return Piece.builder()
                .id("3")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 3))
                .pieceId("bishop")
                .orValidators(chessMovementFactory.createBishopMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createQueenW1() {
        return Piece.builder()
                .id("4")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 4))
                .pieceId("queen")
                .orValidators(chessMovementFactory.createQueenMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createKingW1() {
        return Piece.builder()
                .id("5")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 5))
                .pieceId("king")
                .orValidators(chessMovementFactory.createKingMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createBishopW2() {
        return Piece.builder()
                .id("6")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 6))
                .pieceId("bishop")
                .orValidators(chessMovementFactory.createBishopMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createKnightW2() {
        return Piece.builder()
                .id("7")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 7))
                .pieceId("knight")
                .orValidators(chessMovementFactory.createKnightMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createRookW2() {
        return Piece.builder()
                .id("8")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 8))
                .pieceId("rook")
                .orValidators(chessMovementFactory.createRookMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW1() {
        return Piece.builder()
                .id("9")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 1))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW2() {
        return Piece.builder()
                .id("10")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 2))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW3() {
        return Piece.builder()
                .id("11")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 3))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW4() {
        return Piece.builder()
                .id("12")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 4))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW5() {
        return Piece.builder()
                .id("13")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 5))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW6() {
        return Piece.builder()
                .id("14")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 6))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW7() {
        return Piece.builder()
                .id("15")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 7))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnW8() {
        return Piece.builder()
                .id("16")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 8))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createRookB1() {
        return Piece.builder()
                .id("17")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 8))
                .pieceId("rook")
                .orValidators(chessMovementFactory.createRookMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createKnightB1() {
        return Piece.builder()
                .id("18")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 2))
                .pieceId("knight")
                .orValidators(chessMovementFactory.createKnightMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createBishopB1() {
        return Piece.builder()
                .id("19")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 3))
                .pieceId("bishop")
                .orValidators(chessMovementFactory.createBishopMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createQueenB1() {
        return Piece.builder()
                .id("20")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 4))
                .pieceId("queen")
                .orValidators(chessMovementFactory.createQueenMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createKingB1() {
        return Piece.builder()
                .id("21")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 5))
                .pieceId("king")
                .orValidators(chessMovementFactory.createKingMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createBishopB2() {
        return Piece.builder()
                .id("22")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 6))
                .pieceId("bishop")
                .orValidators(chessMovementFactory.createBishopMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createKnightB2() {
        return Piece.builder()
                .id("23")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 7))
                .pieceId("knight")
                .orValidators(chessMovementFactory.createKnightMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createRookB2() {
        return Piece.builder()
                .id("24")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 1))
                .pieceId("rook")
                .orValidators(chessMovementFactory.createRookMovements())
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB1() {
        return Piece.builder()
                .id("25")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 1))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB2() {
        return Piece.builder()
                .id("26")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 2))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB3() {
        return Piece.builder()
                .id("27")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 3))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB4() {
        return Piece.builder()
                .id("28")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 4))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB5() {
        return Piece.builder()
                .id("29")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 5))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB6() {
        return Piece.builder()
                .id("30")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 6))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB7() {
        return Piece.builder()
                .id("31")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 7))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }

    private Piece createPawnB8() {
        return Piece.builder()
                .id("32")
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 8))
                .pieceId("pawn")
                .orValidators(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .andValidators(chessMovementFactory.createDefaultValidators())
                .build();
    }
}