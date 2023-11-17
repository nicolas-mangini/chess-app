package edu.austral.dissis.common.util;


import edu.austral.dissis.checkers.builder.CheckersMovementBuilder;
import edu.austral.dissis.common.board.SimpleBoard;
import edu.austral.dissis.chess.builder.classic.ChessMovementBuilder;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.piece.PieceValidator;
import edu.austral.dissis.common.validator.piece.PieceType;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class PromoteUtils {
    public static boolean canPromote(Piece piece, Tile toTile) {
        return piece.getColour().equals(Colour.WHITE) && toTile.getX() == 1
                ||
                piece.getColour().equals(Colour.BLACK) && toTile.getX() == 8;
    }

    public static Board promoteChess(Piece piece, PieceType newPieceType, Tile toTile, Board board) {
        Board newBoard = new SimpleBoard(board);
        PieceValidator newPieceValidators = ChessMovementBuilder.createMovements(newPieceType, piece.getColour());
        Piece newPiece = new Piece(piece, newPieceType, newPieceValidators);
        newBoard.setPieceAtTile(newPiece, toTile);
        return newBoard;
    }

    public static Board promoteCheckers(Piece piece, PieceType newPieceType, Tile toTile, Board board) {
        Board newBoard = new SimpleBoard(board);
        PieceValidator newPieceValidators = CheckersMovementBuilder.createMovements(newPieceType, piece.getColour());
        Piece newPiece = new Piece(piece, newPieceType, newPieceValidators);
        newBoard.setPieceAtTile(newPiece, toTile);
        return newBoard;
    }
}
