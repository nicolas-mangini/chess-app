package edu.austral.dissis.chess.validator.impl;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MovementValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class CompoundAndValidator implements MovementValidator {
    private final List<MovementValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, Board board) {
        return andValidators.stream().allMatch(validator -> validator.isValid(movement, board));
    }
}
