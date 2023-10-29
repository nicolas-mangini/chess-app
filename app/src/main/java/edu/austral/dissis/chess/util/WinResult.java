package edu.austral.dissis.chess.util;

import lombok.AllArgsConstructor;

import java.util.Optional;
@AllArgsConstructor
public class WinResult<Boolean, Colour> implements Result<Boolean, Colour> {
    private final Boolean winResult;
    private final Colour colour;

    @Override
    public Boolean getKey() {
        return this.winResult;
    }

    @Override
    public Optional<Colour> getValue() {
        return Optional.ofNullable(this.colour);
    }
}
