package edu.austral.dissis.checkers.factory;

import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.PieceMovementsValidator;
import edu.austral.dissis.chess.common.SimplePieceMovementValidator;
import edu.austral.dissis.chess.validator.CompoundAndValidator;
import edu.austral.dissis.chess.validator.MovementValidator;
import edu.austral.dissis.chess.validator.piece.DirectionValidator;
import edu.austral.dissis.chess.validator.piece.EatValidator;
import edu.austral.dissis.chess.validator.piece.IncrementValidator;

import java.util.List;

public class CheckersMovementFactory {
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
        return new SimplePieceMovementValidator(orValidators, List.of());
    }
}
