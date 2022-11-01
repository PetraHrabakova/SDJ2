package ToUppercaseSockets.server;

import ToUppercaseSockets.server.model.TextManagerImpl;
import ToUppercaseSockets.server.networking.RMIServerImpl;
import java.rmi.RemoteException;


public class RunServer {
    public static void main(String[] args) throws RemoteException
    {
        RMIServerImpl ss = new RMIServerImpl(new TextManagerImpl());
        ss.startServer();
    }
}
