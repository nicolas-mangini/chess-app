/*
package edu.austral.dissis.chess.test;

import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.util.impl.MovementResult;
import edu.austral.dissis.chess.validator.MovementValidator;
import edu.austral.dissis.chess.validator.impl.CompoundAndValidator;
import edu.austral.dissis.chess.validator.impl.move.DirectionValidator;
import edu.austral.dissis.chess.validator.impl.move.EatValidator;
import edu.austral.dissis.chess.validator.impl.move.PathClearValidator;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(8, 8);
        Game game = new Game(Colour.WHITE, Colour.BLACK, board, new ArrayList<>());
        GameManager gameManager = new GameManager(game, new GameMover(), new TurnHandler(Colour.WHITE));

        Piece rook = createRook();
        gameManager.getGame().getBoard().setPieceAtTile(rook, rook.getInitialPosition());

        System.out.println(gameManager.getGame().getBoard().display());

        MovementResult<GameManager, String> result1 = gameManager.getGameMover().tryMovement(new Movement(new Tile(1, 1), new Tile(5, 1)), gameManager);
        if (result1.getValue().isPresent()) System.out.println("error: " + result1.getValue().get());
        else
            System.out.println(result1.getKey().getGame().getBoard().display());
        MovementResult<GameManager, String> result2 = gameManager.getGameMover().tryMovement(new Movement(new Tile(5, 1), new Tile(5, 5)), gameManager);
        if (result2.getValue().isPresent()) System.out.println("error: " + result2.getValue().get());
        else
            System.out.println(result2.getKey().getGame().getBoard().display());
    }

    private static Piece createRook() {
        return Piece.builder()
                .id("1")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 1, null))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(new ArrayList<>())
                .build();
    }

    private static List<MovementValidator> createRookOrValidators() {
        List<MovementValidator> rookOrValidators = new ArrayList<>();

        CompoundAndValidator compositeValidator1 = new CompoundAndValidator(List.of(

                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new EatValidator(false)
        ));

        CompoundAndValidator compositeValidator2 = new CompoundAndValidator(List.of(
                new DirectionValidator(-1, 0),
                new PathClearValidator(-1, 0)
        ));

        CompoundAndValidator compositeValidator3 = new CompoundAndValidator(List.of(
                new DirectionValidator(0, 1),
                new PathClearValidator(0, 1),
                new EatValidator()
        ));

        CompoundAndValidator compositeValidator4 = new CompoundAndValidator(List.of(
                new DirectionValidator(0, -1),
                new PathClearValidator(0, -1)
        ));
        rookOrValidators.add(compositeValidator1);
        rookOrValidators.add(compositeValidator2);
        rookOrValidators.add(compositeValidator3);
        rookOrValidators.add(compositeValidator4);

        return rookOrValidators;
    }
}
*/
