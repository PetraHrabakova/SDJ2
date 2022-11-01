package FunctionalityExercise.server;

import FunctionalityExercise.shared.LowerCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LowerCaseServerImpl implements LowerCaseServer
{
  public LowerCaseServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }

  @Override public String toLowerCase(String arg)
  {
    return arg.toLowerCase();
  }
}
