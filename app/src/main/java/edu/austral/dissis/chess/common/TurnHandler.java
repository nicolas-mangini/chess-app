package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class TurnHandler {
    private final Colour current;

    public TurnHandler() {
        Random random = new Random();
        current = random.nextBoolean() ? Colour.WHITE : Colour.BLACK;
    }

    public TurnHandler(TurnHandler toCopy) {
        current = toCopy.getCurrent();
    }

    public TurnHandler nextTurn() {
        Colour nextTurnPlayer = (current == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        return new TurnHandler(nextTurnPlayer);
    }
}
