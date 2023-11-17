package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.checkers.validator.piece.EatenBeforeValidator;
import edu.austral.dissis.checkers.validator.piece.LastPieceMovedCantEatAgainValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.game.NonExistentPieceValidator;
import edu.austral.dissis.common.validator.game.TurnValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class CheckersValidatorBuilder {
    public List<MovementValidator> createQueenValidators() {
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_RIGHT),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator()
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_LEFT),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator()
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_RIGHT),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator()
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_LEFT),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator()
                                        )),
                                        // eat validator
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_RIGHT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_LEFT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_RIGHT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_LEFT),
                                                new IncrementValidator(1)
                                        ))
                                )),
                                new EatFinalPieceValidator(false),
                                new EatOwnPieceValidator(false)
                        )
                )
        );
    }

    public List<MovementValidator> createPawnValidators(Colour colour) {
        int xDirection = colour == Colour.BLACK ? 1 : -1;
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(xDirection, 1),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(xDirection, -1),
                                                new IncrementValidator(1)
                                        )),
                                        //eat movements
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(xDirection, 1),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator()
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(xDirection, -1),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator()
                                        )),
                                        //eat consecutive
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(-xDirection, -1),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator(),
                                                new EatenBeforeValidator()
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(-xDirection, 1),
                                                new IncrementValidator(2),
                                                new EatMiddlePieceValidator(),
                                                new EatenBeforeValidator()
                                        ))
                                )),
                                new EatFinalPieceValidator(true),
                                new EatOwnPieceValidator(false))
                )
        );
    }

    public List<MovementValidator> createSpecialValidators() {
        return List.of(
                new LastPieceMovedCantEatAgainValidator()
        );
    }

    public List<MovementValidator> createGameValidators() {
        return List.of(
                new NonExistentPieceValidator(),
                new TurnValidator()
        );
    }
}
