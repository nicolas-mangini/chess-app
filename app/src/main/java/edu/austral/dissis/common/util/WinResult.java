package edu.austral.dissis.common.util;

import edu.austral.dissis.common.game.Colour;
import lombok.AllArgsConstructor;

import java.util.Optional;

@AllArgsConstructor
// sobra el generics
public class WinResult<Boolean, Colour> implements Result<Boolean, Colour> {
    private final Boolean winResult;
    private final Colour colour;

    @Override
    public Boolean getKey() {
        return this.winResult;
    }

    @Override
    public Optional getValue() {
        return Optional.ofNullable(this.colour);
    }
}
