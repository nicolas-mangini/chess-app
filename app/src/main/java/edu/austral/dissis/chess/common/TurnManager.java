package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class TurnManager {
    private final Colour current;

    public TurnManager() {
        Random random = new Random();
        current = random.nextBoolean() ? Colour.WHITE : Colour.BLACK;
    }

    public TurnManager(TurnManager toCopy) {
        current = toCopy.getCurrent();
    }

    public TurnManager nextTurn() {
        Colour nextTurnPlayer = (current == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        return new TurnManager(nextTurnPlayer);
    }
}
