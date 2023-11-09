package edu.austral.dissis.chess.builder.common;

import edu.austral.dissis.chess.validator.game.ChessTurnValidator;
import edu.austral.dissis.chess.validator.piece.CheckValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.game.NonExistentPieceValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class ValidatorBuilder {
    public List<MovementValidator> createRookOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.RIGHT),
                        new PathClearValidator(Direction.RIGHT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.LEFT),
                        new PathClearValidator(Direction.LEFT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)

                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new PathClearValidator(Direction.UP),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN),
                        new PathClearValidator(Direction.DOWN),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                ))
        );
    }

    public List<MovementValidator> createKnightOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, 1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, 2),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, 2),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, 1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-2, -1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(-1, -2),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(1, -2),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new JumpMovementValidator(2, -1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                ))
        );
    }

    public List<MovementValidator> createBishopOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_RIGHT),
                        new PathClearValidator(Direction.UP_RIGHT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_LEFT),
                        new PathClearValidator(Direction.DOWN_LEFT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_RIGHT),
                        new PathClearValidator(Direction.DOWN_RIGHT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_LEFT),
                        new PathClearValidator(Direction.UP_LEFT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                ))
        );
    }

    public List<MovementValidator> createQueenOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.RIGHT),
                        new PathClearValidator(Direction.RIGHT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.LEFT),
                        new PathClearValidator(Direction.LEFT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new PathClearValidator(Direction.UP),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN),
                        new PathClearValidator(Direction.DOWN),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_RIGHT),
                        new PathClearValidator(Direction.UP_RIGHT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_LEFT),
                        new PathClearValidator(Direction.DOWN_LEFT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_RIGHT),
                        new PathClearValidator(Direction.DOWN_RIGHT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_LEFT),
                        new PathClearValidator(Direction.UP_LEFT),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                ))
        );
    }

    public List<MovementValidator> createKingOrValidators() {
        return List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.RIGHT),
                        new PathClearValidator(Direction.RIGHT),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.LEFT),
                        new PathClearValidator(Direction.LEFT),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP),
                        new PathClearValidator(Direction.UP),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN),
                        new PathClearValidator(Direction.DOWN),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_RIGHT),
                        new PathClearValidator(Direction.UP_RIGHT),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_LEFT),
                        new PathClearValidator(Direction.DOWN_LEFT),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.DOWN_RIGHT),
                        new PathClearValidator(Direction.DOWN_RIGHT),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(Direction.UP_LEFT),
                        new PathClearValidator(Direction.UP_LEFT),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(true),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
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
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 0),
                        new PathClearValidator(xDirection, 0),
                        new IncrementValidator(1),
                        new EatFinalPieceValidator(false),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new PathClearValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new MustEatValidator(),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new PathClearValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new MustEatValidator(),
                        new EatOwnPieceValidator(false),
                        new CheckValidator(PieceType.KING)
                ))
        );
    }

    public List<MovementValidator> createChessGameValidators() {
        return List.of(
                new NonExistentPieceValidator(),
                new ChessTurnValidator()
        );
    }

    public List<MovementValidator> createCheckersGameValidators() {
        return List.of(
                new NonExistentPieceValidator()
                //new CheckersTurnValidator()
        );
    }

    public List<MovementValidator> createGameOverValidators() {
        return List.of(new CheckValidator(PieceType.KING));
    }
}
