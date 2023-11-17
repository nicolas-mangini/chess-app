package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class CheckersMovementBuilder {
    private static final CheckersValidatorBuilder validatorBuilder = new CheckersValidatorBuilder();

    public static PieceValidator buildMovements(PieceType pieceType, Colour colour) {
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialPieceValidators();
        switch (pieceType) {
            case PAWN -> {
                List<MovementValidator> orValidators = validatorBuilder.createPawnValidators(colour);
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case QUEEN -> {
                List<MovementValidator> orValidators = validatorBuilder.createQueenValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            default -> throw new RuntimeException("Piece type not supported");
        }
    }
}
