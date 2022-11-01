package FunctionalityExercise.client;

import FunctionalityExercise.shared.Server;
import FunctionalityExercise.shared.UpperCaseServer;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientImpl implements UpperCaseServer
{
  private Server server;

  public ClientImpl() {

  }

  public void initializeConnection() {
    try
    {
      Registry registry = LocateRegistry.getRegistry("localhost",1099);
      server = (Server) registry.lookup("Server");
    }
    catch (RemoteException | NotBoundException e)
    {
      e.printStackTrace();
    }
  }

  public String toUpperCase(String arg)
  {
    try
    {
      return server.getUpperCase().toUpperCase(arg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return "";
  }

  public String toLowerCase(String arg)
  {
    try
    {
      return server.getLowerCase().toLowerCase(arg);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
    return "";
  }
}
