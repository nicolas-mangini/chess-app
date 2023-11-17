package edu.austral.dissis.common.validator.game;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;

import java.util.List;

public class CannotMoveValidator implements GameOverValidator {
    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager) {
        Colour teamColour = movement.getFrom().getPiece().getColour();
        Colour enemyColour = teamColour.equals(Colour.WHITE) ? Colour.BLACK : Colour.WHITE;

        if (canEnemyEat(board, enemyColour, gameManager)) {
            return new WinResult<>(false, null);
        }
        return new WinResult<>(true, teamColour);
    }

    private boolean canEnemyEat(Board board, Colour enemyColour, GameManager gameManager) {
        List<Tile> enemyTiles = board.getTiles().stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getColour().equals(enemyColour))
                .toList();

        return enemyTiles.stream().anyMatch(enemyTile ->
                board.getTiles().stream().anyMatch(anyTile -> {
                    Movement newMovement = new Movement(enemyTile, anyTile);
                    Piece pieceToMove = enemyTile.getPiece();
                    return pieceToMove.getPieceValidator().isValid(newMovement, board, gameManager);
                })
        );
    }
}
