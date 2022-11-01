package client.network;

import shared.network.ClientCallback;
import shared.network.RMIServer;
import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

public class RMIClient implements Client, ClientCallback
{
  private RMIServer server;
  private PropertyChangeSupport support;

  public RMIClient() {
    support = new PropertyChangeSupport(this);
  }


  @Override public void startClient()
  {
    try {
      UnicastRemoteObject.exportObject(this, 0);
      Registry registry = LocateRegistry.getRegistry("localhost", 1099);
      server = (RMIServer) registry.lookup("UppercaseServer");
      server.registerClient(this);
    }
    catch (RemoteException | NotBoundException e) {
      e.printStackTrace();
    }
  }

  @Override public void addUser(UserEntry user) {
    try {
      server.addUser(user);
    } catch (RemoteException e) {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }

  @Override public List<UserEntry> getUsers()
  {
    try {
      return server.getUsers();
    } catch (RemoteException e) {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }

  @Override public void addMessage(MessageEntry message)
  {
    try {
      server.addMessage(message);
    } catch (RemoteException e) {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }

  @Override public List<MessageEntry> getMessages()
  {
    try {
      return server.getMessages();
    } catch (RemoteException e) {
      throw new RuntimeException("Could not connect to the server :(");
    }
  }


  @Override public void addListener(String event, PropertyChangeListener listener) {
    support.addPropertyChangeListener(event, listener);
  }

  @Override public void removeListener(String event, PropertyChangeListener listener) {
    support.removePropertyChangeListener(event, listener);
  }

  @Override public void updateUserlist(UserEntry user) throws RemoteException {
    support.firePropertyChange("NewUserEntry", null, user);
  }

  @Override public void updateMessages(MessageEntry message) throws RemoteException {
    support.firePropertyChange("NewMessageEntry", null, message);
  }
}
