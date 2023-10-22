package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.util.impl.MoveResult;
import edu.austral.dissis.chess.validator.MoveValidator;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GameMover {
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
        Piece pieceToMove = new Piece(movement.getFrom().getPiece());
        history.add(movement);
        board = board.setPieceAtTile(pieceToMove, movement.getTo()).get();
        board = board.setPieceAtTile(null, movement.getFrom()).get();
        return new Game(game.getWhitePlayer(), game.getBlackPlayer(), board, history);
    }

    private boolean validateMovement(List<MoveValidator> orValidators, List<MoveValidator> andValidators, Movement movement, Game game) {
        return orValidators.stream()
                .anyMatch(moveValidator -> moveValidator.isValid(movement, game.getBoard()))
                &&
                andValidators.stream()
                        .allMatch(moveValidator -> moveValidator.isValid(movement, game.getBoard()));
    }
}
