package edu.austral.dissis.common.turn;

import edu.austral.dissis.common.game.Colour;
import lombok.AllArgsConstructor;

import java.util.Random;

@AllArgsConstructor
public class TwoPlayersTurnChanger implements TurnChanger {
    private final Colour currentTurn;

    public TwoPlayersTurnChanger() {
        Random random = new Random();
        currentTurn = random.nextBoolean() ? Colour.WHITE : Colour.BLACK;
    }

    public TwoPlayersTurnChanger nextTurn() {
        Colour nextTurnPlayer = (currentTurn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        return new TwoPlayersTurnChanger(nextTurnPlayer);
    }

    @Override
    public Colour getCurrentTurn() {
        return this.currentTurn;
    }

    @Override
    public Colour getPreviousTurn() {
        return (currentTurn == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
    }
}
