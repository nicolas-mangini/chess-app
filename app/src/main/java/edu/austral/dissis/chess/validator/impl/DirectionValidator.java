package edu.austral.dissis.chess.validator.impl;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Movement;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.validator.MoveValidator;
import lombok.AllArgsConstructor;

import java.util.Objects;

@AllArgsConstructor
//TODO change xDirection and yDirection to be a Vector -> may be static with predefined vectors
public class DirectionValidator implements MoveValidator {
    private final int xDirection;
    private final int yDirection;

    @Override
    public boolean isValid(Movement movement, Board board) {
        Tile position = new Tile(movement.getFrom().getX() + xDirection, movement.getFrom().getY() + yDirection, null);
        if (checkIfIsInsideBoard(position, board)) return false;
        while (!(Objects.equals(position.getX(), movement.getTo().getX()) && Objects.equals(position.getY(), movement.getTo().getY()))) {
            position = new Tile(position.getX() + xDirection, position.getY() + yDirection, null);
            if (checkIfIsInsideBoard(position, board)) return false;
        }
        return true;
    }


    private boolean checkIfIsInsideBoard(Tile position, Board board) {
        return position.getY() < 0 || position.getY() >= board.getMaxSquare().getY()
                || position.getX() < 0 || position.getX() >= board.getMaxSquare().getX();
    }
}
