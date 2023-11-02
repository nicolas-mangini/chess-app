package edu.austral.dissis.chess.builder.custom;

import edu.austral.dissis.chess.builder.common.ChessValidatorBuilder;
import edu.austral.dissis.chess.piece.SimplePieceMovementValidator;
import edu.austral.dissis.chess.validator.piece.CheckValidator;
import edu.austral.dissis.common.builder.ValidatorBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.validator.CompoundAndValidator;
import edu.austral.dissis.common.validator.GameOverValidator;
import edu.austral.dissis.common.validator.MovementValidator;
import edu.austral.dissis.common.validator.PieceMovementsValidator;
import edu.austral.dissis.chess.validator.game.CheckMate;
import edu.austral.dissis.common.validator.piece.*;

import java.util.List;
import java.util.stream.Stream;

public class CustomChessMovementBuilder implements ValidatorBuilder {
    private final ChessValidatorBuilder chessValidatorBuilder;

    public CustomChessMovementBuilder() {
        this.chessValidatorBuilder = new ChessValidatorBuilder();
    }

    @Override
    public List<GameOverValidator> buildGameOverValidators() {
        return List.of(
                new CheckMate()
        );
    }

    public PieceMovementsValidator createChancellorMovements() {
        List<MovementValidator> rookOrValidators = chessValidatorBuilder.createRookOrValidators();
        List<MovementValidator> knightOrValidators = chessValidatorBuilder.createKnightOrValidators();
        List<MovementValidator> chancellorOrValidators = Stream.concat(rookOrValidators.stream(), knightOrValidators.stream()).toList();

        List<MovementValidator> andValidators = chessValidatorBuilder.createDefaultValidators();
        return new SimplePieceMovementValidator(chancellorOrValidators, andValidators);
    }

    public PieceMovementsValidator createKnightMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createKnightOrValidators();
        List<MovementValidator> andValidators = chessValidatorBuilder.createDefaultValidators();
        return new SimplePieceMovementValidator(orValidators, andValidators);
    }

    public PieceMovementsValidator createArchbishopMovements() {
        List<MovementValidator> bishopOrValidators = chessValidatorBuilder.createBishopOrValidators();
        List<MovementValidator> knightOrValidators = chessValidatorBuilder.createKnightOrValidators();
        List<MovementValidator> archbishopValidators = Stream.concat(knightOrValidators.stream(), bishopOrValidators.stream()).toList();

        List<MovementValidator> andValidators = chessValidatorBuilder.createDefaultValidators();
        return new SimplePieceMovementValidator(archbishopValidators, andValidators);
    }

    public PieceMovementsValidator createQueenMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createQueenOrValidators();
        List<MovementValidator> andValidators = chessValidatorBuilder.createDefaultValidators();
        return new SimplePieceMovementValidator(orValidators, andValidators);
    }

    public PieceMovementsValidator createKingMovements() {
        List<MovementValidator> orValidators = chessValidatorBuilder.createKingOrValidators();
        List<MovementValidator> andValidators = chessValidatorBuilder.createDefaultValidators();
        return new SimplePieceMovementValidator(orValidators, andValidators);
    }

    public PieceMovementsValidator createPawnMovements(Colour colour) {
        List<MovementValidator> orValidators = chessValidatorBuilder.createPawnOrValidators(colour);
        List<MovementValidator> andValidators = chessValidatorBuilder.createDefaultValidators();
        return new SimplePieceMovementValidator(orValidators, andValidators);
    }
}