package edu.austral.dissis.common.validator;

import edu.austral.dissis.common.game.GameManager;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Movement;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompoundOrValidator implements MovementValidator {
    private final List<MovementValidator> orValidators;

    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        return orValidators.stream()
                .anyMatch(orValidator -> orValidator.isValid(movement, board, gameManager));
    }
}
