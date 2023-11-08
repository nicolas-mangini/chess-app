package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.chess.builder.common.ChessValidatorBuilder;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.builder.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;

import java.util.List;
import java.util.stream.Stream;

public class CustomChessMovementBuilder implements ValidatorBuilder {
    private final ChessValidatorBuilder chessValidatorBuilder;

    public CustomChessMovementBuilder() {
        this.chessValidatorBuilder = new ChessValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate()
        );
    }

    public MovementValidator createChancellorMovements() {
        List<MovementValidator> rookOrValidators = chessValidatorBuilder.createRookOrValidators();
        List<MovementValidator> knightOrValidators = chessValidatorBuilder.createKnightOrValidators();
        List<MovementValidator> chancellorOrValidators = Stream.concat(rookOrValidators.stream(), knightOrValidators.stream()).toList();

        return new CompoundOrValidator(chancellorOrValidators);
    }

    public MovementValidator createKnightMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createKnightOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createArchbishopMovements() {
        List<MovementValidator> bishopOrValidators = chessValidatorBuilder.createBishopOrValidators();
        List<MovementValidator> knightOrValidators = chessValidatorBuilder.createKnightOrValidators();
        List<MovementValidator> archbishopValidators = Stream.concat(knightOrValidators.stream(), bishopOrValidators.stream()).toList();

        return new CompoundOrValidator(archbishopValidators);
    }

    public MovementValidator createQueenMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createQueenOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createKingMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createKingOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createPawnMovements(Colour colour) {
        List<MovementValidator> orValidators = chessValidatorBuilder.createPawnOrValidators(colour);
        return new CompoundOrValidator(orValidators);
    }
}