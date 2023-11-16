package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.common.builder.ValidatorBuilder;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;
import edu.austral.dissis.common.validator.piece.PieceType;

import java.util.List;

public class ChessMovementBuilder {
    private static final ValidatorBuilder validatorBuilder = new ValidatorBuilder();

    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate(),
                new PiecesRemainingValidator(12)
        );
    }

    public MovementValidator buildGameValidators() {
        List<MovementValidator> gameValidators = validatorBuilder.createChessGameValidators();
        return new CompoundAndValidator(gameValidators);
    }

    public static PieceValidator createChessMovements(PieceType pieceType, Colour colour) {
        List<MovementValidator> specialValidators = validatorBuilder.createChessSpecialValidators();
        switch (pieceType) {
            case ROOK -> {
                List<MovementValidator> orValidators = validatorBuilder.createRookOrValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case KNIGHT -> {
                List<MovementValidator> orValidators = validatorBuilder.createKnightOrValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case BISHOP -> {
                List<MovementValidator> orValidators = validatorBuilder.createBishopOrValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case QUEEN -> {
                List<MovementValidator> orValidators = validatorBuilder.createChessQueenOrValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case KING -> {
                List<MovementValidator> orValidators = validatorBuilder.createKingOrValidators();
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            case PAWN -> {
                List<MovementValidator> orValidators = validatorBuilder.createChessPawnOrValidators(colour);
                return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
            }
            default -> throw new RuntimeException("Piece type not supported");
        }
    }
}
