package edu.austral.dissis.common.turn;

import edu.austral.dissis.common.game.Colour;

public interface TurnChanger {
    Colour getCurrentTurn();
    Colour getPreviousTurn();
}
