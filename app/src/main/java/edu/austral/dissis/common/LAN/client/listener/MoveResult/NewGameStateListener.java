package edu.austral.dissis.common.LAN.client.listener.MoveResult;

import edu.austral.dissis.common.LAN.client.ClientManager;
import edu.austral.dissis.chess.gui.NewGameState;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class NewGameStateListener implements MessageListener<NewGameState> {
    private final ClientManager clientManager;

    @Override
    public void handleMessage(@NotNull Message<NewGameState> result) {
        clientManager.handleMoveResult(result.getPayload());
    }
}
