package ChatSystemMVVMSockets.client.model;

import ChatSystemMVVMSockets.client.network.Client;
import ChatSystemMVVMSockets.client.network.SocketClient;

public class ClientFactory
{
  private Client client;

  public Client getClient() {
    if (client == null) {
      client = new SocketClient();
    }
    return client;
  }
}
