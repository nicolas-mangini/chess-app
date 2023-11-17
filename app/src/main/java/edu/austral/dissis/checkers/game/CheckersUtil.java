package edu.austral.dissis.checkers.game;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.piece.PieceType;

import java.util.List;

public class CheckersUtil {
    /**
     * Checks if a given movement corresponds to an "eat" move in the game of checkers.
     * In checkers, an "eat" move occurs when a piece moves two tiles diagonally, capturing an opponent's piece in the process.
     *
     * @param movement The movement to be checked.
     * @return {@code true} if the movement is a valid "eat" move; otherwise, {@code false}.
     */
    public static boolean isEatMovement(Movement movement) {
        return Math.abs(movement.getFrom().getX() - movement.getTo().getX()) == 2;
    }

    /**
     * Determines the possible tiles that a piece on the specified {@code fromTile} can jump to in order to capture an opponent's piece.
     * This method is specific to the rules of checkers, where a piece can jump diagonally over an opponent's piece if there is an empty tile
     * behind it, and captures the opponent's piece in the process.
     *
     * @param fromTile The starting tile of the piece.
     * @param board    The checkers board on which the piece is located.
     * @return A list of tiles representing the possible tiles where the piece can jump to capture an opponent's piece.
     */
    public static List<Tile> possibleEatTiles(Tile fromTile, Board board) {
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
}
