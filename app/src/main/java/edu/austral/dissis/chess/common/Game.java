package edu.austral.dissis.chess.common;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@AllArgsConstructor
@Getter
public class Game {
    private final Colour player1;
    private final Colour player2;
    private final Board board;
    private final List<Movement> history;
}
