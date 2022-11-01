package Exercise2.server;

import Exercise2.util.Message;

import java.util.ArrayList;
import java.util.List;

public class ConnectionPool
{
  private List<ServerSocketHandler> conns = new ArrayList<>();

  public void addClient(ServerSocketHandler ssh) {
    conns.add(ssh);
  }

  public void removeClient(ServerSocketHandler ssh) {
    if (conns.contains(ssh)) {
      conns.remove(ssh);
    }
  }

  public void broadcast(Message message, int clientNo) {
    System.out.println("Sending: " + message + " to client " + clientNo);
    for (ServerSocketHandler ssh: conns) {
      // ssh.sendMessageToClient(message, clientNo);
    }
}

}
