package ToUpperCaseMVVMSockets.server;

import ToUpperCaseMVVMSockets.server.model.TextManagerImpl;
import ToUpperCaseMVVMSockets.server.networking.SocketServer;

public class RunServer {
    public static void main(String[] args) {

        SocketServer ss = new SocketServer(new TextManagerImpl());
        ss.startServer();
    }
}
