package edu.austral.dissis.LAN.server;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.austral.dissis.LAN.server.listener.ConnectionListener;
import edu.austral.dissis.LAN.server.listener.ServerMoveListener;
import edu.austral.dissis.LAN.server.listener.ServerGameEventListener;
import edu.austral.dissis.chess.gui.*;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.Server;
import edu.austral.ingsis.clientserver.ServerConnectionListener;
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder;

public class ServerManager {
    private final Server server;
    private final GameEngine gameEngine;

    public ServerManager(GameEngine gameEngine) {
        this.gameEngine = gameEngine;
        this.server = buildNettyServer();
        startServer();
    }

    public void notifyMovement(Move move) {
        MoveResult moveResult = gameEngine.applyMove(move);
        broadcastMovementResult(moveResult);
    }

    public void sendInitialState(String clientId) {
        Message<InitialState> message = new Message<>("initialState", gameEngine.init());
        server.sendMessage(clientId, message);
    }

    public void startServer() {
        this.server.start();
    }

    public void stopServer() {
        this.server.stop();
    }

    private void broadcastMovementResult(MoveResult moveResult) {
        if (moveResult instanceof NewGameState) {
            server.broadcast(new Message<>("newGameState", moveResult));
        } else if (moveResult instanceof GameOver) {
            server.broadcast(new Message<>("gameOver", moveResult));
        } else if (moveResult instanceof InvalidMove) {
            server.broadcast(new Message<>("invalidMove", moveResult));
        }
    }

    private Server buildNettyServer() {
        GameEventListener gameEventListener = new ServerGameEventListener(this);
        ServerConnectionListener connectionListener = new ConnectionListener(this);

        return NettyServerBuilder.Companion.createDefault()
                .withPort(8081)
                .withConnectionListener(connectionListener)
                .addMessageListener("move",
                        new TypeReference<>() {
                        },
                        new ServerMoveListener(gameEventListener))
                .build();
    }
}
