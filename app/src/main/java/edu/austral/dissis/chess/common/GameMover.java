package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.util.MovementResult;
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

        Colour currentColourTurn = gameManager.getTurnChanger().getCurrentTurn();
        if (pieceToMove.get().getColour() != currentColourTurn)
            return new MovementResult<>(gameManager, "Its not your turn!");

        if (!validateMovement(pieceToMove.get(), movement, gameManager))
            return new MovementResult<>(gameManager, "Invalid movement!");

        Game movedGame = makeMovement(movement, gameManager.getGame());
        TwoPlayersTurnChanger nextTurn = gameManager.getTurnChanger().nextTurn();
        return new MovementResult<>(new GameManager(movedGame, this, nextTurn), null);
    }

    private Game makeMovement(Movement movement, Game game) {
        Board newBoard = new Board(game.getBoard());
        Piece pieceToMove = newBoard.getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY()).get();

        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        List<Movement> newHistory = new ArrayList<>(game.getHistory());
        newHistory.add(movement);

        return new Game(game.getPlayer1(), game.getPlayer2(), newBoard, game.getGameOverValidator(), newHistory);
    }

    private boolean validateMovement(Piece piece, Movement movement, GameManager gameManager) {
        return piece.getPieceMover().isValid(movement, gameManager.getGame().getBoard(), gameManager.getGame().getHistory());
    }
}