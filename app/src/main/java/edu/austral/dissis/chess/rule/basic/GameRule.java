package edu.austral.dissis.chess.rule.basic;

import edu.austral.dissis.chess.Board;
import edu.austral.dissis.chess.Movement;
import edu.austral.dissis.chess.Player;

public interface GameRule {
    boolean validateRule(Movement movement, Board board, Player player);
}
