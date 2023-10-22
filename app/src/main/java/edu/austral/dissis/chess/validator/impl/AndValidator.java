package edu.austral.dissis.chess.validator.impl;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MoveValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class AndValidator implements MoveValidator {
    private final List<MoveValidator> andValidators;

    @Override
    public boolean isValid(Movement movement, Board board) {
        return andValidators.stream().allMatch(validator -> validator.isValid(movement, board));
    }
}
