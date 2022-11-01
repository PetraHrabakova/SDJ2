package FunctionalityExercise.server;

import FunctionalityExercise.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class UpperCaseServerImpl implements UpperCaseServer
{
  public UpperCaseServerImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
  }


  @Override public String toUpperCase(String arg) throws RemoteException
  {
    return arg.toUpperCase();
  }
}
