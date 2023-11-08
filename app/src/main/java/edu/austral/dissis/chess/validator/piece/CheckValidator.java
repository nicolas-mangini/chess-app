package edu.austral.dissis.chess.validator.piece;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.PieceType;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CheckValidator implements MovementValidator {
    private final PieceType pieceType;

    /**
     * Checks if the given movement would result in the piece being in check.
     * @return True if the movement would not result in the piece being in check, false otherwise.
     */
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Movement movementClone = new Movement(movement);

        Piece pieceToMove = movementClone.getFrom().getPiece();
        Colour teamColour = movementClone.getFrom().getPiece().getColour();
        Colour enemyColour = pieceToMove.getColour().equals(Colour.WHITE) ? Colour.BLACK : Colour.WHITE;

        Optional<Piece> king = board.findPiece(this.pieceType, teamColour);
        if (king.isEmpty()) return false;

        Optional<Tile> kingTile = board.getTileByPiece(king.get());
        if (kingTile.isEmpty()) return false;

        return checkEnemyMovements(movementClone, board, gameManager, kingTile.get(), enemyColour, pieceToMove);
    }

    private boolean checkEnemyMovements(Movement movement, Board board, GameManager gameManager,
                                        Tile kingTile, Colour enemyColour, Piece pieceToMove) {

        List<Tile> enemyTiles = board.getTiles();
        return enemyTiles.stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getColour().equals(enemyColour))
                .noneMatch(tile -> checkEnemyValidators(movement, board, gameManager, kingTile, tile, pieceToMove));
    }

    private boolean checkEnemyValidators(Movement movement, Board board, GameManager gameManager,
                                         Tile kingTile, Tile enemyTile, Piece pieceToMove) {

        Board newBoard = new SimpleBoard(board);

        //make the movement
        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        //to escape from check eating
        if (movement.getTo().equalCoordinate(enemyTile)) return false;

        Tile tileToMove = movement.getFrom().equalCoordinate(kingTile) ? movement.getTo() : kingTile;

        try {
            boolean canEatKingOriginal = enemyTile.getPiece()
                    .getPieceValidators()
                    .isValid(new Movement(enemyTile, tileToMove), board, gameManager);

            boolean canEatKingNew = enemyTile.getPiece()
                    .getPieceValidators()
                    .isValid(new Movement(enemyTile, tileToMove), newBoard, gameManager);
            return canEatKingOriginal && canEatKingNew;
        } catch (StackOverflowError e) {
            System.out.println();
        }
        return false;
    }
}