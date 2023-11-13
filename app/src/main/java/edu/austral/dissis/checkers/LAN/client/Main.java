
package edu.austral.dissis.checkers.LAN.client;

import edu.austral.ingsis.clientserver.Client;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.netty.client.NettyClientBuilder;

import java.net.InetSocketAddress;

public class Main {
    public static void main(String[] args) {
        Client myClient = createClient();
        myClient.connect();

        myClient.send(new Message<>("dissis", "Hello World"));
    }

    private static Client createClient() {
        return NettyClientBuilder
                .Companion
                .createDefault()
                .withAddress(new InetSocketAddress("localhost", 10000))
                .withConnectionListener(new ClientConnectionCollectorListener())
                .build();
    }
}
