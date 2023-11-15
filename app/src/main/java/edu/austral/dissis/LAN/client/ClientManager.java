package edu.austral.dissis.LAN.client;

import edu.austral.dissis.LAN.client.listener.ConnectionListener;
import edu.austral.dissis.chess.gui.GameView;
import edu.austral.ingsis.clientserver.Client;
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder;

import java.net.InetSocketAddress;

public class ClientManager {
    private final Client client;
    private final GameView gameView;

    public ClientManager(GameView gameView) {
        this.gameView = gameView;
        this.client = buildClient();
        startConnection();
    }

    public void startConnection() {
        client.connect();
    }

    public void closeConnection() {
        client.closeConnection();
    }

    private Client buildClient() {
        return NettyClientBuilder.Companion
                .createDefault()
                .withAddress(new InetSocketAddress("localhost", 8080))
                .withConnectionListener(new ConnectionListener(this))
                .build();
    }
}
