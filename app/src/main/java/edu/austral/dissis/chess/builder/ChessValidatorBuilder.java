package edu.austral.dissis.chess.builder;

import edu.austral.dissis.checkers.validator.game.EmptyPieces;
import edu.austral.dissis.chess.validator.piece.CheckValidator;
import edu.austral.dissis.common.builder.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import edu.austral.dissis.chess.piece.SimplePieceMovementValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;
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
                new CheckMate(),
                new EmptyPieces()
        );
    }

    public PieceMovementsValidator createRookMovements() {
        List<MovementValidator> orValidators = List.of(
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
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createQueenMovements() {
        List<MovementValidator> orValidators = List.of(
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
        return new SimplePieceMovementValidator(orValidators, createDefaultValidators());
    }

    public PieceMovementsValidator createKingMovements() {
        List<MovementValidator> orValidators = List.of(
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