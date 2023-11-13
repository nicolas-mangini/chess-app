package edu.austral.dissis.checkers.LAN.server;

import edu.austral.ingsis.clientserver.ServerConnectionListener;
import org.jetbrains.annotations.NotNull;

import java.util.ArrayList;
import java.util.List;

public class ServerConnectionCollectorListener implements ServerConnectionListener {
    List<String> clients = new ArrayList<>();


    @Override
    public void handleClientConnection(@NotNull String clientId) {
        System.out.println("Client connected: " + clientId);
        clients.add(clientId);
    }

    @Override
    public void handleClientConnectionClosed(String clientId) {
        System.out.println("Client disconnected: " + clientId);
        clients.remove(clientId);
    }

    void clear() {
        clients.clear();
    }

}
