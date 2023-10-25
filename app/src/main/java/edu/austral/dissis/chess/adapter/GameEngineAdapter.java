package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.gui.*;

import java.util.List;

public interface GameEngineAdapter {
    BoardSize getBoardSize(Board board);

    List<ChessPiece> getCurrentPieces(Board board);

    PlayerColor getCurrentTurn(TurnChanger turnChanger);

    PlayerColor adaptPlayerColor(Colour colour);

    Position adaptPosition(Tile tile);


    Movement adaptMovement(Move move, List<Tile> tiles);

    Tile adaptTile(Position position, List<Tile> tiles);
}
