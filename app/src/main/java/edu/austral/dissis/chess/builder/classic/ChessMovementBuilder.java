package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.chess.builder.ChessValidatorBuilder;
import edu.austral.dissis.common.builder.MovementBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;
import edu.austral.dissis.common.validator.piece.PieceType;

import java.util.List;

public class ChessMovementBuilder implements MovementBuilder {
    private static final ChessValidatorBuilder validatorBuilder = new ChessValidatorBuilder();

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate(),
                new PiecesRemainingValidator(12)
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
            case ROOK -> {
                List<MovementValidator> orValidators = validatorBuilder.createRookValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case KNIGHT -> {
                List<MovementValidator> orValidators = validatorBuilder.createKnightValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case BISHOP -> {
                List<MovementValidator> orValidators = validatorBuilder.createBishopValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case QUEEN -> {
                List<MovementValidator> orValidators = validatorBuilder.createQueenValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case KING -> {
                List<MovementValidator> orValidators = validatorBuilder.createKingValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case PAWN -> {
                List<MovementValidator> orValidators = validatorBuilder.createPawnValidators(colour);
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            default -> throw new RuntimeException("Piece type not supported");
        }
    }
}
