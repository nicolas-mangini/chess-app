package edu.austral.dissis.common.validator;

import java.util.List;

public interface PieceMovementsValidator extends MovementValidator {
    List<MovementValidator> getOrValidators();

    List<MovementValidator> getAndValidators();
}
