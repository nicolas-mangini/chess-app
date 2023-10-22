package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;

@AllArgsConstructor
public class TurnHandler {
    private final PlayerColour current;

    public TurnHandler nextTurn() {
        PlayerColour nextTurnPlayer = (current == PlayerColour.WHITE) ? PlayerColour.BLACK : PlayerColour.WHITE;
        return new TurnHandler(nextTurnPlayer);
    }
}
