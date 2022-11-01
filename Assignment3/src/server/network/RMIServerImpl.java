package server.network;

import server.model.DataModel;
import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;

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
  private DataModel model;
  private Map<ClientCallback, PropertyChangeListener> listeners = new HashMap<>();

  public RMIServerImpl(DataModel model) throws RemoteException {
    UnicastRemoteObject.exportObject(this,0);
    this.model = model;
  }

  public void startServer() throws RemoteException, AlreadyBoundException {
    Registry registry = LocateRegistry.createRegistry(1099);
    registry.bind("UppercaseServer", this);
  }

  @Override public void addUser(UserEntry user) {
    model.addUser(user);
  }

  @Override public List<UserEntry> getUsers() {
    return model.getUsers();
  }

  @Override public void addMessage(MessageEntry message) {
    model.addMessage(message);
  }

  @Override public List<MessageEntry> getMessages() {
    return model.getMessages();
  }

  @Override public void registerClient(ClientCallback client) throws RemoteException {
    PropertyChangeListener listener = new PropertyChangeListener() {
      @Override public void propertyChange(PropertyChangeEvent evt) {
        try {
          if (evt.getPropertyName().equals("NewUserEntry")) {
            client.updateUserlist((UserEntry) evt.getNewValue());
          }
          else if (evt.getPropertyName().equals("NewMessageEntry")) {
            client.updateMessages((MessageEntry) evt.getNewValue());
          }
        }
        catch (RemoteException e) {
          e.printStackTrace();
        }
      }
    };
    listeners.put(client, listener);
    model.addListener("NewMessageEntry", listener);
    model.addListener("NewUserEntry", listener);
  }

  @Override public void unRegisterClient(ClientCallback client) throws RemoteException {
    PropertyChangeListener listener = listeners.get(client);
    if (listener != null) {
      model.removeListener("NewUserEntry", listener);
      model.removeListener("NewMessageEntry", listener);
    }
  }
}
