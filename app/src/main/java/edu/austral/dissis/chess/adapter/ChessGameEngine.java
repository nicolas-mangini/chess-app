package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.adapter.impl.ChessGameEngineAdapter;
import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.factory.PieceFactory;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.chess.util.impl.MovementResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class ChessGameEngine implements GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final GameManager gameManager;
    private final Stack<GameManager> previousGameManagers = new Stack<>();

    public ChessGameEngine() {
        this.gameEngineAdapter = new ChessGameEngineAdapter();
        Game game = new Game(Colour.WHITE, Colour.BLACK, new Board(PieceFactory.createAllPieces(), 8, 8), new ArrayList<>());
        this.gameManager = new GameManager(game, new GameMover(), new TurnChanger(Colour.WHITE));
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
