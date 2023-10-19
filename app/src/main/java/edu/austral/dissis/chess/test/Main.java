
package edu.austral.dissis.chess.test;

import edu.austral.dissis.chess.*;
import edu.austral.dissis.chess.rule.basic.IsOwnPieceRule;
import edu.austral.dissis.chess.rule.movement.DiagonalMovement;
import edu.austral.dissis.chess.rule.movement.HorizontalMovement;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        GameManager gameManager = new GameManager();
        Player whitePlayer = new Player(PlayerColour.WHITE);
        Player blackPlayer = new Player(PlayerColour.BLACK);
        Board board = new Board(8, 8);
        List<Piece> pieces = createDefaultPieces(board, gameManager);
        Game game = new Game(whitePlayer, blackPlayer, pieces, new ArrayList<>(), board);

        //Diagonal
        System.out.println(board.displayBoard());
        Result<Board> move2 = gameManager.move(whitePlayer, new Movement(board.getTile(8, 3).getValue(), board.getTile(7, 4).getValue()), game.getBoard());
        System.out.println(board.displayBoard());
        Result<Board> move3 = gameManager.move(whitePlayer, new Movement(board.getTile(7, 4).getValue(), board.getTile(6, 5).getValue()), game.getBoard());
        System.out.println(board.displayBoard());
        Result<Board> move4 = gameManager.move(whitePlayer, new Movement(board.getTile(6, 5).getValue(), board.getTile(3, 8).getValue()), game.getBoard());
        System.out.println(board.displayBoard());

        //Horizontal
        Result<Board> move5 = gameManager.move(whitePlayer, new Movement(board.getTile(8, 1).getValue(), board.getTile(8, 5).getValue()), game.getBoard());
        System.out.println(board.displayBoard());
        Result<Board> move6 = gameManager.move(whitePlayer, new Movement(board.getTile(8, 8).getValue(), board.getTile(8, 6).getValue()), game.getBoard());
        System.out.println(board.displayBoard());
    }

    static List<Piece> createDefaultPieces(Board board, GameManager gameManager) {
        Piece bishop1 = new Piece("BW1", PlayerColour.WHITE, List.of(new DiagonalMovement()), new ArrayList<>(), false, false);
        Piece bishop2 = new Piece("BW2", PlayerColour.WHITE, List.of(new DiagonalMovement()), new ArrayList<>(), false, false);
        Piece rook1 = new Piece("RW1", PlayerColour.WHITE, List.of(new HorizontalMovement()), new ArrayList<>(), false, false);
        Piece rook2 = new Piece("RW2", PlayerColour.WHITE, List.of(new HorizontalMovement(1)), List.of(new IsOwnPieceRule()), false, false);
        Result<Board> board1 = gameManager.setPieceInSquare(bishop1, board.getTile(8, 3).getValue(), board);
        Result<Board> board2 = gameManager.setPieceInSquare(bishop2, board.getTile(8, 6).getValue(), board);
        Result<Board> board3 = gameManager.setPieceInSquare(rook1, board.getTile(8, 1).getValue(), board);
        Result<Board> board4 = gameManager.setPieceInSquare(rook2, board.getTile(8, 8).getValue(), board);
        return List.of(bishop1, bishop2, rook1);
    }


}

