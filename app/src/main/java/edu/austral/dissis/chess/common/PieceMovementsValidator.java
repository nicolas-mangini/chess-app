package edu.austral.dissis.chess.common;

import edu.austral.dissis.chess.validator.MovementValidator;

import java.util.List;

public interface PieceMovementsValidator extends MovementValidator {
    List<MovementValidator> getOrValidators();

    List<MovementValidator> getAndValidators();
}
