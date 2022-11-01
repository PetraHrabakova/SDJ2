package BroadcastExercise.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote
{
  String toUpperCase(String arg, UpperCaseClient client) throws RemoteException;
  void registerClient(UpperCaseClient client) throws RemoteException;

}
