package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.common.validator.piece.PieceType;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.builder.PieceBuilder;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class ClassicChessPieceBuilder implements PieceBuilder {
    private static int ID;

    @Override
    public List<Piece> buildAll() {
        return Stream.concat(buildWhitePieces().stream(), buildBlackPieces().stream())
                .toList();
    }

    @Override
    public List<Piece> buildWhitePieces() {
        List<Piece> pieces = List.of(buildRookW1(),
                buildKnightW1(),
                buildBishopW1(),
                buildKingW1(),
                buildQueenW1(),
                buildBishopW2(),
                buildKnightW2(),
                buildRookW2());

        return Stream.concat(pieces.stream(), buildAllPawns(Colour.WHITE).stream()).toList();
    }

    @Override
    public List<Piece> buildBlackPieces() {
        List<Piece> pieces = List.of(
                buildRookB1(),
                buildKnightB1(),
                buildBishopB1(),
                buildKingB1(),
                buildQueenB1(),
                buildBishopB2(),
                buildKnightB2(),
                buildRookB2());

        return Stream.concat(pieces.stream(), buildAllPawns(Colour.BLACK).stream()).toList();
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

    private List<Piece> buildAllPawns(Colour colour) {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = new ArrayList<>();
        if (colour == Colour.BLACK) {
            initialPositions = blackPawnInitialPositions();
        } else if (colour == Colour.WHITE) {
            initialPositions = whitePawnInitialPositions();
        }
        for (int i = 0; i < 8; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = buildPawn(colour, initialPosition);
            pawns.add(piece);
        }
        return pawns;
    }

    private Piece buildPawn(Colour colour, Tile initialPosition) {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(colour)
                .initialPosition(initialPosition)
                .pieceType(PieceType.PAWN)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.PAWN, colour))
                .build();
    }

    private Piece buildRookW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 1))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.ROOK, Colour.WHITE))
                .build();
    }

    private Piece buildKnightW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 2))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.KNIGHT, Colour.WHITE))
                .build();
    }

    private Piece buildBishopW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 3))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.BISHOP, Colour.WHITE))
                .build();
    }

    private Piece buildQueenW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 4))
                .pieceType(PieceType.QUEEN)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.QUEEN, Colour.WHITE))
                .build();
    }

    private Piece buildKingW1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 5))
                .pieceType(PieceType.KING)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.KING, Colour.WHITE))
                .build();
    }

    private Piece buildBishopW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 6))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.BISHOP, Colour.WHITE))
                .build();
    }

    private Piece buildKnightW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 7))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.KNIGHT, Colour.WHITE))
                .build();
    }

    private Piece buildRookW2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.WHITE)
                .initialPosition(new Tile(8, 8))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.ROOK, Colour.WHITE))
                .build();
    }

    private Piece buildRookB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 8))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.ROOK, Colour.WHITE))
                .build();
    }

    private Piece buildKnightB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 2))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.KNIGHT, Colour.BLACK))
                .build();
    }

    private Piece buildBishopB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 3))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.BISHOP, Colour.BLACK))
                .build();
    }

    private Piece buildQueenB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 4))
                .pieceType(PieceType.QUEEN)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.QUEEN, Colour.BLACK))
                .build();
    }

    private Piece buildKingB1() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 5))
                .pieceType(PieceType.KING)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.KING, Colour.BLACK))
                .build();
    }

    private Piece buildBishopB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 6))
                .pieceType(PieceType.BISHOP)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.BISHOP, Colour.BLACK))
                .build();
    }

    private Piece buildKnightB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 7))
                .pieceType(PieceType.KNIGHT)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.KNIGHT, Colour.BLACK))
                .build();
    }

    private Piece buildRookB2() {
        return Piece.builder()
                .id(String.valueOf(ID++))
                .colour(Colour.BLACK)
                .initialPosition(new Tile(1, 1))
                .pieceType(PieceType.ROOK)
                .pieceValidator(ClassicChessMovementBuilder.buildMovements(PieceType.ROOK, Colour.BLACK))
                .build();
    }
}
