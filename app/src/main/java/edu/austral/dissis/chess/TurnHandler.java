package edu.austral.dissis.chess;

import lombok.Data;

@Data
public class TurnHandler {
    private final Player whitePlayer;
    private final Player blackPlayer;
    private final Player current;

    public TurnHandler(Player whitePlayer, Player blackPlayer) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.current = whitePlayer;
    }

}
