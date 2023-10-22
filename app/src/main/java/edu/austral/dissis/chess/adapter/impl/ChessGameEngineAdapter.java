package edu.austral.dissis.chess.adapter.impl;

import edu.austral.dissis.chess.adapter.GameEngineAdapter;
import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.common.TurnHandler;
import edu.austral.dissis.chess.gui.BoardSize;
import edu.austral.dissis.chess.gui.ChessPiece;
import edu.austral.dissis.chess.gui.PlayerColor;
import edu.austral.dissis.chess.gui.Position;

import java.util.List;

public class ChessGameEngineAdapter implements GameEngineAdapter {
    @Override
    public BoardSize getBoardSize(Board board) {
        return new BoardSize(board.getMaxSquare().getX(), board.getMaxSquare().getY());
    }

    @Override
    public List<ChessPiece> getCurrentPieces(Board board) {
        return board.getTiles().stream()
                .filter(tile -> tile.getPiece() != null)
                .map(tile -> new ChessPiece(
                        tile.getPiece().getId(),
                        adaptPlayerColor(tile.getPiece().getColour()),
                        adaptPosition(tile),
                        tile.getPiece().getPieceId()))
                .toList();
    }

    @Override
    public PlayerColor getCurrentTurn(TurnHandler turnHandler) {
        if (turnHandler.getCurrent().equals(Colour.WHITE))
            return PlayerColor.WHITE;
        else
            return PlayerColor.BLACK;
    }

    @Override
    public PlayerColor adaptPlayerColor(Colour colour) {
        if (colour == Colour.WHITE)
            return PlayerColor.WHITE;
        else
            return PlayerColor.BLACK;
    }

    @Override
    public Position adaptPosition(Tile tile) {
        return new Position(tile.getX(), tile.getY());
    }
}
