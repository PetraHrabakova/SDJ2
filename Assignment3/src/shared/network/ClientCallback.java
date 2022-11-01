package shared.network;

import shared.transferobjects.MessageEntry;
import shared.transferobjects.UserEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void updateUserlist(UserEntry user) throws RemoteException;
  void updateMessages(MessageEntry message) throws RemoteException;
}
