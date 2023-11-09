package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.checkers.validator.game.EmptyPieces;
import edu.austral.dissis.checkers.validator.piece.EatMiddlePieceValidator;
import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.builder.ValidatorBuilderI;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.DirectionValidator;
import edu.austral.dissis.common.validator.piece.EatFinalPieceValidator;
import edu.austral.dissis.common.validator.piece.IncrementValidator;

import java.util.List;

public class CheckersMovementBuilder implements ValidatorBuilderI {
    private final ValidatorBuilder validatorBuilder;

    public CheckersMovementBuilder() {
        this.validatorBuilder = new ValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new EmptyPieces()
        );
    }

    public MovementValidator buildGameValidators() {
        List<MovementValidator> gameValidators = validatorBuilder.createChessGameValidators();
        return new CompoundAndValidator(gameValidators);
    }

    public MovementValidator createPawnMovements(Colour colour) {
        int xDirection = colour == Colour.BLACK ? 1 : -1;
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new IncrementValidator(2),
                        new EatFinalPieceValidator(false),
                        new EatMiddlePieceValidator()
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new IncrementValidator(2),
                        new EatFinalPieceValidator(false),
                        new EatMiddlePieceValidator()
                ))
        );
        return new CompoundOrValidator(orValidators);
    }
}
