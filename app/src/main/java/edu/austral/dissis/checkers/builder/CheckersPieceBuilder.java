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
    private final CheckersMovementBuilder checkersMovementBuilder;
    private static int ID;

    public CheckersPieceBuilder() {
        this.checkersMovementBuilder = new CheckersMovementBuilder();
    }

    @Override
    public List<Piece> buildAll() {
        return Stream.concat(createWhitePieces().stream(), createBlackPieces().stream())
                .toList();
    }

    private List<Piece> createWhitePieces() {
        return createWhitePawns();
    }

    private List<Piece> createBlackPieces() {
        return createBlackPawns();
    }

    private List<Tile> whiteInitialPositions() {
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

    private List<Tile> blackInitialPositions() {
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

    private List<Piece> createBlackPawns() {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = whiteInitialPositions();
        for (int i = 0; i < 12; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = createPawn(Colour.BLACK, initialPosition);
            pawns.add(piece);
        }
        return pawns;
    }

    private List<Piece> createWhitePawns() {
        List<Piece> pawns = new ArrayList<>();
        List<Tile> initialPositions = blackInitialPositions();
        for (int i = 0; i < 12; i++) {
            Tile initialPosition = initialPositions.get(i);
            Piece piece = createPawn(Colour.WHITE, initialPosition);
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
                .pieceValidator(checkersMovementBuilder.createPawnMovements(colour))
                .build();
    }
}
