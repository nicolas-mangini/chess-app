package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import edu.austral.dissis.chess.piece.SimplePieceMovementValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.DirectionValidator;
import edu.austral.dissis.common.validator.piece.EatValidator;
import edu.austral.dissis.common.validator.piece.IncrementValidator;

import java.util.List;

public class CheckersMovementBuilder {
    public PieceMovementsValidator createPawnMovements(Colour colour) {
        int xDirection = colour == Colour.BLACK ? 1 : -1;
        List<MovementValidator> orValidators = List.of(
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, 1),
                        new IncrementValidator(1),
                        new EatValidator(false)
                )),
                new CompoundAndValidator(List.of(
                        new DirectionValidator(xDirection, -1),
                        new IncrementValidator(1),
                        new EatValidator(false)
                ))
        );
        return new SimplePieceMovementValidator(orValidators);
    }
}
