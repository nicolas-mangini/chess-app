package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class TurnChanger {
    private final Colour current;

    public TurnChanger() {
        Random random = new Random();
        current = random.nextBoolean() ? Colour.WHITE : Colour.BLACK;
    }

    public TurnChanger(TurnChanger toCopy) {
        current = toCopy.getCurrent();
    }

    public TurnChanger nextTurn() {
        Colour nextTurnPlayer = (current == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        return new TurnChanger(nextTurnPlayer);
    }
}
