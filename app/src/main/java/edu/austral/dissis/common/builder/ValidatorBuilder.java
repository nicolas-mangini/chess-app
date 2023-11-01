package edu.austral.dissis.common.builder;

import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

public interface ValidatorBuilder {
    List<MovementValidator> buildMovementValidators();

    List<GameOverValidator> buildGameOverValidators();
}
