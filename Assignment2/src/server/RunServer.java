package server;

import server.model.DataModelImpl;
import server.network.SocketServer;

public class RunServer {
  public static void main(String[] args)
  {
    SocketServer ss = new SocketServer(new DataModelImpl());
    ss.startServer();
  }
}
