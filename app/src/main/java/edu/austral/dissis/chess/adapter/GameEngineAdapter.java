package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.common.Board;
import edu.austral.dissis.chess.common.Colour;
import edu.austral.dissis.chess.common.Tile;
import edu.austral.dissis.chess.common.TurnHandler;
import edu.austral.dissis.chess.gui.BoardSize;
import edu.austral.dissis.chess.gui.ChessPiece;
import edu.austral.dissis.chess.gui.PlayerColor;
import edu.austral.dissis.chess.gui.Position;

import java.util.List;

public interface GameEngineAdapter {
    BoardSize getBoardSize(Board board);

    List<ChessPiece> getCurrentPieces(Board board);

    PlayerColor getCurrentTurn(TurnHandler turnHandler);

    PlayerColor adaptPlayerColor(Colour colour);

    Position adaptPosition(Tile tile);
}
