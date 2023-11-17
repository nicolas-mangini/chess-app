package edu.austral.dissis.checkers.validator.game;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;

import java.util.List;
import java.util.Objects;

public class CannotMoveValidator implements GameOverValidator {
    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager) {
        List<Tile> emptyTiles = board.getTiles().stream()
                .filter(tile -> tile.getPiece() == null)
                .toList();

        // get empty tiles
        List<Piece> pieces = board.getTiles().stream()
                .map(Tile::getPiece)
                .filter(Objects::nonNull)
                .toList();

        for (Tile emptyTile : emptyTiles) {
            for (Piece piece : pieces) {
                Movement newMovement = new Movement(board.getTileByPiece(piece).get(), emptyTile);
                if (piece.getPieceValidator().isValid(newMovement, board, gameManager)) {
                    return new WinResult<>(false, null);
                }
            }
        }
        Colour enemyColour = gameManager.getTurnChanger().getPreviousTurn();
        return new WinResult<>(true, enemyColour);
    }
}
