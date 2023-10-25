package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public class GameManager {
    private final Game game;
    private final GameMover gameMover;
    private final TurnChanger turnChanger;
}
