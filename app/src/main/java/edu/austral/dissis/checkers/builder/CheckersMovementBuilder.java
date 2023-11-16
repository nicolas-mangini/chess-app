package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.checkers.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.checkers.validator.piece.EatMiddlePieceValidator;
import edu.austral.dissis.checkers.validator.piece.EatenBeforeValidator;
import edu.austral.dissis.checkers.validator.piece.LastPieceMovedCantEatAgainValidator;
import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.builder.ValidatorBuilderI;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class CheckersMovementBuilder implements ValidatorBuilderI {
    private final ValidatorBuilder validatorBuilder;

    public CheckersMovementBuilder() {
        this.validatorBuilder = new ValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new PiecesRemainingValidator(10)
        );
    }

    public MovementValidator buildGameValidators() {
        List<MovementValidator> gameValidators = validatorBuilder.createChessGameValidators();
        return new CompoundAndValidator(gameValidators);
    }

    public PieceValidator createPawnMovements(Colour colour) {
        int xDirection = colour == Colour.BLACK ? 1 : -1;
        List<MovementValidator> orValidators = List.of(
                //simple movements
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false)
                )),
                //eat movements
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new IncrementValidator(2),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false),
                        new EatMiddlePieceValidator()
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new IncrementValidator(2),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false),
                        new EatMiddlePieceValidator()
                )),
                //eat consecutive movements
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-xDirection, -1),
                        new IncrementValidator(2),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false),
                        new EatMiddlePieceValidator(),
                        new EatenBeforeValidator()
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-xDirection, 1),
                        new IncrementValidator(2),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false),
                        new EatMiddlePieceValidator(),
                        new EatenBeforeValidator()
                ))
        );

        List<MovementValidator> specialAndValidators = List.of(
                new LastPieceMovedCantEatAgainValidator()
        );

        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialAndValidators));
    }

/*    public MovementValidator createQueenValidators() {
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false)
                ))
        );
        return new CompoundOrValidator(orValidators);
    }*/
}
