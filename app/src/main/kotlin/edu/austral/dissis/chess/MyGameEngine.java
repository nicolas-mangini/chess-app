package edu.austral.dissis.chess;

import edu.austral.dissis.chess.gui.*;
import org.jetbrains.annotations.NotNull;

public class MyGameEngine implements GameEngine {
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
        return null;
    }
}
