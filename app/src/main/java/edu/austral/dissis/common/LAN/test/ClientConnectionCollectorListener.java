package edu.austral.dissis.common.LAN.test;

import edu.austral.ingsis.clientserver.ClientConnectionListener;

public class ClientConnectionCollectorListener implements ClientConnectionListener {
    boolean isConnected = false;

    @Override
    public void handleConnection() {
        System.out.println("Connected to server");
        isConnected = true;
    }

    @Override
    public void handleConnectionClosed() {
        System.out.println("Disconnected from server");
        isConnected = false;
    }
}
