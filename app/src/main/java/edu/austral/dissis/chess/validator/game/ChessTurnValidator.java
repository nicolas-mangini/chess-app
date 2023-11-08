package edu.austral.dissis.chess.validator.game;

import edu.austral.dissis.chess.game.GameManager;
import edu.austral.dissis.chess.piece.Piece;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.validator.MovementValidator;

public class ChessTurnValidator implements MovementValidator {
    @Override
    public boolean isValid(Movement movement, Board board, GameManager gameManager) {
        Piece pieceToMove = movement.getFrom().getPiece();
        Colour currentColourTurn = gameManager.getTurnChanger().getCurrentTurn();
        return pieceToMove.getColour() == currentColourTurn;
    }
}
