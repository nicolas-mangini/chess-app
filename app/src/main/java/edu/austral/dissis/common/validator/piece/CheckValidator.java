package edu.austral.dissis.common.validator.piece;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class CheckValidator implements MovementValidator {
    private final PieceType pieceType;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        Movement movementClone = new Movement(movement);

        Piece pieceToMove = movementClone.getFrom().getPiece();
        Colour teamColour = movementClone.getFrom().getPiece().getColour();
        Colour enemyColour = pieceToMove.getColour().equals(Colour.WHITE) ? Colour.BLACK : Colour.WHITE;

        Optional<Piece> king = board.findPiece(this.pieceType, teamColour);
        if (king.isEmpty()) return true;

        Optional<Tile> kingTile = board.getTileByPiece(king.get());
        if (kingTile.isEmpty()) return true;

        return checkEnemyMovements(movementClone, board, movementHistory, kingTile.get(), enemyColour, pieceToMove);
    }

    private boolean checkEnemyMovements(Movement movement, Board board, List<Movement> movementHistory,
                                        Tile kingTile, Colour enemyColour, Piece pieceToMove) {

        List<Tile> enemyTiles = board.getTiles();
        return enemyTiles.stream()
                .filter(tile -> tile.getPiece() != null)
                .filter(tile -> tile.getPiece().getColour().equals(enemyColour))
                .anyMatch(tile -> checkEnemyValidators(movement, board, movementHistory, kingTile, tile, pieceToMove));
    }

    private boolean checkEnemyValidators(Movement movement, Board board, List<Movement> movementHistory,
                                         Tile kingTile, Tile enemyTile, Piece pieceToMove) {

        SimpleBoard newBoard = new SimpleBoard(board);

        //make the movement
        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        //to escape from check eating
        if (movement.getTo().equalCoordinate(enemyTile)) return false;

        Tile tileToMove = movement.getFrom().equalCoordinate(kingTile) ? movement.getTo() : kingTile;

        boolean canEatKingOriginal = enemyCanEat(board, movementHistory, enemyTile, tileToMove);
        boolean canEatKingNew = enemyCanEat(newBoard, movementHistory, enemyTile, tileToMove);

        return canEatKingOriginal && canEatKingNew;
    }

    private boolean enemyCanEat(Board board, List<Movement> movementHistory,
                                Tile enemyTile, Tile tileToMove) {

        Piece enemyPiece = enemyTile.getPiece();
        return enemyPiece.getPieceMover().getOrValidators()
                .stream()
                .anyMatch(validator -> validator.isValid(new Movement(enemyTile, tileToMove), board, movementHistory));
    }
}