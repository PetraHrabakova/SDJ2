package shared.network;

import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RMIServer extends Remote
{
  void addUser(UserEntry user) throws RemoteException;
  List<UserEntry> getUsers() throws RemoteException;
  void addMessage(MessageEntry message) throws RemoteException;
  List<MessageEntry> getMessages() throws RemoteException;
  void registerClient(ClientCallback client) throws RemoteException;
  void unRegisterClient(ClientCallback client) throws RemoteException;

}
