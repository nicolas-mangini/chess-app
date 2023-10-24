package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.adapter.impl.ChessGameEngineAdapter;
import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.chess.util.impl.MovementResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

import static edu.austral.dissis.chess.factory.PieceFactory.createBishop;
import static edu.austral.dissis.chess.factory.PieceFactory.createRook;


public class ChessGameEngine implements GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final GameManager gameManager;

    public ChessGameEngine() {
        this.gameEngineAdapter = new ChessGameEngineAdapter();

        Board board = new Board(8, 8);
        Game game = new Game(Colour.WHITE, Colour.BLACK, board, new ArrayList<>());
        GameManager gameManager = new GameManager(game, new GameMover(), new TurnHandler(Colour.WHITE));

        Piece rook = createRook();
        Piece bishop = createBishop();
        gameManager.getGame().getBoard().setPieceAtTile(rook, rook.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(bishop, bishop.getInitialPosition());

        this.gameManager = new GameManager(game, gameManager.getGameMover(), gameManager.getTurnHandler());
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
