package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.turn.TwoPlayersTurnChanger;

import java.util.List;
import java.util.Optional;

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
                        tile.getPiece().getPieceType().toString().toLowerCase()))
                .toList();
    }

    @Override
    public PlayerColor getCurrentTurn(TwoPlayersTurnChanger turnChanger) {
        if (turnChanger.getCurrentTurn().equals(Colour.WHITE))
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

    @Override
    public Movement adaptMovement(Move move, List<Tile> boardTiles) {
        return new Movement(adaptTile(move.getFrom(), boardTiles), adaptTile(move.getTo(), boardTiles));
    }

    @Override
    public Tile adaptTile(Position position, List<Tile> boardTiles) {
        Optional<Tile> tileOptional = boardTiles.stream().filter(tile -> tile.getX() == position.getRow() && tile.getY() == position.getColumn()).findFirst();
        return tileOptional.map(tile -> new Tile(position.getRow(), position.getColumn(), tile.getPiece())).orElseGet(() -> new Tile(position.getRow(), position.getColumn(), null));
    }
}
