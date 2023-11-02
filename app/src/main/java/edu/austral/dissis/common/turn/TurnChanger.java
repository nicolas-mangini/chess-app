package edu.austral.dissis.common.turn;

import edu.austral.dissis.common.game.Colour;

public interface TurnChanger {
    TurnChanger nextTurn();
    Colour getCurrentTurn();
    Colour getPreviousTurn();
}
