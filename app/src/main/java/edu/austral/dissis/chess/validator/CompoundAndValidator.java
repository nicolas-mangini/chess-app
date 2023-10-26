package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class CompoundAndValidator implements MovementValidator {
    private final List<MovementValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        return andValidators.stream()
                .allMatch(validator -> validator.isValid(movement, board, movementHistory));
    }
}
