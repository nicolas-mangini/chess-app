package edu.austral.dissis.chess.builder;

import edu.austral.dissis.common.builder.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import edu.austral.dissis.chess.piece.SimplePieceMovementValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.game.CheckMate;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class ChessValidatorBuilder implements ValidatorBuilder {
    @Override
    public List<MovementValidator> buildMovementValidators() {
        return List.of(
                createRookMovements(),
                createKnightMovements(),
                createBishopMovements(),
                createQueenMovements(),
                createKingMovements(),
                createPawnMovements(Colour.WHITE),
                createPawnMovements(Colour.BLACK)
        );
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate()
        );
    }

    public PieceMovementsValidator createRookMovements() {
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)

                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createKnightMovements() {
        List<MovementValidator> orValidators = List.of(
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
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createBishopMovements() {
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createQueenMovements() {
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createKingMovements() {
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 0),
                        new PathClearValidator(1, 0),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 0),
                        new PathClearValidator(-1, 0),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, 1),
                        new PathClearValidator(0, 1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(0, -1),
                        new PathClearValidator(0, -1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, 1),
                        new PathClearValidator(1, 1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, -1),
                        new PathClearValidator(-1, -1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(1, -1),
                        new PathClearValidator(1, -1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(-1, 1),
                        new PathClearValidator(-1, 1),
                        new IncrementValidator(1),
                        new EatValidator(true),
                        new EatOwnPieceValidator(false)
                ))
        );
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createPawnMovements(Colour colour) {
        int xDirection = colour == Colour.BLACK ? 1 : -1;

        List<MovementValidator> orValidators = List.of(
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
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public List<MovementValidator> createDefaultValidators() {
        return List.of(new CheckValidator(PieceType.KING));
    }
}