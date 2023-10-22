/*
package edu.austral.dissis.chess.validator.impl;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MoveValidator;
import lombok.AllArgsConstructor;

import java.util.List;

@AllArgsConstructor
public class OrValidator implements MoveValidator {
    private final List<MoveValidator> validators;

    @Override
    public boolean isValid(Movement movement, Board board) {
        return validators.stream().anyMatch(validator -> validator.isValid(movement, board));
    }
}
*/
