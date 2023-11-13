/*
package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

public class MustEatIfCanValidator implements MovementValidator {

    //TODO maybe add
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Piece lastPieceMoved = gameManager.getGame()
                .getHistory()
                .get(gameManager.getGame().getHistory().size() - 1)
                .getFrom()
                .getPiece();


    }

    private boolean canEat(Piece piece, Board board) {
        Colour enemyColour = piece.getColour() == Colour.WHITE ? Colour.BLACK : Colour.WHITE;
        List<Tile> emptyTiles = board.getTiles().stream()
                .filter(tile -> tile.getPiece() != null)


        return
    }
}
*/
