package edu.austral.dissis.chess.rule.movement;

import edu.austral.dissis.chess.Board;
import edu.austral.dissis.chess.Movement;
import edu.austral.dissis.chess.Player;

public interface MovementRule {
    boolean validateRule(Movement movement, Board board, Player player);

    boolean checkPathBlocked(Movement movement, Board board, Player player);
}
