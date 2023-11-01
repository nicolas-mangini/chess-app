package edu.austral.dissis.common.validator;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompoundAndValidator implements MovementValidator {
    private final List<MovementValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, Board board, List<Movement> movementHistory) {
        return andValidators.stream()
                .allMatch(validator -> validator.isValid(movement, board, movementHistory));
    }
}
