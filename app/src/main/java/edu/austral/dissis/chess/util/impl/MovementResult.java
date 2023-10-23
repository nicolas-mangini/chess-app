package edu.austral.dissis.chess.util.impl;

import edu.austral.dissis.chess.util.Result;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class MovementResult<Game, String> implements Result<Game, String> {
    private final Game game;
    private final String error;

    @Override
    public Game getKey() {
        return this.game;
    }

    @Override
    public Optional<String> getValue() {
        return Optional.ofNullable(this.error);
    }
}
