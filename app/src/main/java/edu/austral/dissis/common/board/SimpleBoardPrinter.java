package edu.austral.dissis.common.board;

import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.piece.Piece;

public class SimpleBoardPrinter implements BoardPrinter {
    @Override
    public String print(SimpleBoard board) {
        StringBuilder boardString = new StringBuilder();
        for (int i = 1; i <= board.getMaxSquare().getX(); i++) {
            boardString.append("\n");
            for (int j = 1; j <= board.getMaxSquare().getY(); j++) {
                Tile square = board.getTile(i, j).get();
                if (square.getPiece() != null) {
                    Piece p = square.getPiece();
                    String pieceString;
                    if (p.getColour() == Colour.WHITE) {
                        pieceString = p.getPieceType() + p.getId();
                    } else {
                        pieceString = "\u001B[1m" + p.getPieceType() + p.getId() + "\u001B[0m";
                    }
                    boardString.append("  ").append(pieceString).append("  ");
                } else {
                    boardString.append("   %s%s   ".formatted(square.getX(), square.getY()));
                }
            }
            boardString.append("\n");
        }
        boardString.append("\n");
        return boardString.toString();
    }
}
