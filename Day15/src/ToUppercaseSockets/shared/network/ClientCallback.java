package ToUppercaseSockets.shared.network;

import ToUppercaseSockets.shared.transferobjects.LogEntry;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ClientCallback extends Remote
{
  void update(LogEntry entry) throws RemoteException;
}
