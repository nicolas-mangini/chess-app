package edu.austral.dissis.chess.adapter;

import edu.austral.dissis.chess.adapter.impl.ChessGameEngineAdapter;
import edu.austral.dissis.chess.common.*;
import edu.austral.dissis.chess.factory.PieceFactory;
import edu.austral.dissis.chess.gui.*;
import edu.austral.dissis.chess.util.impl.MovementResult;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ChessGameEngine implements GameEngine {
    private final GameEngineAdapter gameEngineAdapter;
    private final GameManager gameManager;

    public ChessGameEngine() {
        this.gameEngineAdapter = new ChessGameEngineAdapter();

        Board board = new Board(8, 8);
        Game game = new Game(Colour.WHITE, Colour.BLACK, board, new ArrayList<>());
        GameManager gameManager = new GameManager(game, new GameMover(), new TurnManager(Colour.WHITE));

        Piece rook1 = PieceFactory.createRookW1();
        Piece knight1 = PieceFactory.createKnightW1();
        Piece bishop1 = PieceFactory.createBishopW1();
        Piece king1 = PieceFactory.createKingW1();
        Piece queen1 = PieceFactory.createQueenW1();
        Piece bishop2 = PieceFactory.createBishopW2();
        Piece knight2 = PieceFactory.createKnightW2();
        Piece rook2 = PieceFactory.createRookW2();
        Piece pawn1 = PieceFactory.createPawnW1();
        Piece pawn2 = PieceFactory.createPawnW2();
        Piece pawn3 = PieceFactory.createPawnW3();
        Piece pawn4 = PieceFactory.createPawnW4();
        Piece pawn5 = PieceFactory.createPawnW5();
        Piece pawn6 = PieceFactory.createPawnW6();
        Piece pawn7 = PieceFactory.createPawnW7();
        Piece pawn8 = PieceFactory.createPawnW8();
        Piece rook3 = PieceFactory.createRookB1();
        Piece knight3 = PieceFactory.createKnightB1();
        Piece bishop3 = PieceFactory.createBishopB1();
        Piece king2 = PieceFactory.createKingB1();
        Piece queen2 = PieceFactory.createQueenB1();
        Piece bishop4 = PieceFactory.createBishopB2();
        Piece knight4 = PieceFactory.createKnightB2();
        Piece rook4 = PieceFactory.createRookB2();
        Piece pawn9 = PieceFactory.createPawnB1();
        Piece pawn10 = PieceFactory.createPawnB2();
        Piece pawn11 = PieceFactory.createPawnB3();
        Piece pawn12 = PieceFactory.createPawnB4();
        Piece pawn13 = PieceFactory.createPawnB5();
        Piece pawn14 = PieceFactory.createPawnB6();
        Piece pawn15 = PieceFactory.createPawnB7();
        Piece pawn16 = PieceFactory.createPawnB8();
        gameManager.getGame().getBoard().setPieceAtTile(rook1, rook1.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(knight1, knight1.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(bishop1, bishop1.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(king1, king1.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(queen1, queen1.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(bishop2, bishop2.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(knight2, knight2.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(rook2, rook2.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn1, pawn1.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn2, pawn2.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn3, pawn3.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn4, pawn4.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn5, pawn5.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn6, pawn6.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn7, pawn7.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn8, pawn8.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(rook3, rook3.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(knight3, knight3.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(bishop3, bishop3.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(king2, king2.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(queen2, queen2.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(bishop4, bishop4.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(knight4, knight4.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(rook4, rook4.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn9, pawn9.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn10, pawn10.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn11, pawn11.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn12, pawn12.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn13, pawn13.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn14, pawn14.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn15, pawn15.getInitialPosition());
        gameManager.getGame().getBoard().setPieceAtTile(pawn16, pawn16.getInitialPosition());

        this.gameManager = new GameManager(game, gameManager.getGameMover(), gameManager.getTurnManager());
    }

    @NotNull
    @Override
    public MoveResult applyMove(@NotNull Move move) {
        MovementResult<GameManager, String> tryMovement = gameManager.getGameMover().tryMovement(
                gameEngineAdapter.adaptMovement(move, gameManager.getGame().getBoard().getTiles())
                , gameManager);

        if (tryMovement.getValue().isPresent()) {
            return new InvalidMove(tryMovement.getValue().get());
        }

        List<ChessPiece> newPieces = gameEngineAdapter.getCurrentPieces(tryMovement.getKey().getGame().getBoard());
        PlayerColor newTurn = gameEngineAdapter.getCurrentTurn(tryMovement.getKey().getTurnManager());
        return new NewGameState(newPieces, newTurn);
    }

    @NotNull
    @Override
    public InitialState init() {
        return new InitialState(
                gameEngineAdapter.getBoardSize(gameManager.getGame().getBoard()),
                gameEngineAdapter.getCurrentPieces(gameManager.getGame().getBoard()),
                gameEngineAdapter.getCurrentTurn(gameManager.getTurnManager()));
    }
}
