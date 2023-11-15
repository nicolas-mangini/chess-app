package edu.austral.dissis.LAN.client.listener;

import edu.austral.dissis.LAN.client.ClientManager;
import edu.austral.dissis.chess.gui.GameEventListener;
import edu.austral.dissis.chess.gui.Move;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class ClientGameEventListener implements GameEventListener {
    private final ClientManager clientManager;

    @Override
    public void handleMove(@NotNull Move move) {
        clientManager.notifyMovement(move);
    }
}
