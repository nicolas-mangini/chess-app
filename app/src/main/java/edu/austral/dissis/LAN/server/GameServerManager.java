package edu.austral.dissis.LAN.server;

import edu.austral.dissis.LAN.server.listener.ServerConnectionCollectorListener;
import edu.austral.dissis.chess.gui.GameEngine;
import edu.austral.ingsis.clientserver.Server;
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder;

public class GameServerManager implements ServerManager {
    private final Server server;
    private final GameEngine gameEngine;


    public GameServerManager(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.server = buildServer();
        this.server.start();
    }

    public Server buildServer() {
        return NettyServerBuilder.Companion
                .createDefault()
                .withPort(8080)
                .withConnectionListener(new ServerConnectionCollectorListener())
                .build();
    }
}
