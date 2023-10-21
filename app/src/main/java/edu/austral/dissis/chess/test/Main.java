package edu.austral.dissis.chess.test;

import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.util.impl.MoveResult;
import edu.austral.dissis.chess.validator.MoveValidator;
import edu.austral.dissis.chess.validator.impl.EatValidator;
import edu.austral.dissis.chess.validator.impl.DirectionValidator;
import edu.austral.dissis.chess.validator.impl.PathClearValidator;
import edu.austral.dissis.chess.validator.impl.WithinBoundsValidator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        Board board = new Board(8, 8);
        Game game = new Game(PlayerColour.WHITE, PlayerColour.BLACK, board, new ArrayList<>());
        GameMover gameMover = new GameMover();
        Board board2 = game.getBoard().setPieceInSquare(createDefaultPieces().get(0)).get();
        System.out.println(board2.print());
        MoveResult<Game, String> result1 = gameMover.move(new Movement(board2.getTile(3, 3).get(), board2.getTile(4, 3).get()), game);
        if (result1.getValue().isPresent()) System.out.println("error");
        else
            System.out.println(result1.getKey().getBoard().print());
    }

    public static List<Piece> createDefaultPieces() {
        //rook
        List<MoveValidator> andValidators = Arrays.asList(
                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new EatValidator());

        List<MoveValidator> andValidators2 = List.of(
                new DirectionValidator(-1, 0),
                new PathClearValidator(-1, 0));

        List<MoveValidator> andValidators3 = List.of(
                new DirectionValidator(0, 1),
                new PathClearValidator(0, 1),
                new EatValidator());

        List<MoveValidator> andValidators4 = List.of(
                new DirectionValidator(0, -1));

        List<List<MoveValidator>> compositeAndValidators = List.of(andValidators, andValidators2, andValidators3, andValidators4);


        //default
        List<MoveValidator> andValidators5 = List.of(
                new WithinBoundsValidator());


        Piece rook = Piece.builder()
                .id("1")
                .colour(PlayerColour.WHITE)
                .initialPosition(new Tile(3, 3, null))
                .pieceId("rook")
                .orValidators(compositeAndValidators)
                .andValidators(andValidators5)
                .build();

        return List.of(rook);
    }
}
