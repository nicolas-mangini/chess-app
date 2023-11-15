package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

public class LastPieceMovedCantEatAgainValidator implements MovementValidator {
    /**
     * Validator to ensure that a piece can move if the last piece moved
     * cannot eat again
     */
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        List<Movement> history = gameManager.getGame().getHistory();
        if (history.isEmpty()) return true;

        Piece pieceToMove = movement.getFrom().getPiece();
        Piece lastMovedPiece = history.get(history.size() - 1).getFrom().getPiece();
        Tile lastMovedPieceTile = movement.getFrom();
        List<Tile> possibleEatTiles = board.getTiles().stream()
                .filter(tile -> Math.abs(tile.getX() - lastMovedPieceTile.getX()) == 2)
                .filter(tile -> Math.abs(tile.getY() - lastMovedPieceTile.getY()) == 2)
                .filter(tile -> tile.getPiece() == null)
                .filter(tile -> {
                    Tile middleTile = board.getTile(
                            (tile.getX() + lastMovedPieceTile.getX()) / 2,
                            (tile.getY() + lastMovedPieceTile.getY()) / 2
                    ).get();
                    return middleTile.getPiece() != null;
                })
                .toList();

        for (Tile possibleTile : possibleEatTiles) {
            Movement consecutiveMovement = new Movement(lastMovedPieceTile, possibleTile);
            if (validatePieceMovement(consecutiveMovement, board, gameManager)) {
                return pieceToMove.getId().equals(lastMovedPiece.getId());
            }
        }

        return true;
    }

    private boolean validatePieceMovement(Movement movement, Board board, GameManager gameManager) {
        Piece piece = movement.getFrom().getPiece();
        return piece.getPieceValidators().isValid(movement, board, gameManager);
    }
}
