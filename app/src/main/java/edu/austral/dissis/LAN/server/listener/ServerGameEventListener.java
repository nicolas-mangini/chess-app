package edu.austral.dissis.LAN.server.listener;

import edu.austral.dissis.LAN.server.ServerManager;
import edu.austral.dissis.chess.gui.GameEventListener;
import edu.austral.dissis.chess.gui.Move;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class ServerGameEventListener implements GameEventListener {
    private final ServerManager serverManager;
    @Override
    public void handleMove(@NotNull Move move) {
        serverManager.notifyMovement(move);
    }
}
