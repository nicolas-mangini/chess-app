package edu.austral.dissis.checkers.game;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.chess.game.PromoteUtils;
import edu.austral.dissis.common.game.*;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.util.MovementResult;
import edu.austral.dissis.common.util.Result;
import edu.austral.dissis.common.validator.piece.PieceType;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CheckersGameMover implements GameMover {
    @Override
    public Result<?, ?> tryMovement(Movement movement, GameManager gameManager) {
        Optional<Piece> pieceToMove = gameManager
                .getGame()
                .getBoard()
                .getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY());

        if (!validateMovement(pieceToMove, movement, gameManager))
            return new MovementResult<>(gameManager, "Invalid movement!");

        GameManager movedGameManager = makeMovement(movement, gameManager);

        Result<Boolean, Colour> isGameOver = movedGameManager.isGameOver(movement);
        if (isGameOver.getKey()) {
            return isGameOver;
        }

        return new MovementResult<>(movedGameManager, null);
    }

    private GameManager makeMovement(Movement movement, GameManager gameManager) {
        Board newBoard = new SimpleBoard(gameManager.getGame().getBoard());
        Piece pieceToMove = newBoard.getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY()).get();

        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        if (PromoteUtils.canPromote(pieceToMove, movement.getTo())) {
            newBoard = PromoteUtils.promoteCheckers(pieceToMove, PieceType.QUEEN, movement.getTo(), newBoard);
        }

        if (CheckersUtil.isEatMovement(movement)) {
            Tile middle = middleMovementTile(movement, newBoard);
            newBoard.setPieceAtTile(null, middle);

            List<Movement> newHistory = new ArrayList<>(gameManager.getGame().getHistory());
            newHistory.add(movement);

            Tile newPieceTile = newBoard.getTile(movement.getTo().getX(), movement.getTo().getY()).get();
            if (canEatAgain(newPieceTile, newBoard, gameManager, newHistory)) {
                return new GameManager(
                        new Game(gameManager.getGame(), newBoard, newHistory),
                        this,
                        gameManager.getTurnChanger() // current turn
                );
            }
        }

        List<Movement> newHistory = new ArrayList<>(gameManager.getGame().getHistory());
        newHistory.add(movement);

        return new GameManager(
                new Game(gameManager.getGame(), newBoard, newHistory),
                this,
                gameManager.getTurnChanger().nextTurn() // next turn
        );
    }

    private boolean validateMovement(Optional<Piece> piece, Movement movement, GameManager gameManager) {
        return gameManager.getGame()
                .getGameValidators()
                .isValid(movement, gameManager.getGame().getBoard(), gameManager)
                &&
                piece.get().
                        getPieceValidator()
                        .isValid(movement, gameManager.getGame().getBoard(), gameManager);
    }

    private Tile middleMovementTile(Movement movement, Board board) {
        return board.getTile(
                (movement.getFrom().getX() + movement.getTo().getX()) / 2,
                (movement.getFrom().getY() + movement.getTo().getY()) / 2
        ).get();
    }

    private boolean canEatAgain(Tile pieceTile, Board board, GameManager currentGameManager, List<Movement> newHistory) {
        List<Tile> possibleEatTiles = CheckersUtil.possibleEatTiles(pieceTile, board);

        for (Tile possibleTile : possibleEatTiles) {
            Movement consecutiveMovement = new Movement(pieceTile, possibleTile);
            // updated game manager with new history
            GameManager consecutiveGameManager = new GameManager(
                    new Game(currentGameManager.getGame(), newHistory),
                    this,
                    currentGameManager.getTurnChanger()
            );

            if (validateMovement(Optional.of(pieceTile.getPiece()), consecutiveMovement, consecutiveGameManager)) {
                return true;
            }
        }
        return false;
    }
}
