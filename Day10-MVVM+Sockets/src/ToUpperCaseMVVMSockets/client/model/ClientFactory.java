package ToUpperCaseMVVMSockets.client.model;

import ToUpperCaseMVVMSockets.client.network.Client;
import ToUpperCaseMVVMSockets.client.network.SocketClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new SocketClient();
        }
        return client;
    }
}
