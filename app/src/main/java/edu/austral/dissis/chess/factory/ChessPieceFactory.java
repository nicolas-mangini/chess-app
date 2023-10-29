package edu.austral.dissis.chess.factory;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Piece;
import edu.austral.dissis.chess.common.Tile;

import java.util.List;

public class ChessPieceFactory {
    private final ChessMovementFactory chessMovementFactory;
    private static int ID;

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
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 1))
                .pieceId("rook")
                .pieceMover(chessMovementFactory.createRookMovements())
                .build();
    }

    private Piece createKnightW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 2))
                .pieceId("knight")
                .pieceMover(chessMovementFactory.createKnightMovements())
                .build();
    }

    private Piece createBishopW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 3))
                .pieceId("bishop")
                .pieceMover(chessMovementFactory.createBishopMovements())
                .build();
    }

    private Piece createQueenW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 4))
                .pieceId("queen")
                .pieceMover(chessMovementFactory.createQueenMovements())
                .build();
    }

    private Piece createKingW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 5))
                .pieceId("king")
                .pieceMover(chessMovementFactory.createKingMovements())
                .build();
    }

    private Piece createBishopW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 6))
                .pieceId("bishop")
                .pieceMover(chessMovementFactory.createBishopMovements())
                .build();
    }

    private Piece createKnightW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 7))
                .pieceId("knight")
                .pieceMover(chessMovementFactory.createKnightMovements())
                .build();
    }

    private Piece createRookW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 8))
                .pieceId("rook")
                .pieceMover(chessMovementFactory.createRookMovements())
                .build();
    }

    private Piece createPawnW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 1))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 2))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW3() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 3))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW4() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 4))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW5() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 5))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW6() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 6))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW7() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 7))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createPawnW8() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(7, 8))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.WHITE))
                .build();
    }

    private Piece createRookB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 8))
                .pieceId("rook")
                .pieceMover(chessMovementFactory.createRookMovements())
                .build();
    }

    private Piece createKnightB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 2))
                .pieceId("knight")
                .pieceMover(chessMovementFactory.createKnightMovements())
                .build();
    }

    private Piece createBishopB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 3))
                .pieceId("bishop")
                .pieceMover(chessMovementFactory.createBishopMovements())
                .build();
    }

    private Piece createQueenB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 4))
                .pieceId("queen")
                .pieceMover(chessMovementFactory.createQueenMovements())
                .build();
    }

    private Piece createKingB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 5))
                .pieceId("king")
                .pieceMover(chessMovementFactory.createKingMovements())
                .build();
    }

    private Piece createBishopB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 6))
                .pieceId("bishop")
                .pieceMover(chessMovementFactory.createBishopMovements())
                .build();
    }

    private Piece createKnightB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 7))
                .pieceId("knight")
                .pieceMover(chessMovementFactory.createKnightMovements())
                .build();
    }

    private Piece createRookB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 1))
                .pieceId("rook")
                .pieceMover(chessMovementFactory.createRookMovements())
                .build();
    }

    private Piece createPawnB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 1))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 2))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB3() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 3))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB4() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 4))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB5() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 5))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB6() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 6))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB7() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 7))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }

    private Piece createPawnB8() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(2, 8))
                .pieceId("pawn")
                .pieceMover(chessMovementFactory.createPawnMovements(Colour.BLACK))
                .build();
    }
}