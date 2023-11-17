package edu.austral.dissis.common.LAN.client.listener;

import edu.austral.dissis.common.LAN.client.ClientManager;
import edu.austral.ingsis.clientserver.ClientConnectionListener;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class ConnectionListener implements ClientConnectionListener {
    private final ClientManager clientManager;

    @Override
    public void handleConnection() {
        System.out.println("Connected to server!");
        clientManager.startConnection();
    }

    @Override
    public void handleConnectionClosed() {
        System.out.println("Connection closed!");
        clientManager.closeConnection();
    }
}
