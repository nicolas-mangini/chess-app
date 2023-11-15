package edu.austral.dissis.LAN.server;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.austral.dissis.LAN.test.ServerConnectionCollectorListener;
import edu.austral.dissis.LAN.server.listener.ServerEventListener;
import edu.austral.dissis.LAN.server.listener.ServerGameEventListener;
import edu.austral.dissis.chess.gui.*;
import edu.austral.ingsis.clientserver.Message;
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

    @Override
    public Server buildServer() {
        GameEventListener gameEventListener = new ServerGameEventListener(this);
        return NettyServerBuilder.Companion
                .createDefault()
                .withPort(8080)
                .withConnectionListener(new ServerConnectionCollectorListener())
                .addMessageListener("move",
                        new TypeReference<>() {
                        },
                        new ServerEventListener(gameEventListener))
                .build();
    }

    @Override
    public void tryMovement(Move move) {
        MoveResult moveResult = gameEngine.applyMove(move);
        broadcastMovementResult(moveResult);
    }

    @Override
    public void stopServer() {
        server.stop();
    }

    @Override
    public void sendInitialState(String clientId) {
        Message<InitialState> message = new Message<>("initialState", gameEngine.init());
        server.sendMessage(clientId, message);
    }

    public void broadcastMovementResult(MoveResult moveResult) {
        if (moveResult instanceof NewGameState) {
            server.broadcast(new Message<>("newGameState", moveResult));
        } else if (moveResult instanceof GameOver) {
            server.broadcast(new Message<>("gameOver", moveResult));
        } else if (moveResult instanceof InvalidMove) {
            server.broadcast(new Message<>("invalidMove", moveResult));
        }
    }
}
