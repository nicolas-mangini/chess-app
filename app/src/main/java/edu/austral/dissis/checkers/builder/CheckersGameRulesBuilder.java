package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

public class CheckersGameRulesBuilder {
    private static final CheckersValidatorBuilder validatorBuilder = new CheckersValidatorBuilder();

    public static MovementValidator buildGameValidators() {
        return new CompoundAndValidator(
                validatorBuilder.createGameValidators()
        );
    }

    public static List<GameOverValidator> buildGameOverValidators() {
        return validatorBuilder.createGameOverValidators();
    }
}
