package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.util.impl.MoveResult;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
public class GameMover {
    public MoveResult<GameManager, String> tryMovement(Movement movement, GameManager gameManager) {
        Piece pieceToMove = movement.getFrom().getPiece();
        if (pieceToMove == null)
            return new MoveResult<>(gameManager, "No piece to move");

        Colour currentColourTurn = gameManager.getTurnHandler().getCurrent();
        if (pieceToMove.getColour() != currentColourTurn)
            return new MoveResult<>(gameManager, "Its not your turn");

        if (!validateMovement(pieceToMove.getOrValidators(), pieceToMove.getAndValidators(), movement, gameManager))
            return new MoveResult<>(gameManager, "Invalid movement");

        Game gameMoved = makeMovement(movement, gameManager.getGame());
        TurnHandler nextTurn = gameManager.getTurnHandler().nextTurn();
        return new MoveResult<>(new GameManager(gameMoved, this, nextTurn), null);
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

    private boolean validateMovement(List<MovementValidator> orValidators, List<MovementValidator> andValidators, Movement movement, GameManager gameManager) {
        return orValidators.stream()
                .anyMatch(moveValidator -> moveValidator.isValid(movement, gameManager.getGame().getBoard()))
                &&
                andValidators.stream()
                        .allMatch(moveValidator -> moveValidator.isValid(movement, gameManager.getGame().getBoard()));
    }
}
