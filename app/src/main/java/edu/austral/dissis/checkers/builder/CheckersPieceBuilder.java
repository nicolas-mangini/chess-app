package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.builder.PieceBuilder;
import edu.austral.dissis.common.validator.piece.PieceType;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Tile;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class CheckersPieceBuilder implements PieceBuilder {
    private static int ID;

    @Override
    public List<Piece> buildAll() {
        return Stream.concat(buildWhitePieces().stream(), buildBlackPieces().stream())
                .toList();
    }

    @Override
    public List<Piece> buildWhitePieces() {
        return buildWhitePawns();
    }

    @Override
    public List<Piece> buildBlackPieces() {
        return buildBlackPawns();
    }

    private List<Tile> whitePawnInitialPositions() {
        return List.of(
                new Tile(1, 2),
                new Tile(1, 4),
                new Tile(1, 6),
                new Tile(1, 8),

                new Tile(2, 1),
                new Tile(2, 3),
                new Tile(2, 5),
                new Tile(2, 7),

                new Tile(3, 2),
                new Tile(3, 4),
                new Tile(3, 6),
                new Tile(3, 8)
        );
    }

    private List<Tile> blackPawnInitialPositions() {
        return List.of(
                new Tile(8, 1),
                new Tile(8, 3),
                new Tile(8, 5),
                new Tile(8, 7),

                new Tile(7, 2),
                new Tile(7, 4),
                new Tile(7, 6),
                new Tile(7, 8),

                new Tile(6, 1),
                new Tile(6, 3),
                new Tile(6, 5),
                new Tile(6, 7)
        );
    }

    private List<Piece> buildBlackPawns() {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = whitePawnInitialPositions();
        for (int i = 0; i < 12; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = buildPawn(Colour.BLACK, initialPosition);
            pawns.add(piece);
        }
        return pawns;
    }

    private List<Piece> buildWhitePawns() {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = blackPawnInitialPositions();
        for (int i = 0; i < 12; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = buildPawn(Colour.WHITE, initialPosition);
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
                .pieceValidator(CheckersMovementBuilder.buildMovements(PieceType.PAWN, colour))
                .build();
    }
}
