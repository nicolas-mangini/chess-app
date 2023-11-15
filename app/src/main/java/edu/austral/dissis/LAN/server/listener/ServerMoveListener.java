package edu.austral.dissis.LAN.server.listener;

import edu.austral.dissis.chess.gui.GameEventListener;
import edu.austral.dissis.chess.gui.Move;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class ServerMoveListener implements MessageListener<Move> {
    private final GameEventListener gameEventListener;

    @Override
    public void handleMessage(@NotNull Message<Move> message) {
        gameEventListener.handleMove(message.getPayload());
    }
}
