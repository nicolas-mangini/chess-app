package edu.austral.dissis.chess;

import lombok.Data;

import java.util.List;

@Data
public class Game {
    private final Player whitePlayer;
    private final Player blackPlayer;
    private final List<Piece> pieces;
    private final List<Movement> movementHistory;
    private final Board board;

    public Game(Player whitePlayer, Player blackPlayer, List<Piece> pieces, List<Movement> movementHistory, Board board) {
        this.whitePlayer = whitePlayer;
        this.blackPlayer = blackPlayer;
        this.pieces = pieces;
        this.movementHistory = movementHistory;
        this.board = board;
    }
}
