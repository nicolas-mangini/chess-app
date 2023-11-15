/*
package edu.austral.dissis.chess.builder;

import edu.austral.dissis.common.validator.piece.PieceType;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.builder.PieceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChessPieceBuilder implements PieceBuilder {
    private final ChessMovementBuilder chessMovementBuilder;
    private static int ID;

    public ChessPieceBuilder() {
        this.chessMovementBuilder = new ChessMovementBuilder();
    }

    @Override
    public List<Piece> buildAll() {
        return Stream.concat(createWhitePieces().stream(), createBlackPieces().stream())
                .toList();
    }

    public List<Piece> createWhitePieces() {
        List<Piece> pieces = List.of(createRookW1(),
                createKnightW1(),
                createBishopW1(),
                createKingW1(),
                createQueenW1(),
                createBishopW2(),
                createKnightW2(),
                createRookW2());

        return Stream.concat(pieces.stream(), createWhitePawns().stream()).toList();
    }

    public List<Piece> createBlackPieces() {
        List<Piece> pieces = List.of(
                createRookB1(),
                createKnightB1(),
                createBishopB1(),
                createKingB1(),
                createQueenB1(),
                createBishopB2(),
                createKnightB2(),
                createRookB2());

        return Stream.concat(pieces.stream(), createBlackPawns().stream()).toList();
    }

    private List<Tile> whitePawnInitialPositions() {
        return List.of(
                new Tile(7, 1),
                new Tile(7, 2),
                new Tile(7, 3),
                new Tile(7, 4),
                new Tile(7, 5),
                new Tile(7, 6),
                new Tile(7, 7),
                new Tile(7, 8)
        );
    }

    private List<Tile> blackPawnInitialPositions() {
        return List.of(
                new Tile(2, 1),
                new Tile(2, 2),
                new Tile(2, 3),
                new Tile(2, 4),
                new Tile(2, 5),
                new Tile(2, 6),
                new Tile(2, 7),
                new Tile(2, 8)
        );
    }

    private List<Piece> createWhitePawns() {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = whitePawnInitialPositions();
        for (int i = 0; i < 8; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = createPawn(Colour.WHITE, initialPosition);
            pawns.add(piece);
        }
        return pawns;
    }

    private List<Piece> createBlackPawns() {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = blackPawnInitialPositions();
        for (int i = 0; i < 8; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = createPawn(Colour.BLACK, initialPosition);
            pawns.add(piece);
        }
        return pawns;
    }

    private Piece createPawn(Colour colour, Tile initialPosition) {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(colour)
                .initialPosition(initialPosition)
                .pieceType(PieceType.PAWN)
                .pieceValidators(chessMovementBuilder.createPawnMovements(colour))
                .build();
    }

    private Piece createRookW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 1))
                .pieceType(PieceType.ROOK)
                .pieceValidators(chessMovementBuilder.createRookMovements())
                .build();
    }

    private Piece createKnightW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 2))
                .pieceType(PieceType.KNIGHT)
                .pieceValidators(chessMovementBuilder.createKnightMovements())
                .build();
    }

    private Piece createBishopW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 3))
                .pieceType(PieceType.BISHOP)
                .pieceValidators(chessMovementBuilder.createBishopMovements())
                .build();
    }

    private Piece createQueenW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 4))
                .pieceType(PieceType.QUEEN)
                .pieceValidators(chessMovementBuilder.createQueenMovements())
                .build();
    }

    private Piece createKingW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 5))
                .pieceType(PieceType.KING)
                .pieceValidators(chessMovementBuilder.createKingMovements())
                .build();
    }

    private Piece createBishopW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 6))
                .pieceType(PieceType.BISHOP)
                .pieceValidators(chessMovementBuilder.createBishopMovements())
                .build();
    }

    private Piece createKnightW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 7))
                .pieceType(PieceType.KNIGHT)
                .pieceValidators(chessMovementBuilder.createKnightMovements())
                .build();
    }

    private Piece createRookW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 8))
                .pieceType(PieceType.ROOK)
                .pieceValidators(chessMovementBuilder.createRookMovements())
                .build();
    }

    private Piece createRookB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 8))
                .pieceType(PieceType.ROOK)
                .pieceValidators(chessMovementBuilder.createRookMovements())
                .build();
    }

    private Piece createKnightB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 2))
                .pieceType(PieceType.KNIGHT)
                .pieceValidators(chessMovementBuilder.createKnightMovements())
                .build();
    }

    private Piece createBishopB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 3))
                .pieceType(PieceType.BISHOP)
                .pieceValidators(chessMovementBuilder.createBishopMovements())
                .build();
    }

    private Piece createQueenB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 4))
                .pieceType(PieceType.QUEEN)
                .pieceValidators(chessMovementBuilder.createQueenMovements())
                .build();
    }

    private Piece createKingB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 5))
                .pieceType(PieceType.KING)
                .pieceValidators(chessMovementBuilder.createKingMovements())
                .build();
    }

    private Piece createBishopB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 6))
                .pieceType(PieceType.BISHOP)
                .pieceValidators(chessMovementBuilder.createBishopMovements())
                .build();
    }

    private Piece createKnightB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 7))
                .pieceType(PieceType.KNIGHT)
                .pieceValidators(chessMovementBuilder.createKnightMovements())
                .build();
    }

    private Piece createRookB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 1))
                .pieceType(PieceType.ROOK)
                .pieceValidators(chessMovementBuilder.createRookMovements())
                .build();
    }
}*/
