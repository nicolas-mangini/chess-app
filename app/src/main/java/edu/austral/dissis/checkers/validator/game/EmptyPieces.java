package edu.austral.dissis.checkers.validator.game;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.util.WinResult;
import edu.austral.dissis.chess.validator.GameOverValidator;

import java.util.List;

public class EmptyPieces implements GameOverValidator {
    @Override
    public WinResult<Boolean, Colour> isGameOver(Movement movement, Board board, List<Movement> movementHistory) {
        Colour teamColour = movement.getFrom().getPiece().getColour();

        boolean hasPieces = board.getTiles()
                .stream()
                .filter(tile -> tile.getPiece() != null)
                .anyMatch(tile -> tile.getPiece().getColour().equals(teamColour));
        if (!hasPieces) return new WinResult<>(true, teamColour);
        else return new WinResult<>(false, null);
    }
}
