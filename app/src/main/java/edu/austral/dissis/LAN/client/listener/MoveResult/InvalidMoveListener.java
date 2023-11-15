package edu.austral.dissis.LAN.client.listener.MoveResult;

import edu.austral.dissis.LAN.client.ClientManager;
import edu.austral.dissis.chess.gui.InvalidMove;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class InvalidMoveListener implements MessageListener<InvalidMove> {
    private final ClientManager clientManager;

    @Override
    public void handleMessage(@NotNull Message<InvalidMove> message) {
        clientManager.handleMoveResult(message.getPayload());
    }
}
