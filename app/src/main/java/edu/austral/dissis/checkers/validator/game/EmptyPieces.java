package edu.austral.dissis.checkers.validator.game;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.util.WinResult;
import edu.austral.dissis.common.validator.GameOverValidator;

public class EmptyPieces implements GameOverValidator {
    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, GameManager gameManager) {
        Colour teamColour = movement.getFrom().getPiece().getColour();

        boolean hasPieces = board.getTiles()
                .stream()
                .filter(tile -> tile.getPiece() != null)
                .anyMatch(tile -> tile.getPiece().getColour().equals(teamColour));
        if (!hasPieces) return new WinResult<>(true, teamColour);
        else return new WinResult<>(false, null);
    }
}
