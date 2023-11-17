package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.chess.builder.ChessValidatorBuilder;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;

import java.util.List;

public class ClassicChessGameRulesBuilder {
    private static final ChessValidatorBuilder validatorBuilder = new ChessValidatorBuilder();

    public static MovementValidator buildGameValidators() {
        return new CompoundAndValidator(
                validatorBuilder.createGameValidators()
        );
    }

    public static List<GameOverValidator> buildGameOverValidators() {
        return validatorBuilder.createGameOverValidators();
    }
}
