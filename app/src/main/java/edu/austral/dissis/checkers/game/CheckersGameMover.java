package edu.austral.dissis.checkers.game;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.GameMover;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.MovementResult;
import edu.austral.dissis.common.validator.piece.PieceType;
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

        if (isEatMovement(movement)) {
            Tile middle = middleMovementTile(movement, newBoard);
            newBoard.setPieceAtTile(null, middle);

            List<Movement> newHistory = new ArrayList<>(gameManager.getGame().getHistory());
            newHistory.add(movement);

            Tile newPieceTile = newBoard.getTile(movement.getTo().getX(), movement.getTo().getY()).get();
            if (canEatAgain(newPieceTile, newBoard, gameManager, newHistory)) {
                return new GameManager(
                        new Game(gameManager.getGame(), newBoard, newHistory),
                        this,
                        gameManager.getTurnChanger() //current turn
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
                        getPieceValidators()
                        .isValid(movement, gameManager.getGame().getBoard(), gameManager);
    }


    private List<Tile> possibleEatTiles(Tile fromTile, Board board) {
        if (fromTile.getPiece().getPieceType() == PieceType.PAWN) {
            // possible eat tiles are tile within 2 increments -> max 4 diagonal tiles,
            // also, there should be a piece in middle to eat
            return board.getTiles().stream()
                    .filter(tile -> Math.abs(tile.getX() - fromTile.getX()) == 2)
                    .filter(tile -> Math.abs(tile.getY() - fromTile.getY()) == 2)
                    .filter(tile -> tile.getPiece() == null)
                    .filter(tile -> {
                        Tile middleTile = board.getTile(
                                (tile.getX() + fromTile.getX()) / 2,
                                (tile.getY() + fromTile.getY()) / 2
                        ).get();
                        return middleTile.getPiece() != null;
                    })
                    .toList();
        }
        return List.of();
    }

    private boolean isEatMovement(Movement movement) {
        if (movement.getFrom().getPiece().getPieceType() == PieceType.PAWN) {
            return Math.abs(movement.getFrom().getX() - movement.getTo().getX()) == 2;
        }
        return false;
    }

    private Tile middleMovementTile(Movement movement, Board board) {
        if (movement.getFrom().getPiece().getPieceType() == PieceType.PAWN) {
            return board.getTile(
                    (movement.getFrom().getX() + movement.getTo().getX()) / 2,
                    (movement.getFrom().getY() + movement.getTo().getY()) / 2
            ).get();
        }
        return null;
    }

    private boolean canEatAgain(Tile pieceTile, Board board, GameManager currentGameManager, List<Movement> newHistory) {
        List<Tile> possibleEatTiles = possibleEatTiles(pieceTile, board);

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