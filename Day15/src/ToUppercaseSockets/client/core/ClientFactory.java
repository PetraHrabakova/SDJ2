package ToUppercaseSockets.client.core;

import ToUppercaseSockets.client.network.Client;
import ToUppercaseSockets.client.network.RMIClient;

public class ClientFactory {

    private Client client;

    public Client getClient() {
        if(client == null) {
            client = new RMIClient();
        }
        return client;
    }
}
