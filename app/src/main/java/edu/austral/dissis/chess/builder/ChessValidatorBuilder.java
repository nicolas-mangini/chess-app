package edu.austral.dissis.chess.builder;

import edu.austral.dissis.common.validator.game.CannotMoveValidator;
import edu.austral.dissis.chess.validator.piece.CheckValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.game.NonExistentPieceValidator;
import edu.austral.dissis.common.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.common.validator.game.TurnValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class ChessValidatorBuilder {
    public List<MovementValidator> createGameValidators() {
        return List.of(
                new NonExistentPieceValidator(),
                new TurnValidator()
        );
    }

    public List<GameOverValidator> createGameOverValidators() {
        return List.of(
                // CheckMate is basically that all enemy pieces cannot move (piece cannot move if is in check)
                new CannotMoveValidator(),
                new PiecesRemainingValidator(0)
        );
    }

    public List<MovementValidator> createRookValidators() {
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.RIGHT),
                                                new PathClearValidator(Direction.RIGHT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.LEFT),
                                                new PathClearValidator(Direction.LEFT)

                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP),
                                                new PathClearValidator(Direction.UP)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN),
                                                new PathClearValidator(Direction.DOWN)
                                        ))
                                )),
                                new EatFinalPieceValidator(true),
                                new EatOwnPieceValidator(false))
                )
        );
    }

    public List<MovementValidator> createKnightValidators() {
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(2, 1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(1, 2)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(-1, 2)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(-2, 1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(-2, -1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(-1, -2)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(1, -2)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new JumpMovementValidator(2, -1)
                                        ))
                                )),
                                new EatFinalPieceValidator(true),
                                new EatOwnPieceValidator(false))
                )
        );
    }

    public List<MovementValidator> createBishopValidators() {
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_RIGHT),
                                                new PathClearValidator(Direction.UP_RIGHT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_LEFT),
                                                new PathClearValidator(Direction.DOWN_LEFT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_RIGHT),
                                                new PathClearValidator(Direction.DOWN_RIGHT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_LEFT),
                                                new PathClearValidator(Direction.UP_LEFT)
                                        ))
                                )),
                                new EatFinalPieceValidator(true),
                                new EatOwnPieceValidator(false))
                )
        );
    }

    public List<MovementValidator> createQueenValidators() {
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.RIGHT),
                                                new PathClearValidator(Direction.RIGHT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.LEFT),
                                                new PathClearValidator(Direction.LEFT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP),
                                                new PathClearValidator(Direction.UP)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN),
                                                new PathClearValidator(Direction.DOWN)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_RIGHT),
                                                new PathClearValidator(Direction.UP_RIGHT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_LEFT),
                                                new PathClearValidator(Direction.DOWN_LEFT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_RIGHT),
                                                new PathClearValidator(Direction.DOWN_RIGHT)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_LEFT),
                                                new PathClearValidator(Direction.UP_LEFT)
                                        ))
                                )),
                                new EatFinalPieceValidator(true),
                                new EatOwnPieceValidator(false))
                )
        );
    }

    public List<MovementValidator> createKingValidators() {
        return List.of(
                new CompoundAndValidator(
                        List.of(
                                new CompoundOrValidator(List.of(
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.RIGHT),
                                                new PathClearValidator(Direction.RIGHT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.LEFT),
                                                new PathClearValidator(Direction.LEFT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP),
                                                new PathClearValidator(Direction.UP),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN),
                                                new PathClearValidator(Direction.DOWN),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_RIGHT),
                                                new PathClearValidator(Direction.UP_RIGHT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_LEFT),
                                                new PathClearValidator(Direction.DOWN_LEFT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.DOWN_RIGHT),
                                                new PathClearValidator(Direction.DOWN_RIGHT),
                                                new IncrementValidator(1)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(Direction.UP_LEFT),
                                                new PathClearValidator(Direction.UP_LEFT),
                                                new IncrementValidator(1)
                                        ))
                                )),
                                new EatFinalPieceValidator(true),
                                new EatOwnPieceValidator(false))
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
                                                new DirectionValidator(xDirection, 0),
                                                new PathClearValidator(xDirection, 0),
                                                new IncrementValidator(2),
                                                new LimitMovementsValidator(1),
                                                new EatFinalPieceValidator(false)
                                        )),
                                        new CompoundAndValidator(List.of(
                                                new DirectionValidator(xDirection, 0),
                                                new PathClearValidator(xDirection, 0),
                                                new IncrementValidator(1),
                                                new EatFinalPieceValidator(false)
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
                                )),
                                new EatOwnPieceValidator(false))
                )
        );
    }

    public List<MovementValidator> createSpecialPieceValidators() {
        return List.of(
                new CheckValidator(PieceType.KING)
        );
    }
}
