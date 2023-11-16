package edu.austral.dissis.chess.builder.classic;

import edu.austral.dissis.checkers.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;

import java.util.List;

public class ChessMovementBuilder {
    private final ValidatorBuilder validatorBuilder;

    public ChessMovementBuilder() {
        this.validatorBuilder = new edu.austral.dissis.chess.builder.common.ValidatorBuilder();
    }

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

    public PieceValidator createRookMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createRookOrValidators();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createKnightMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createKnightOrValidators();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createBishopMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createBishopOrValidators();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createQueenMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createQueenOrValidators();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createKingMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createKingOrValidators();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createPawnMovements(Colour colour) {
        List<MovementValidator> orValidators = validatorBuilder.createPawnOrValidators(colour);
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }
}