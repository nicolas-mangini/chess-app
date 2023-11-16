package edu.austral.dissis.chess.game;

import edu.austral.dissis.chess.board.SimpleBoard;
import edu.austral.dissis.common.board.Board;
import edu.austral.dissis.common.game.*;
import edu.austral.dissis.common.piece.Piece;
import edu.austral.dissis.common.turn.TurnChanger;
import edu.austral.dissis.common.util.MovementResult;
import edu.austral.dissis.common.util.Result;
import edu.austral.dissis.common.validator.piece.PieceType;
import lombok.AllArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@AllArgsConstructor
public class ChessGameMover implements GameMover {
    @Override
    public Result<?, ?> tryMovement(Movement movement, GameManager gameManager) {
        Optional<Piece> pieceToMove = gameManager
                .getGame()
                .getBoard()
                .getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY());

        // if code enters here, return new invalid move
        if (!validateMovement(pieceToMove, movement, gameManager))
            return new MovementResult<>(gameManager, "Invalid movement!");

        Game movedGame = makeMovement(movement, gameManager.getGame());
        TurnChanger nextTurn = gameManager.getTurnChanger().nextTurn();
        GameManager movedGameManager = new GameManager(movedGame, this, nextTurn);

        //check if doing the movement you win -> before making the movement, i check that if the movement is checkmate
        Result<Boolean, Colour> isGameOver = movedGameManager.isGameOver(movement);
        if (isGameOver.getKey()) {
            return isGameOver;
        }

        return new MovementResult<>(movedGameManager, null);
    }

    private Game makeMovement(Movement movement, Game game) {
        SimpleBoard newBoard = new SimpleBoard(game.getBoard());
        Piece pieceToMove = newBoard.getPieceByTile(movement.getFrom().getX(), movement.getFrom().getY()).get();

        newBoard.setPieceAtTile(pieceToMove, movement.getTo());
        newBoard.setPieceAtTile(null, movement.getFrom());

        List<Movement> newHistory = new ArrayList<>(game.getHistory());
        newHistory.add(movement);

        if (PromoteUtils.canPromote(pieceToMove, movement.getTo())) {
            Board promotedBoard = PromoteUtils.promoteChess(pieceToMove, PieceType.QUEEN, movement.getTo(), newBoard);
            return new Game(game.getPlayer1(), game.getPlayer2(), promotedBoard, game.getGameValidators(), game.getGameOverValidators(), newHistory);
        }

        return new Game(game.getPlayer1(), game.getPlayer2(), newBoard, game.getGameValidators(), game.getGameOverValidators(), newHistory);
    }

    private boolean validateMovement(Optional<Piece> piece, Movement movement, GameManager gameManager) {
        return gameManager.getGame()
                .getGameValidators()
                .isValid(movement, gameManager.getGame().getBoard(), gameManager)
                &&
                piece.get().
                        getPieceValidator()
                        .isValid(movement, gameManager.getGame().getBoard(), gameManager);
    }
}
