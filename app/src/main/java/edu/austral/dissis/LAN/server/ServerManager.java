package edu.austral.dissis.LAN.server;

import edu.austral.dissis.chess.gui.Move;
import edu.austral.ingsis.clientserver.Server;

public interface ServerManager {
    Server buildServer();

    void handleMovement(Move move);

    void stopServer();

    void sendInitialState(String clientId);
}
