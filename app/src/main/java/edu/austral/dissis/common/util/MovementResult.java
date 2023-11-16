package edu.austral.dissis.common.util;

import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
public class MovementResult<GameManager, String> implements Result<GameManager, String> {
    private final GameManager game;
    private final String error;

    @Override
    public GameManager getKey() {
        return this.game;
    }

    @Override
    public Optional<String> getValue() {
        return Optional.ofNullable(this.error);
    }
}
