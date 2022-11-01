package ChatSystemMVVMSockets.server;

import ChatSystemMVVMSockets.server.model.DataModelImpl;
import ChatSystemMVVMSockets.server.network.SocketServer;

public class RunServer {
  public static void main(String[] args)
  {
    SocketServer ss = new SocketServer(new DataModelImpl());
    ss.startServer();
  }
}
