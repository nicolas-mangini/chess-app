package edu.austral.dissis.LAN.client.listener;

import edu.austral.dissis.LAN.client.ClientManager;
import edu.austral.ingsis.clientserver.ClientConnectionListener;

public class ConnectionListener implements ClientConnectionListener {
    private final ClientManager clientManager;

    public ConnectionListener(ClientManager clientManager) {
        this.clientManager = clientManager;
    }

    @Override
    public void handleConnection() {
        clientManager.startConnection();
    }

    @Override
    public void handleConnectionClosed() {
        clientManager.closeConnection();
    }
}