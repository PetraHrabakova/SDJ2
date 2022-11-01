package ToUppercaseSockets.server.networking;

import ToUppercaseSockets.server.model.TextManager;
import ToUppercaseSockets.shared.network.ClientCallback;
import ToUppercaseSockets.shared.network.RMIServer;
import ToUppercaseSockets.shared.transferobjects.LogEntry;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RMIServerImpl implements RMIServer
{
  private TextManager textManager;
  private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

  public RMIServerImpl(TextManager textManager) throws RemoteException
  {
    UnicastRemoteObject.exportObject(this, 0);
    this.textManager = textManager;
  }

  public void startServer() {
    Registry registry = null;
    try
    {
      registry = LocateRegistry.createRegistry(1099);
      registry.bind("UppercaseServer", this);
    }
    catch (RemoteException | AlreadyBoundException e)
    {
      e.printStackTrace();
    }
  }

  @Override public String toUppercase(String str) throws RemoteException
  {
    return textManager.toUppercase(str);
  }

  @Override public List<LogEntry> getLogs() throws RemoteException
  {
    return textManager.getLog();
  }

  @Override public void registerCallback(ClientCallback ccb) throws RemoteException
  {
    PropertyChangeListener listener = new PropertyChangeListener() {
      @Override
      public void propertyChange(PropertyChangeEvent evt) {
        try {
          ccb.update((LogEntry) evt.getNewValue());
        } catch (RemoteException e) {
          e.printStackTrace();
          textManager.removeListener("NewLogEntry", this);
        }
      }
    };
    listeners.put(ccb, listener);
    textManager.addListener("NewLogEntry", listener);


  }
}
