package edu.austral.dissis.checkers.builder;

import edu.austral.dissis.checkers.validator.game.CannotMoveValidator;
import edu.austral.dissis.common.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;

public class CheckersMovementBuilder {
    private static final ValidatorBuilder validatorBuilder = new ValidatorBuilder();

    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new PiecesRemainingValidator(0),
                new CannotMoveValidator()
        );
    }

    public MovementValidator buildGameValidators() {
        List<MovementValidator> gameValidators = validatorBuilder.createCheckersGameValidators();
        return new CompoundAndValidator(gameValidators);
    }

    public static PieceValidator createCheckersMovements(PieceType pieceType, Colour colour) {
        List<MovementValidator> specialValidators = validatorBuilder.createCheckersSpecialValidators();
        switch (pieceType) {
            case PAWN -> {
                List<MovementValidator> orValidators = validatorBuilder.createCheckersPawnOrValidators(colour);
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case QUEEN -> {
                List<MovementValidator> orValidators = validatorBuilder.createCheckersQueenOrValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            default -> throw new RuntimeException("Piece type not supported");
        }
    }

}
