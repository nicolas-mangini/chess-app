package edu.austral.dissis.chess;

import edu.austral.dissis.chess.rule.basic.GameRule;
import edu.austral.dissis.chess.rule.movement.MovementRule;
import lombok.Data;

import java.util.List;

@Data
public class Piece {
    private final String id;
    private final PlayerColour playerColour;
    private final List<MovementRule> movementRules; // OR-VALIDATORS (if one is true, the movement is valid)
    private final List<GameRule> gameRules; // AND-VALIDATORS (if one is false, the movement is invalid)
    private final boolean canJump;
    private final boolean canBackwards;

    public Piece(String id, PlayerColour playerColour, List<MovementRule> movementRules, List<GameRule> gameRules, boolean canJump, boolean canBackwards) {
        this.id = id;
        this.playerColour = playerColour;
        this.movementRules = movementRules;
        this.gameRules = gameRules;
        this.canJump = canJump;
        this.canBackwards = canBackwards;
    }
}
