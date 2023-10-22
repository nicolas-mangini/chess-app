/*
package edu.austral.dissis.chess.validator.impl;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.validator.MoveValidator;

public class WithinBoundsValidator implements MoveValidator {
    //unnecessary, im already checking if is within bounds in the movement validator
    @Override
    public boolean isValid(Movement movement, Board board) {
        int toX = movement.getTo().getX();
        int toY = movement.getTo().getY();
        int maxX = board.getMaxSquare().getX();
        int maxY = board.getMaxSquare().getY();

        return toX < 0 || toX >= maxX || toY < 0 || toY >= maxY;
    }
}
*/
