package edu.austral.dissis.chess.builder;

import edu.austral.dissis.checkers.validator.game.EmptyPieces;
import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.builder.ValidatorBuilderI;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;

import java.util.List;

public class ChessMovementBuilder implements ValidatorBuilderI {
    private final ValidatorBuilder validatorBuilder;

    public ChessMovementBuilder() {
        this.validatorBuilder = new ValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate(),
                new EmptyPieces()
        );
    }

    public MovementValidator buildGameValidators() {
        List<MovementValidator> gameValidators = validatorBuilder.createChessGameValidators();
        return new CompoundAndValidator(gameValidators);
    }

    public MovementValidator createRookMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createRookOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createKnightMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createKnightOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public MovementValidator createBishopMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createBishopOrValidators();
        return new CompoundOrValidator(orValidators);
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