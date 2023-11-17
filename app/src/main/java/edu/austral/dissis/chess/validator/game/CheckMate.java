package edu.austral.dissis.chess.validator.game;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;

import java.util.List;

public class CheckMate implements GameOverValidator {
    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager) {
        Colour teamColour = movement.getFrom().getPiece().getColour();
        Colour enemyColour = teamColour.equals(Colour.WHITE) ? Colour.BLACK : Colour.WHITE;

        boolean canEnemyMove = checkAllEnemyMovements(board, gameManager, enemyColour);
        if (!canEnemyMove) return new WinResult<>(true, teamColour);
        else return new WinResult<>(false, null);
    }

    /**
     * Checks if any piece of the given enemy color can make a valid movement.
     *
     * @return True if any piece of the enemy color can make a valid move, false otherwise.
     */
    private boolean checkAllEnemyMovements(Board board, GameManager gameManager,
                                           Colour enemyColour) {

        List<Tile> enemyTiles = board.getTiles()
                .stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getColour().equals(enemyColour))
                .toList();

        for (Tile enemyTile : enemyTiles) {
            Piece enemyPiece = enemyTile.getPiece();
            for (Tile emptyTile : board.getTiles()) {
                Movement movement = new Movement(enemyTile, emptyTile);
                if (validateMovement(movement, board, gameManager, enemyPiece)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean validateMovement(Movement movement, Board board, GameManager gameManager,
                                     Piece enemyPiece) {
        return enemyPiece.getPieceValidator().isValid(movement, board, gameManager);
    }
}
