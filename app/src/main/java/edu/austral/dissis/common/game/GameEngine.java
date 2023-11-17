package edu.austral.dissis.common.game;

import edu.austral.dissis.checkers.builder.CheckersGameBuilder;
import edu.austral.dissis.checkers.game.CheckersGameMover;
import edu.austral.dissis.chess.builder.classic.ClassicChessGameBuilder;
import edu.austral.dissis.chess.builder.custom.CustomChessGameBuilder;
import edu.austral.dissis.chess.game.ChessGameMover;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.common.adapter.Adapter;
import edu.austral.dissis.common.adapter.GameEngineAdapter;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.turn.TwoPlayersTurnChanger;
import edu.austral.dissis.common.util.MovementResult;
import edu.austral.dissis.common.util.Result;
import edu.austral.dissis.common.util.WinResult;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Stack;

public class GameEngine implements edu.austral.dissis.chess.gui.GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final GameManager gameManager;
    private final Stack<GameManager> previousGameManagers = new Stack<>();

    public GameEngine(GameType gameType) {
        this.gameEngineAdapter = new Adapter();

        GameBuilder gameBuilder;
        GameMover gameMover;

        switch (gameType) {
            case CHESS -> {
                gameBuilder = new ClassicChessGameBuilder();
                gameMover = new ChessGameMover();
            }
            case CUSTOM_CHESS -> {
                gameBuilder = new CustomChessGameBuilder();
                gameMover = new ChessGameMover();
            }
            case CHECKERS -> {
                gameBuilder = new CheckersGameBuilder();
                gameMover = new CheckersGameMover();
            }
            default -> throw new RuntimeException("Game type not supported");
        }

        Game game = gameBuilder.build();
        this.gameManager = new GameManager(game, gameMover, new TwoPlayersTurnChanger(Colour.WHITE));
        previousGameManagers.push(this.gameManager);
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        GameManager previousGameManager = previousGameManagers.peek();
        Movement movementAdapted = gameEngineAdapter.adaptMovement(move, previousGameManager.getGame().getBoard().getTiles());

        Result<?, ?> tryMovement = previousGameManager
                .getGameMover()
                .tryMovement(movementAdapted, previousGameManager);

        return handleMovementResult(tryMovement);
    }

    public MoveResult handleMovementResult(Result<?, ?> tryMovement) {
        if (tryMovement instanceof MovementResult) {
            // if string "Invalid movement!" is present
            if (tryMovement.getValue().isPresent()) {
                return new InvalidMove((String) tryMovement.getValue().get());
            } else {
                GameManager newGameManager = (GameManager) tryMovement.getKey();
                List<ChessPiece> newPieces = gameEngineAdapter.getCurrentPieces(newGameManager.getGame().getBoard());
                PlayerColor newTurn = gameEngineAdapter.getCurrentTurn(newGameManager.getTurnChanger());

                previousGameManagers.pop();
                previousGameManagers.push(newGameManager);

                return new NewGameState(newPieces, newTurn);
            }
        } else if (tryMovement instanceof WinResult) {
            Colour winner = (Colour) tryMovement.getValue().get();
            return new GameOver(gameEngineAdapter.adaptPlayerColor(winner));
        }
        return null;
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(
                gameEngineAdapter.getBoardSize(gameManager.getGame().getBoard()),
                gameEngineAdapter.getCurrentPieces(gameManager.getGame().getBoard()),
                gameEngineAdapter.getCurrentTurn(gameManager.getTurnChanger()));
    }
}
