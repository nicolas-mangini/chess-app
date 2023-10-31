package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SimplePieceMovementValidator implements PieceMovementsValidator {
    private final List<MovementValidator> orValidators;
    private final List<MovementValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        return validateOrValidators(movement, board, movementHistory)
                && validateAndValidators(movement, board, movementHistory);
    }

    public boolean validateOrValidators(Movement movement, Board board, List<Movement> movementHistory) {
        return orValidators.stream()
                .anyMatch(orValidator -> orValidator.isValid(movement, board, movementHistory));
    }

    public boolean validateAndValidators(Movement movement, Board board, List<Movement> movementHistory) {
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