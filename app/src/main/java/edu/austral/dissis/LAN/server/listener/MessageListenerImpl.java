package edu.austral.dissis.LAN.server.listener;

import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.MessageListener;
import org.jetbrains.annotations.NotNull;

public class MessageListenerImpl implements MessageListener {
    @Override
    public void handleMessage(@NotNull Message message) {


        if (message.getPayload().equals("hello world")) {
            System.out.println("Received hello world");
        } else {
            System.out.println("Received: " + message.getPayload());
        }
    }
}
