package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class TurnHandler {
    private final Colour current;

    public TurnHandler nextTurn() {
        Colour nextTurnPlayer = (current == Colour.WHITE) ? Colour.BLACK : Colour.WHITE;
        return new TurnHandler(nextTurnPlayer);
    }
}
