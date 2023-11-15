
package edu.austral.dissis.LAN.server;

import edu.austral.dissis.LAN.server.listener.ServerConnectionCollectorListener;
import edu.austral.ingsis.clientserver.Message;
import edu.austral.ingsis.clientserver.Server;
import edu.austral.ingsis.clientserver.netty.server.NettyServerBuilder;

public class Main {
    public static void main(String[] args) {
        Server myServer = createServer();
        myServer.broadcast(new Message<>("all", "hola a todos"));
        myServer.start();
    }


    private static Server createServer() {
        return NettyServerBuilder
                .Companion
                .createDefault()
                .withPort(10000)
                .withConnectionListener(new ServerConnectionCollectorListener())
                .build();

    }
}
