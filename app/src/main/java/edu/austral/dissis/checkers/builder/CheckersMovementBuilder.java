package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.checkers.validator.game.CannotMoveValidator;
import edu.austral.dissis.common.builder.MovementBuilder;
import edu.austral.dissis.common.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class CheckersMovementBuilder implements MovementBuilder {
    private static final CheckersValidatorBuilder validatorBuilder = new CheckersValidatorBuilder();

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new PiecesRemainingValidator(0),
                new CannotMoveValidator()
        );
    }

    @Override
    public MovementValidator buildGameValidators() {
        List<MovementValidator> gameValidators = validatorBuilder.createGameValidators();
        return new CompoundAndValidator(gameValidators);
    }

    public static PieceValidator createMovements(PieceType pieceType, Colour colour) {
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
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
