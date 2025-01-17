package edu.austral.dissis.common.validator;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompoundAndValidator implements MovementValidator {
    private final List<MovementValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        return andValidators.stream()
                .allMatch(validator -> validator.isValid(movement, board, gameManager));
    }
}
