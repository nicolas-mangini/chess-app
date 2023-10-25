package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.util.impl.MovementResult;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class GameMover {
    public MovementResult<GameManager, String> tryMovement(Movement movement, GameManager gameManager) {
        Optional<Piece> pieceToMove = gameManager.getGame().getBoard().getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY());
        if (pieceToMove.isEmpty())
            return new MovementResult<>(gameManager, "No piece to move, from: %s, %s".formatted(movement.getFrom().getX(), movement.getFrom().getY()));

        Colour currentColourTurn = gameManager.getTurnManager().getCurrent();
        if (pieceToMove.get().getColour() != currentColourTurn)
            return new MovementResult<>(gameManager, "Its not your turn");

        if (!validateMovement(pieceToMove.get().getOrValidators(), pieceToMove.get().getAndValidators(), movement, gameManager))
            return new MovementResult<>(gameManager, "Invalid movement");

        Game gameMoved = makeMovement(movement, gameManager.getGame());
        TurnManager nextTurn = gameManager.getTurnManager().nextTurn();
        return new MovementResult<>(new GameManager(gameMoved, this, nextTurn), null);
    }

    private Game makeMovement(Movement movement, Game game) {
        Board board = new Board(game.getBoard());
        List<Movement> history = new ArrayList<>(game.getHistory());
        Piece pieceToMove = new Piece(board.getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY()).get());
        history.add(movement);
        board.setPieceAtTile(pieceToMove, movement.getTo());
        board.setPieceAtTile(null, movement.getFrom());
        return new Game(game.getWhitePlayer(), game.getBlackPlayer(), board, history);
    }

    private boolean validateMovement(List<MovementValidator> orValidators, List<MovementValidator> andValidators, Movement movement, GameManager gameManager) {
        return orValidators.stream()
                .anyMatch(moveValidator -> moveValidator.isValid(movement, gameManager.getGame().getBoard()))
                &&
                andValidators.stream()
                        .allMatch(moveValidator -> moveValidator.isValid(movement, gameManager.getGame().getBoard()));
    }
}
