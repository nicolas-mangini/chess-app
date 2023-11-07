package edu.austral.dissis.chess.piece;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class SimplePieceMovementValidator implements PieceMovementsValidator {
    private final List<MovementValidator> orValidators;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        return validateOrValidators(movement, board, movementHistory);
    }

    public boolean validateOrValidators(Movement movement, Board board, List<Movement> movementHistory) {
        return orValidators.stream()
                .anyMatch(orValidator -> orValidator.isValid(movement, board, movementHistory));
    }

    @Override
    public List<MovementValidator> getOrValidators() {
        return this.orValidators;
    }
}
