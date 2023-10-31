package edu.austral.dissis.chess.piece;

import edu.austral.dissis.chess.board.ChessBoard;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SimplePieceMovementValidator implements PieceMovementsValidator {
    private final List<MovementValidator> orValidators;
    private final List<MovementValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, ChessBoard board, List<Movement> movementHistory) {
        return validateOrValidators(movement, board, movementHistory)
                && validateAndValidators(movement, board, movementHistory);
    }

    public boolean validateOrValidators(Movement movement, ChessBoard board, List<Movement> movementHistory) {
        return orValidators.stream()
                .anyMatch(orValidator -> orValidator.isValid(movement, board, movementHistory));
    }

    public boolean validateAndValidators(Movement movement, ChessBoard board, List<Movement> movementHistory) {
        return andValidators.stream()
                .noneMatch(andValidator -> andValidator.isValid(movement, board, movementHistory));
    }

    @Override
    public List<MovementValidator> getOrValidators() {
        return this.orValidators;
    }

    @Override
    public List<MovementValidator> getAndValidators() {
        return this.andValidators;
    }
}
