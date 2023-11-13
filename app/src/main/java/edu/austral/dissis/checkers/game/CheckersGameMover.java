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

        GameManager movedGameManager = makeMovement(movement, gameManager);
        return new MovementResult<>(movedGameManager, null);
    }

    private GameManager makeMovement(Movement movement, GameManager gameManager) {
        SimpleBoard newBoard = new SimpleBoard(gameManager.getGame().getBoard());
        Piece pieceToMove = newBoard.getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY()).get();

        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        //CHECK IF MOVEMENT IS EATING then EAT MIDDLE PIECE
        //if increments are less than 2, then not eating middle piece
        if (Math.abs(movement.getFrom().getX() - movement.getTo().getX()) == 2) {
            //middle tile (checkers always eat in diagonal)
            Tile middle = newBoard.getTile(
                    (movement.getFrom().getX() + movement.getTo().getX()) / 2,
                    (movement.getFrom().getY() + movement.getTo().getY()) / 2
            ).get();
            newBoard.setPieceAtTile(null, middle);

            List<Movement> newHistory = new ArrayList<>(gameManager.getGame().getHistory());
            newHistory.add(movement);

            //CAN EAT AGAIN?
            // before return, check if can eat again
            Tile newPieceTile = newBoard.getTile(movement.getTo().getX(), movement.getTo().getY()).get();
            // possible eat tiles are tile within 2 increments, just 4 diagonal tiles, there should be a piece in middle to eat
            List<Tile> possibleEatTiles = newBoard.getTiles().stream()
                    .filter(tile -> Math.abs(tile.getX() - newPieceTile.getX()) == 2)
                    .filter(tile -> Math.abs(tile.getY() - newPieceTile.getY()) == 2)
                    .filter(tile -> tile.getPiece() == null)
/*                    .filter(tile -> {
                        Tile middleTile = newBoard.getTile(
                                (movement.getFrom().getX() + movement.getTo().getX()) / 2,
                                (movement.getFrom().getY() + movement.getTo().getY()) / 2
                        ).get();
                        return middleTile.getPiece() != null;
                    })*/
                    .toList();

            for (Tile possibleTile : possibleEatTiles) {
                Movement consecutiveMovement = new Movement(newPieceTile, possibleTile);
                // updated game manager with new history
                GameManager consecutiveGameManager = new GameManager(
                        new Game(
                                gameManager.getGame().getPlayer1(),
                                gameManager.getGame().getPlayer2(),
                                newBoard,
                                gameManager.getGame().getGameValidators(),
                                gameManager.getGame().getGameOverValidators(),
                                newHistory),
                        this,
                        gameManager.getTurnChanger()
                );
                if (validateMovement(Optional.of(pieceToMove), consecutiveMovement, consecutiveGameManager)) {
                    // if can eat again, then return the same gameManager with the new movement
                    return new GameManager(
                            new Game(
                                    gameManager.getGame().getPlayer1(),
                                    gameManager.getGame().getPlayer2(),
                                    newBoard, gameManager.getGame().getGameValidators(),
                                    gameManager.getGame().getGameOverValidators(),
                                    newHistory),
                            this,
                            gameManager.getTurnChanger()
                    );
                }
            }
        }

        List<Movement> newHistory = new ArrayList<>(gameManager.getGame().getHistory());
        newHistory.add(movement);
        return new GameManager(
                new Game(
                        gameManager.getGame().getPlayer1(),
                        gameManager.getGame().getPlayer2(),
                        newBoard, gameManager.getGame().getGameValidators(),
                        gameManager.getGame().getGameOverValidators(),
                        newHistory),
                this,
                gameManager.getTurnChanger().nextTurn()
        );
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