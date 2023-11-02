package edu.austral.dissis.chess.builder.common;

import edu.austral.dissis.chess.validator.piece.CheckValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class ChessValidatorBuilder {
    public List<MovementValidator> createRookOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.RIGHT),
                        new PathClearValidator(Direction.RIGHT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.LEFT),
                        new PathClearValidator(Direction.LEFT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new PathClearValidator(Direction.UP),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN),
                        new PathClearValidator(Direction.DOWN),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    public List<MovementValidator> createKnightOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, 2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, 2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, -2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, -2),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                ))
        );
    }

    public List<MovementValidator> createBishopOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_RIGHT),
                        new PathClearValidator(Direction.UP_RIGHT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_LEFT),
                        new PathClearValidator(Direction.DOWN_LEFT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_RIGHT),
                        new PathClearValidator(Direction.DOWN_RIGHT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_LEFT),
                        new PathClearValidator(Direction.UP_LEFT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    public List<MovementValidator> createQueenOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.RIGHT),
                        new PathClearValidator(Direction.RIGHT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.LEFT),
                        new PathClearValidator(Direction.LEFT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new PathClearValidator(Direction.UP),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN),
                        new PathClearValidator(Direction.DOWN),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_RIGHT),
                        new PathClearValidator(Direction.UP_RIGHT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_LEFT),
                        new PathClearValidator(Direction.DOWN_LEFT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_RIGHT),
                        new PathClearValidator(Direction.DOWN_RIGHT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_LEFT),
                        new PathClearValidator(Direction.UP_LEFT),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    public List<MovementValidator> createKingOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.RIGHT),
                        new PathClearValidator(Direction.RIGHT),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.LEFT),
                        new PathClearValidator(Direction.LEFT),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new PathClearValidator(Direction.UP),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN),
                        new PathClearValidator(Direction.DOWN),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_RIGHT),
                        new PathClearValidator(Direction.UP_RIGHT),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_LEFT),
                        new PathClearValidator(Direction.DOWN_LEFT),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_RIGHT),
                        new PathClearValidator(Direction.DOWN_RIGHT),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_LEFT),
                        new PathClearValidator(Direction.UP_LEFT),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    public List<MovementValidator> createPawnOrValidators(Colour colour) {
        int xDirection = colour == Colour.BLACK ? 1 : -1;

        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(2),
                        new LimitMovementsValidator(1),
                        new EatValidator(false),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(1),
                        new EatValidator(false),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new PathClearValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new MustEatValidator(),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new PathClearValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new MustEatValidator(),
                        new EatOwnPieceValidator(false)
                ))
        );
    }

    public List<MovementValidator> createDefaultValidators() {
        return List.of(new CheckValidator(PieceType.KING));
    }

    public List<MovementValidator> createGameOverValidators() {
        return List.of(new CheckValidator(PieceType.KING));
    }
}
