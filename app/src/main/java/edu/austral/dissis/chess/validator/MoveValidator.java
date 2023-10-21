package edu.austral.dissis.chess.validator;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;

public interface MoveValidator {
    boolean isValid(Movement movement, Board board);
}
