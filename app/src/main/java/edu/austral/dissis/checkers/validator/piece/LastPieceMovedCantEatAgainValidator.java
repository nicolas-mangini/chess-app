package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

import static edu.austral.dissis.checkers.game.CheckersUtil.isEatMovement;
import static edu.austral.dissis.checkers.game.CheckersUtil.possibleEatTiles;

public class LastPieceMovedCantEatAgainValidator implements MovementValidator {
    /**
     * Validator to ensure that a piece can move if the last piece moved
     * cannot eat again
     */
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        List<Movement> history = gameManager.getGame().getHistory();
        if (history.isEmpty()) return true;

        Movement previousMovement = history.get(history.size() - 1);
        if (isEatMovement(previousMovement)) {
            return true;
        }

        Piece pieceToMove = movement.getFrom().getPiece();
        Piece lastMovedPiece = history.get(history.size() - 1).getFrom().getPiece();
        Tile lastMovedPieceTile = board.getTileByPiece(lastMovedPiece).get();

        List<Tile> possibleEatTiles = possibleEatTiles(lastMovedPieceTile, board);

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
        return piece.getPieceValidator().isValidClassic(movement, board, gameManager);
    }
}
