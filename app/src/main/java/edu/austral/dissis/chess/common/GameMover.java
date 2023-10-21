package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.util.impl.MoveResult;
import edu.austral.dissis.chess.validator.MoveValidator;

import java.util.ArrayList;
import java.util.List;

public class GameMover {
    public GameMover() {
    }

    public MoveResult<Game, String> move(Movement movement, Game game) {
        Piece pieceToMove = movement.getFrom().getPiece();
        if (pieceToMove == null) {
            return new MoveResult<>(game, "No piece to move");
        }
        if (!validateMovement(pieceToMove.getOrValidators(), pieceToMove.getAndValidators(), movement, game)) {
            return new MoveResult<>(game, "Invalid movement");
        }
        return new MoveResult<>(makeMovement(movement, game), null);
    }

    private Game makeMovement(Movement movement, Game game) {
        Board board = new Board(game.getBoard());
        List<Movement> history = new ArrayList<>(game.getHistory());
        history.add(movement);
        Tile from = movement.getFrom();
        Tile to = movement.getTo();
        board.getTiles().stream()
                .filter(square -> square.equals(to))
                .findFirst()
                .ifPresent(tile -> tile.setPiece(from.getPiece()));
        board.getTiles().stream()
                .filter(square -> square.equals(from))
                .findFirst()
                .ifPresent(tile -> tile.setPiece(null));
        return new Game(game.getWhitePlayer(), game.getBlackPlayer(), board, history);
    }

    private boolean validateMovement(List<List<MoveValidator>> orValidators, List<MoveValidator> andValidators, Movement movement, Game game) {
        //inside List<List<MoveValidator>> each element [List<MoveValidator>] is an AND validator and outside List<List<MoveValidator>> is an OR validator
/*
        return orValidators.stream()
                .anyMatch(compositeAndValidators -> andValidators.stream()
                        .allMatch(moveValidator -> moveValidator.isValid(movement, game.getBoard())))
                        &&
                andValidators
                        .stream()
                        .allMatch(moveValidator -> moveValidator.isValid(movement, game.getBoard()));*/

        //or validators
        for (List<MoveValidator> compositeAndValidators : orValidators) {
            boolean allValid = true;
            for (MoveValidator moveValidator : compositeAndValidators) {
                if (!moveValidator.isValid(movement, game.getBoard())) {
                    allValid = false;
                    break;
                }
            }
            if (allValid) {
                return true;
            }
        }
        return false;
    }
}
