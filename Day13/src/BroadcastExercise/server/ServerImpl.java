package BroadcastExercise.server;

import BroadcastExercise.shared.UpperCaseClient;
import BroadcastExercise.shared.UpperCaseServer;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ServerImpl implements UpperCaseServer
{
  private List<UpperCaseClient> broadcastClients = new ArrayList<>();

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



  @Override public String toUpperCase(String arg, UpperCaseClient client)
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
    broadcastToClients(result, client);

    return result;
  }

  private void broadcastToClients(String arg, UpperCaseClient client) {
    for (UpperCaseClient broadcastClient: broadcastClients) {
      if (!broadcastClient.equals(client)) {
        try
        {
          broadcastClient.update(arg);
        }
        catch (RemoteException e)
        {
          e.printStackTrace();
        }
      }
    }
  }

  @Override public void registerClient(UpperCaseClient client)
  {
    broadcastClients.add(client);
  }
}
