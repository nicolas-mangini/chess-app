package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.common.validator.piece.PieceType;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.builder.PieceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ChessPieceBuilder implements PieceBuilder {
    private static int ID;

    @Override
    public List<Piece> buildAll() {
        return Stream.concat(createWhitePieces().stream(), createBlackPieces().stream())
                .toList();
    }

    @Override
    public List<Piece> createWhitePieces() {
        List<Piece> pieces = List.of(createRookW1(),
                createKnightW1(),
                createBishopW1(),
                createKingW1(),
                createQueenW1(),
                createBishopW2(),
                createKnightW2(),
                createRookW2());

        return Stream.concat(pieces.stream(), createPawns(Colour.WHITE).stream()).toList();
    }

    @Override
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

        return Stream.concat(pieces.stream(), createPawns(Colour.BLACK).stream()).toList();
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

    private List<Piece> createPawns(Colour colour) {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = new ArrayList<>();
        if (colour == Colour.BLACK) {
            initialPositions = blackPawnInitialPositions();
        } else if (colour == Colour.WHITE) {
            initialPositions = whitePawnInitialPositions();
        }
        for (int i = 0; i < 8; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = createPawn(colour, initialPosition);
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
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.PAWN, colour))
                .build();
    }

    private Piece createRookW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 1))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.ROOK, Colour.WHITE))
                .build();
    }

    private Piece createKnightW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 2))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.KNIGHT, Colour.WHITE))
                .build();
    }

    private Piece createBishopW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 3))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.BISHOP, Colour.WHITE))
                .build();
    }

    private Piece createQueenW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 4))
                .pieceType(PieceType.QUEEN)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.QUEEN, Colour.WHITE))
                .build();
    }

    private Piece createKingW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 5))
                .pieceType(PieceType.KING)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.KING, Colour.WHITE))
                .build();
    }

    private Piece createBishopW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 6))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.BISHOP, Colour.WHITE))
                .build();
    }

    private Piece createKnightW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 7))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.KNIGHT, Colour.WHITE))
                .build();
    }

    private Piece createRookW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 8))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.ROOK, Colour.WHITE))
                .build();
    }

    private Piece createRookB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 8))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.ROOK, Colour.WHITE))
                .build();
    }

    private Piece createKnightB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 2))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.KNIGHT, Colour.BLACK))
                .build();
    }

    private Piece createBishopB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 3))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.BISHOP, Colour.BLACK))
                .build();
    }

    private Piece createQueenB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 4))
                .pieceType(PieceType.QUEEN)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.QUEEN, Colour.BLACK))
                .build();
    }

    private Piece createKingB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 5))
                .pieceType(PieceType.KING)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.KING, Colour.BLACK))
                .build();
    }

    private Piece createBishopB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 6))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.BISHOP, Colour.BLACK))
                .build();
    }

    private Piece createKnightB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 7))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.KNIGHT, Colour.BLACK))
                .build();
    }

    private Piece createRookB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 1))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ChessMovementBuilder.createMovements(PieceType.ROOK, Colour.BLACK))
                .build();
    }
}
