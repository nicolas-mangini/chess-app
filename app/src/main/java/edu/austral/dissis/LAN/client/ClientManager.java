package edu.austral.dissis.LAN.client;

import com.fasterxml.jackson.core.type.TypeReference;
import edu.austral.dissis.LAN.client.listener.*;
import edu.austral.dissis.LAN.client.listener.MoveResult.GameOverListener;
import edu.austral.dissis.LAN.client.listener.MoveResult.InvalidMoveListener;
import edu.austral.dissis.LAN.client.listener.MoveResult.NewGameStateListener;
import edu.austral.dissis.chess.gui.*;
import edu.austral.ingsis.clientserver.Client;
import edu.austral.ingsis.clientserver.ClientConnectionListener;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder;

import java.net.InetSocketAddress;

public class ClientManager {
    private final Client client;
    private final GameView gameView;

    public ClientManager(GameView gameView) {
        this.client = buildClient();
        this.gameView = gameView;
        addListenersToGameView();
        startConnection();
    }

    public void notifyMovement(Move move) {
        client.send(new Message<>("move", move));
    }

    public void handleInitialState(InitialState initialState) {
        gameView.handleInitialState(initialState);
    }

    public void handleMoveResult(MoveResult moveResult) {
        gameView.handleMoveResult(moveResult);
    }

    public void startConnection() {
        client.connect();
    }

    public void closeConnection() {
        client.closeConnection();
    }

    private void addListenersToGameView(){
        gameView.addListener(new ClientGameEventListener(this));
    }

    private Client buildClient() {
        ClientConnectionListener connectionListener = new ConnectionListener(this);

        return NettyClientBuilder.Companion
                .createDefault()
                .withAddress(new InetSocketAddress("localhost", 8081))
                .withConnectionListener(connectionListener)
                .addMessageListener("initialState", new TypeReference<>() {
                }, new InitialStateListener(this))
                .addMessageListener("newGameState", new TypeReference<>() {
                }, new NewGameStateListener(this))
                .addMessageListener("gameOver", new TypeReference<>() {
                }, new GameOverListener(this))
                .addMessageListener("invalidMove", new TypeReference<>() {
                }, new InvalidMoveListener(this))
                .build();
    }
}
