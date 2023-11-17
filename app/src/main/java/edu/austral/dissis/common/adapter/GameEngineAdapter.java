package edu.austral.dissis.common.adapter;

import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.board.Tile;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.common.game.Colour;
import edu.austral.dissis.common.game.Movement;
import edu.austral.dissis.common.turn.TurnChanger;

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
