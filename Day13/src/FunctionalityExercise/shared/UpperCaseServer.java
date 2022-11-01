package FunctionalityExercise.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote
{
  String toUpperCase(String arg) throws RemoteException;

}
