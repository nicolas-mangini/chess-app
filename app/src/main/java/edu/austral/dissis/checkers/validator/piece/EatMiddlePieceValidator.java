package edu.austral.dissis.checkers.validator.piece;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.Optional;

/**
 * Validator to ensure that a piece can perform an eating movement only if there is a piece
 * of the opposite color in the middle of the movement.
 */
public class EatMiddlePieceValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Tile initial = movement.getFrom();
        Optional<Tile> middle = board.getTile(
                (initial.getX() + movement.getTo().getX()) / 2,
                (initial.getY() + movement.getTo().getY()) / 2
        );
        return middle.isPresent()
                &&
                middle.get().getPiece() != null
                &&
                middle.get().getPiece().getColour() != initial.getPiece().getColour();
    }
}
