package edu.austral.dissis.chess.test;

import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.util.impl.MoveResult;
import edu.austral.dissis.chess.validator.MoveValidator;
import edu.austral.dissis.chess.validator.impl.AndValidator;
import edu.austral.dissis.chess.validator.impl.move.DirectionValidator;
import edu.austral.dissis.chess.validator.impl.move.EatValidator;
import edu.austral.dissis.chess.validator.impl.move.PathClearValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(8, 8);
        Game game = new Game(PlayerColour.WHITE, PlayerColour.BLACK, board, new ArrayList<>());
        GameMover gameMover = new GameMover();
        Piece rook = createRook();
        Board board2 = game.getBoard().setPieceAtTile(rook, rook.getInitialPosition()).get();
        System.out.println(board2.display());
        MoveResult<Game, String> result1 = gameMover.move(new Movement(board2.getTile(1, 1).get(), board2.getTile(5, 1).get()), game);
        if (result1.getValue().isPresent()) System.out.println("error");
        else
            System.out.println(result1.getKey().getBoard().display());
    }

    private static Piece createRook() {
        return Piece.builder()
                .id("1")
                .colour(PlayerColour.WHITE)
                .initialPosition(new Tile(1, 1, null))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(new ArrayList<>())
                .build();
    }

    private static List<MoveValidator> createRookOrValidators() {
        List<MoveValidator> rookOrValidators = new ArrayList<>();

        AndValidator compositeValidator1 = new AndValidator(List.of(

                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new EatValidator()
        ));

        AndValidator compositeValidator2 = new AndValidator(List.of(
                new DirectionValidator(-1, 0),
                new PathClearValidator(-1, 0)
        ));

        AndValidator compositeValidator3 = new AndValidator(List.of(
                new DirectionValidator(0, 1),
                new PathClearValidator(0, 1),
                new EatValidator()
        ));

        AndValidator compositeValidator4 = new AndValidator(List.of(
                new DirectionValidator(0, -1),
                new PathClearValidator(0, -1)
        ));
        rookOrValidators.add(compositeValidator1);
        rookOrValidators.add(compositeValidator2);
        rookOrValidators.add(compositeValidator3);
        rookOrValidators.add(compositeValidator4);

        return rookOrValidators;
    }

/*    private List<MoveValidator> createDefaultAndValidators() {
        return List.of(new CheckValidator());
    }*/
}
