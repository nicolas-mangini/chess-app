package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.adapter.impl.ChessGameEngineAdapter;
import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.chess.util.impl.MovementResult;
import edu.austral.dissis.chess.validator.MovementValidator;
import edu.austral.dissis.chess.validator.impl.AndValidator;
import edu.austral.dissis.chess.validator.impl.move.DirectionValidator;
import edu.austral.dissis.chess.validator.impl.move.EatValidator;
import edu.austral.dissis.chess.validator.impl.move.PathClearValidator;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;


public class ChessGameEngine implements GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final GameManager gameManager;

    public ChessGameEngine() {
        this.gameEngineAdapter = new ChessGameEngineAdapter();

        Board board = new Board(8, 8);
        Game game = new Game(Colour.WHITE, Colour.BLACK, board, new ArrayList<>());
        GameManager gameManager = new GameManager(game, new GameMover(), new TurnHandler(Colour.WHITE));

        Piece rook = createRook();
        gameManager.getGame().getBoard().setPieceAtTile(rook, rook.getInitialPosition());

        this.gameManager = new GameManager(game, gameManager.getGameMover(), gameManager.getTurnHandler());
    }

    private static Piece createRook() {
        return Piece.builder()
                .id("1")
                .colour(Colour.WHITE)
                .initialPosition(new Tile(1, 1, null))
                .pieceId("rook")
                .orValidators(createRookOrValidators())
                .andValidators(new ArrayList<>())
                .build();
    }

    private static List<MovementValidator> createRookOrValidators() {
        List<MovementValidator> rookOrValidators = new ArrayList<>();

        AndValidator compositeValidator1 = new AndValidator(List.of(

                new DirectionValidator(1, 0),
                new PathClearValidator(1, 0),
                new EatValidator()
        ));

        AndValidator compositeValidator2 = new AndValidator(List.of(
                new DirectionValidator(-1, 0),
                new PathClearValidator(-1, 0)
        ));

        AndValidator compositeValidator3 = new AndValidator(List.of(
                new DirectionValidator(0, 1),
                new PathClearValidator(0, 1),
                new EatValidator()
        ));

        AndValidator compositeValidator4 = new AndValidator(List.of(
                new DirectionValidator(0, -1),
                new PathClearValidator(0, -1)
        ));
        rookOrValidators.add(compositeValidator1);
        rookOrValidators.add(compositeValidator2);
        rookOrValidators.add(compositeValidator3);
        rookOrValidators.add(compositeValidator4);

        return rookOrValidators;
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        MovementResult<GameManager, String> tryMovement = gameManager.getGameMover().tryMovement(
                gameEngineAdapter.adaptMovement(move, gameManager.getGame().getBoard().getTiles())
                , gameManager);

        if (tryMovement.getValue().isPresent()) {
            return new InvalidMove(tryMovement.getValue().get());
        }

        List<ChessPiece> newPieces = gameEngineAdapter.getCurrentPieces(tryMovement.getKey().getGame().getBoard());
        PlayerColor newTurn = gameEngineAdapter.getCurrentTurn(tryMovement.getKey().getTurnHandler());
        return new NewGameState(newPieces, newTurn);
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(
                gameEngineAdapter.getBoardSize(gameManager.getGame().getBoard()),
                gameEngineAdapter.getCurrentPieces(gameManager.getGame().getBoard()),
                gameEngineAdapter.getCurrentTurn(gameManager.getTurnHandler()));
    }
}
