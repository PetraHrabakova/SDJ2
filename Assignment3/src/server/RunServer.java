package server;

import server.model.DataModelImpl;
import server.network.RMIServerImpl;

import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;

public class RunServer {
  public static void main(String[] args) throws RemoteException, AlreadyBoundException
  {
    RMIServerImpl ss = new RMIServerImpl(new DataModelImpl());
    ss.startServer();
  }
}
