package edu.austral.dissis.LAN.server.listener;

import edu.austral.dissis.LAN.server.ServerManager;
import edu.austral.ingsis.clientserver.ServerConnectionListener;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class ConnectionListener implements ServerConnectionListener {
    private final ServerManager serverManager;


    @Override
    public void handleClientConnection(@NotNull String clientId) {
        serverManager.sendInitialState(clientId);
    }

    @Override
    public void handleClientConnectionClosed(@NotNull String clientId) {
        serverManager.stopServer();
    }
}
