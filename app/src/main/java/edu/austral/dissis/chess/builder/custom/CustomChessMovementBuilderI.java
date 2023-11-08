package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.builder.ValidatorBuilderI;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;

import java.util.List;
import java.util.stream.Stream;

public class CustomChessMovementBuilderI implements ValidatorBuilderI {
    private final ValidatorBuilder validatorBuilder;

    public CustomChessMovementBuilderI() {
        this.validatorBuilder = new ValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate()
        );
    }

    public MovementValidator createChancellorMovements() {
        List<MovementValidator> rookOrValidators = validatorBuilder.createRookOrValidators();
        List<MovementValidator> knightOrValidators = validatorBuilder.createKnightOrValidators();
        List<MovementValidator> chancellorOrValidators = Stream.concat(rookOrValidators.stream(), knightOrValidators.stream()).toList();

        return new CompoundOrValidator(chancellorOrValidators);
    }

    public MovementValidator createKnightMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createKnightOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createArchbishopMovements() {
        List<MovementValidator> bishopOrValidators = validatorBuilder.createBishopOrValidators();
        List<MovementValidator> knightOrValidators = validatorBuilder.createKnightOrValidators();
        List<MovementValidator> archbishopValidators = Stream.concat(knightOrValidators.stream(), bishopOrValidators.stream()).toList();

        return new CompoundOrValidator(archbishopValidators);
    }

    public MovementValidator createQueenMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createQueenOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createKingMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createKingOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createPawnMovements(Colour colour) {
        List<MovementValidator> orValidators = validatorBuilder.createPawnOrValidators(colour);
        return new CompoundOrValidator(orValidators);
    }
}