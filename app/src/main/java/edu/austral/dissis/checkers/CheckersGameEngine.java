package edu.austral.dissis.checkers;

import edu.austral.dissis.checkers.builder.CheckersGameBuilder;
import edu.austral.dissis.chess.adapter.ChessGameEngineAdapter;
import edu.austral.dissis.chess.adapter.GameEngineAdapter;
import edu.austral.dissis.chess.game.Game;
import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.chess.game.GameMover;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.common.builder.GameBuilder;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.turn.TwoPlayersTurnChanger;
import edu.austral.dissis.common.util.MovementResult;
import edu.austral.dissis.common.util.Result;
import org.jetbrains.annotations.NotNull;

import java.util.List;
import java.util.Stack;

public class CheckersGameEngine implements GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final GameManager gameManager;
    private final Stack<GameManager> previousGameManagers = new Stack<>();

    public CheckersGameEngine() {
        this.gameEngineAdapter = new ChessGameEngineAdapter();

        GameBuilder gameBuilder = new CheckersGameBuilder();
        Game game = gameBuilder.build();

        this.gameManager = new GameManager(game, new GameMover(), new TwoPlayersTurnChanger(Colour.WHITE));
        previousGameManagers.push(this.gameManager);
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        GameManager previousGameManager = previousGameManagers.peek();
        Movement movementAdapted = gameEngineAdapter.adaptMovement(move, previousGameManager.getGame().getBoard().getTiles());

        MovementResult<GameManager, String> tryMovement = previousGameManager.getGameMover().tryMovement(movementAdapted, previousGameManager);

        if (tryMovement.getValue().isPresent()) {
            return new InvalidMove(tryMovement.getValue().get());
        }

        List<ChessPiece> newPieces = gameEngineAdapter.getCurrentPieces(tryMovement.getKey().getGame().getBoard());
        PlayerColor newTurn = gameEngineAdapter.getCurrentTurn(tryMovement.getKey().getTurnChanger());

        previousGameManagers.pop();
        previousGameManagers.push(tryMovement.getKey());


        //check if doing the movement you win -> before making the movement, i check that if the movement is checkmate
        Result<Boolean, Colour> isGameOver = previousGameManagers.peek().isGameOver(movementAdapted);
        if (isGameOver.getKey()) {
            Colour winner = isGameOver.getValue().get();
            return new GameOver(gameEngineAdapter.adaptPlayerColor(winner));
        }

        return new NewGameState(newPieces, newTurn);
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
