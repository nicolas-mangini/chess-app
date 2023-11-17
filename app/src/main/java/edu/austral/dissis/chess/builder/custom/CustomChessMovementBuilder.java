package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.chess.builder.ChessValidatorBuilder;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.piece.PieceType;

import java.util.List;
import java.util.stream.Stream;

public class CustomChessMovementBuilder {
    private static final ChessValidatorBuilder validatorBuilder = new ChessValidatorBuilder();

    public static PieceValidator buildMovements(PieceType pieceType, Colour colour) {
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialPieceValidators();
        switch (pieceType) {
            case CHANCELLOR -> {
                List<MovementValidator> rookOrValidators = validatorBuilder.createRookValidators();
                List<MovementValidator> knightOrValidators = validatorBuilder.createKnightValidators();
                List<MovementValidator> chancellorOrValidators = Stream.concat(rookOrValidators.stream(), knightOrValidators.stream()).toList();
                return new PieceValidator(new CompoundOrValidator(chancellorOrValidators), new CompoundAndValidator(specialValidators));
            }
            case KNIGHT -> {
                List<MovementValidator> orValidators = validatorBuilder.createKnightValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case ARCHBISHOP -> {
                List<MovementValidator> bishopOrValidators = validatorBuilder.createBishopValidators();
                List<MovementValidator> knightOrValidators = validatorBuilder.createKnightValidators();
                List<MovementValidator> archbishopValidators = Stream.concat(knightOrValidators.stream(), bishopOrValidators.stream()).toList();
                return new PieceValidator(new CompoundOrValidator(archbishopValidators), new CompoundAndValidator(specialValidators));
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
