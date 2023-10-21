package edu.austral.dissis.chess.util.impl;

import edu.austral.dissis.chess.util.Result;

import java.util.Optional;

public class MoveResult<Game, String> implements Result<Game, String> {
    private final Game game;
    private final String error;

    public MoveResult(Game game, String error) {
        this.game = game;
        this.error = error;
    }

    @Override
    public Game getKey() {
        return this.game;
    }

    @Override
    public Optional<String> getValue() {
        return Optional.ofNullable(this.error);
    }
}
