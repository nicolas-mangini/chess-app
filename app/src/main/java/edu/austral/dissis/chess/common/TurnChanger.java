package edu.austral.dissis.chess.common;

public interface TurnChanger {
    Colour getCurrentTurn();
    Colour getPreviousTurn();
}
