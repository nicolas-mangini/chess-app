package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.checkers.validator.game.PiecesRemainingValidator;
import edu.austral.dissis.chess.builder.common.ValidatorBuilder;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;

import java.util.List;
import java.util.stream.Stream;

public class CustomChessMovementBuilder {
    private final ValidatorBuilder validatorBuilder;

    public CustomChessMovementBuilder() {
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

    public PieceValidator createChancellorMovements() {
        List<MovementValidator> rookOrValidators = validatorBuilder.createRookOrValidators();
        List<MovementValidator> knightOrValidators = validatorBuilder.createKnightOrValidators();
        List<MovementValidator> chancellorOrValidators = Stream.concat(rookOrValidators.stream(), knightOrValidators.stream()).toList();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(chancellorOrValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createKnightMovements() {
        List<MovementValidator> orValidators = validatorBuilder.createKnightOrValidators();
        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(orValidators), new CompoundAndValidator(specialValidators));
    }

    public PieceValidator createArchbishopMovements() {
        List<MovementValidator> bishopOrValidators = validatorBuilder.createBishopOrValidators();
        List<MovementValidator> knightOrValidators = validatorBuilder.createKnightOrValidators();
        List<MovementValidator> archbishopValidators = Stream.concat(knightOrValidators.stream(), bishopOrValidators.stream()).toList();

        List<MovementValidator> specialValidators = validatorBuilder.createSpecialValidators();
        return new PieceValidator(new CompoundOrValidator(archbishopValidators), new CompoundAndValidator(specialValidators));
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
