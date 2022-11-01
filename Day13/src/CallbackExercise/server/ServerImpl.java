package CallbackExercise.server;

import CallbackExercise.shared.UpperCaseClient;
import CallbackExercise.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements UpperCaseServer
{

  public ServerImpl() {
    try
    {
      UnicastRemoteObject.exportObject(this, 1099);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }



  @Override public void toUpperCase(String arg, UpperCaseClient client)
  {
    String result = arg.toUpperCase();
    // call client to retrieve the data
    // heavy stuff
    try
    {
      Thread.sleep(2000);
    }
    catch (InterruptedException e)
    {
      e.printStackTrace();
    }
    try
    {
      client.upperCaseResult(result);
    }
    catch (RemoteException e)
    {
      e.printStackTrace();
    }
  }
}
