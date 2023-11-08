package edu.austral.dissis.common.builder;

import edu.austral.dissis.common.validator.GameOverValidator;

import java.util.List;

public interface ValidatorBuilderI {
    List<GameOverValidator> buildGameOverValidators();
}
