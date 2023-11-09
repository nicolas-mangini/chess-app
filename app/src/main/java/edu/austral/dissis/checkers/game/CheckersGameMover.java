package edu.austral.dissis.checkers.game;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.GameMover;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.turn.TurnChanger;
import edu.austral.dissis.common.util.MovementResult;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CheckersGameMover implements GameMover {
    @Override
    public MovementResult<GameManager, String> tryMovement(Movement movement, GameManager gameManager) {
        Optional<Piece> pieceToMove = gameManager
                .getGame()
                .getBoard()
                .getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY());

        if (!validateMovement(pieceToMove, movement, gameManager))
            return new MovementResult<>(gameManager, "Invalid movement!");

        Game movedGame = makeMovement(movement, gameManager.getGame());
        TurnChanger nextTurn = gameManager.getTurnChanger().nextTurn();
        return new MovementResult<>(new GameManager(movedGame, this, nextTurn), null);
    }

    private Game makeMovement(Movement movement, Game game) {
        SimpleBoard newBoard = new SimpleBoard(game.getBoard());
        Piece pieceToMove = newBoard.getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY()).get();

        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        //if increments are less than 2, then not eating middle piece
        if (Math.abs(movement.getFrom().getX() - movement.getTo().getX()) == 2) {
            //middle tile (checkers always eat in diagonal)
            Tile middle = newBoard.getTile(
                    (movement.getFrom().getX() + movement.getTo().getX()) / 2,
                    (movement.getFrom().getY() + movement.getTo().getY()) / 2
            ).get();
            newBoard.setPieceAtTile(null, middle);
        }

        List<Movement> newHistory = new ArrayList<>(game.getHistory());
        newHistory.add(movement);

        return new Game(game.getPlayer1(), game.getPlayer2(), newBoard, game.getGameValidators(), game.getGameOverValidators(), newHistory);
    }

    private boolean validateMovement(Optional<Piece> piece, Movement movement, GameManager gameManager) {
        return gameManager.getGame()
                .getGameValidators()
                .isValid(movement, gameManager.getGame().getBoard(), gameManager)
                &&
                piece.get().
                        getPieceValidators()
                        .isValid(movement, gameManager.getGame().getBoard(), gameManager);
    }
}