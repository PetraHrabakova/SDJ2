package UpperCaseExercise.client;

import UpperCaseExercise.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl implements UpperCaseServer
{
  private UpperCaseServer server;

  public ClientImpl() {

  }

  public void initializeConnection() {
    try
    {
      Registry registry = LocateRegistry.getRegistry("localhost",1099);
      server = (UpperCaseServer) registry.lookup("Server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  public String toUpperCase(String arg)
  {
    String result = null;
    try
    {
      result = server.toUpperCase(arg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return result;
  }
}
