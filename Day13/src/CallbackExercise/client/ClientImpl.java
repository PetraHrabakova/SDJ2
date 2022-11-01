package CallbackExercise.client;

import CallbackExercise.shared.UpperCaseClient;
import CallbackExercise.shared.UpperCaseServer;

import java.rmi.AlreadyBoundException;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ClientImpl implements UpperCaseClient
{
  private UpperCaseServer server;

  public ClientImpl() throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
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

  public void toUpperCase(String arg)
  {
    try
    {
      server.toUpperCase(arg, this);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }

  @Override public void upperCaseResult(String arg)
  {
    System.out.println("Result > " + arg);
  }
}
