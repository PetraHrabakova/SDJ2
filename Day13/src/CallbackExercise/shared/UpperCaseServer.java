package CallbackExercise.shared;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface UpperCaseServer extends Remote
{
  void toUpperCase(String arg, UpperCaseClient client) throws RemoteException;

}
