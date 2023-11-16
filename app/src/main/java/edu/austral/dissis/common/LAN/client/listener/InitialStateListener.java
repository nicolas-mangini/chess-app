package edu.austral.dissis.common.LAN.client.listener;

import edu.austral.dissis.common.LAN.client.ClientManager;
import edu.austral.dissis.chess.gui.InitialState;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;

@AllArgsConstructor
public class InitialStateListener implements MessageListener<InitialState>{
    private final ClientManager clientManager;

    @Override
    public void handleMessage(@NotNull Message<InitialState> result) {
        clientManager.handleInitialState(result.getPayload());
    }
}
