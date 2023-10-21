package edu.austral.dissis.chess.validator.impl.outdated;/*
package TP3.rule.movement;

import TP3.*;

public class PawnMovement implements MovementRule {
    private final int increment;
    private final GameManager gameManager;

    public PawnMovement(int increment, GameManager gameManager) {
        this.increment = increment;
        this.gameManager = gameManager;
    }

    @Override
    public boolean validateRule(Movement movement, Board board, Player player) {
        Piece pieceToMove = movement.getFrom().getPiece();
        int offsetX = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
        int offsetY = Math.abs(movement.getTo().getX() - movement.getFrom().getX());
        //first movement
        if (gameManager.getMovementsHistory(pieceToMove) > 0) {
            return offsetY == 2 && offsetY == increment || offsetY == 1 && offsetX && offsetX == 0;
        }
        //eat movement
        if (gameManager.isEatMovement(pieceToMove)) {
            return (offsetX == offsetY);
        } else {
            // simple movement
            return offsetY == 1 && offsetX == 0;
        }
    }

    @Override
    public boolean checkCollision(Movement movement, Board board, Player player) {
        return false;
    }
}
*/
