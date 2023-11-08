package edu.austral.dissis.chess.builder;

import edu.austral.dissis.checkers.validator.game.EmptyPieces;
import edu.austral.dissis.chess.builder.common.ChessValidatorBuilder;
import edu.austral.dissis.common.builder.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import edu.austral.dissis.common.validator.CompoundOrValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;

import java.util.List;

public class ChessMovementBuilder implements ValidatorBuilder {
    private final ChessValidatorBuilder chessValidatorBuilder;

    public ChessMovementBuilder() {
        this.chessValidatorBuilder = new ChessValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate(),
                new EmptyPieces()
        );
    }

    public PieceMovementsValidator createRookMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createRookOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public PieceMovementsValidator createKnightMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createKnightOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public PieceMovementsValidator createBishopMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createBishopOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public PieceMovementsValidator createQueenMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createQueenOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public PieceMovementsValidator createKingMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createKingOrValidators();
        return new CompoundOrValidator(orValidators);
    }

    public PieceMovementsValidator createPawnMovements(Colour colour) {
        List<MovementValidator> orValidators = chessValidatorBuilder.createPawnOrValidators(colour);
        return new CompoundOrValidator(orValidators);
    }
}