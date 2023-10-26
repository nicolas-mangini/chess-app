package edu.austral.dissis.chess.builder;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.validator.MovementValidator;
import edu.austral.dissis.chess.validator.impl.CompoundAndValidator;
import edu.austral.dissis.chess.validator.impl.move.*;

import java.util.List;

public class MovementDirector {
    public List<MovementValidator> buildRookMovementValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new EatValidator(true)

                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new EatValidator(true)
                ))
        );
    }

    public List<MovementValidator> buildBishopMovementValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new EatValidator(true)
                ))
        );
    }

    public List<MovementValidator> buildKnightMovementValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, 1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, 2),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, 2),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, 1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, -1),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, -2),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, -2),
                        new EatValidator(true)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, -1),
                        new EatValidator(true)
                ))
        );
    }

    public List<MovementValidator> buildPawnMovementValidators(Colour colour) {
        int xDirection = colour == Colour.WHITE ? 1 : -1;

        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(2),
                        new EatValidator(false),
                        new LimitMovementsValidator(1)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(1),
                        new EatValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new PathClearValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new MustEatValidator()
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new PathClearValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new MustEatValidator()
                ))
        );
    }

    public List<MovementValidator> buildDefaultMovementValidators() {
        return List.of(
                new EatOwnPieceValidator(false)
        );
    }
}
