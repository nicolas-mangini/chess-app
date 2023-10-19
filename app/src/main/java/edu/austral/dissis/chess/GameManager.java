package edu.austral.dissis.chess;

import java.util.Optional;

public class GameManager {
    public GameManager() {
    }

    public Result<Board> move(Player player, Movement movement, Board board) {
        Board currentBoard = board.cloneBoard(board);
        Piece pieceToMove = movement.getFrom().getPiece();
        if (!validateMovement(pieceToMove, movement, board, player)) {
            return Result.failure("Invalid movement");
        }
        Tile from = movement.getFrom();
        Tile to = movement.getTo();
        currentBoard.getTiles().stream()
                .filter(square -> square.equals(to))
                .findFirst()
                .ifPresent(tile -> tile.setPiece(pieceToMove));

        currentBoard.getTiles().stream()
                .filter(square -> square.equals(from))
                .findFirst()
                .ifPresent(tile -> tile.setPiece(null));

        return Result.success(currentBoard);
    }

    public Result<Board> setPieceInSquare(Piece piece, Tile tile, Board board) {
        Board currentBoard = board.cloneBoard(board);
        Optional<Tile> tileOptional = currentBoard.getTiles().stream()
                .filter(tile1 -> tile1.equals(tile))
                .findFirst();
        if (tileOptional.isPresent()) {
            tileOptional.get().setPiece(piece);
            return Result.success(currentBoard);
        } else {
            return Result.failure("Tile not found");
        }
    }

    private boolean validateMovement(Piece piece, Movement movement, Board board, Player player) {
        return piece.getGameRules().stream()
                .allMatch(gameRule -> gameRule.validateRule(movement, board, player))
                &&
                piece.getMovementRules().stream()
                        .anyMatch(movementRule -> movementRule.validateRule(movement, board, player));
    }
}
