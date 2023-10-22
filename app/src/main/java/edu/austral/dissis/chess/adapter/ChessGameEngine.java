package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.adapter.impl.ChessGameEngineAdapter;
import edu.austral.dissis.chess.common.Game;
import edu.austral.dissis.chess.gui.*;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class ChessGameEngine implements GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final Game game;

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {

        Position from = move.getFrom();
        Position to = move.getTo();
        return null;
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(
                gameEngineAdapter.getBoardSize(game.getBoard()),
                gameEngineAdapter.getCurrentPieces(game.getBoard()),
                gameEngineAdapter.getCurrentTurn(game.getTurnHandler()));
        return null;
    }
}
