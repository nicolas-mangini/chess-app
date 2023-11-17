package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.chess.builder.ChessValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.PieceType;

import java.util.List;

public class ClassicChessMovementBuilder {
    private static final ChessValidatorBuilder validatorBuilder = new ChessValidatorBuilder();

    public static PieceValidator buildMovements(PieceType pieceType, Colour colour) {
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialPieceValidators();
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
