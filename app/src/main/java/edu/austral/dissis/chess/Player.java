package edu.austral.dissis.chess;

import lombok.Data;

@Data
public class Player {
    private final PlayerColour playerColour;

    public Player(PlayerColour playerColour) {
        this.playerColour = playerColour;
    }
}
