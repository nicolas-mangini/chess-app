package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Random;

@AllArgsConstructor
@Getter
public class TurnChanger {
    private final Colour currentTurn;

    public TurnChanger() {
        Random random = new Random();
        currentTurn = random.nextBoolean() ? Colour.WHITE : Colour.BLACK;
    }

    public TurnChanger(TurnChanger toCopy) {
        currentTurn = toCopy.getCurrentTurn();
    }

    public TurnChanger nextTurn() {
        Colour nextTurnPlayer = (currentTurn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        return new TurnChanger(nextTurnPlayer);
    }

    public Colour getPreviousTurn() {
        return (currentTurn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
    }
}
